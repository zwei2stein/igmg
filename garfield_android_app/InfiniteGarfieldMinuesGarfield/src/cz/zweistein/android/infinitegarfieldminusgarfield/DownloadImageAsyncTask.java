package cz.zweistein.android.infinitegarfieldminusgarfield;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

public class DownloadImageAsyncTask extends AsyncTask<String, Integer, Bitmap> {

	private ImageView imageView;

	public DownloadImageAsyncTask(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		
		String currentImageId = params[0];
			
		try {
			FileInputStream localFile = imageView.getContext().openFileInput(currentImageId);
			return BitmapFactory.decodeStream(localFile);
		} catch (FileNotFoundException e) {
			String path = Configuration.BASE_URL + "strips/" + currentImageId
					+ ".png";

			InputStream in = null;
			Bitmap bmp = null;
			int responseCode = -1;
			try {

				URL url = new URL(path);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setDoInput(true);
				con.connect();
				responseCode = con.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					// download
					in = con.getInputStream();
					bmp = BitmapFactory.decodeStream(in);
					in.close();
					
					FileOutputStream localFile = imageView.getContext().openFileOutput(currentImageId,  Context.MODE_PRIVATE);
					
					bmp.compress(CompressFormat.PNG, 0, localFile);
					
					return bmp;

				} else {
					return null;
				}

			} catch (Exception ex) {
				return null;
			}
		}

	}

	@Override
	protected void onPostExecute(Bitmap result) {
		if (result == null) {
			Toast.makeText(imageView.getContext(), R.string.no_connection_image,
					Toast.LENGTH_SHORT).show();
			imageView.setImageDrawable(imageView.getContext().getResources()
					.getDrawable(R.drawable.disconnected));
		} else {
			imageView.setImageBitmap(result);
		}
	}

}
