package cz.zweistein.android.infinitegarfieldminusgarfield;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class GetNewFlavorTextAsyncTask extends AsyncTask<Void, Integer, String> {
	
	MainActivity activity;

	public GetNewFlavorTextAsyncTask(MainActivity activity) {
		super();
		this.activity = activity;
	}

	@Override
	protected String doInBackground(Void... params) {

		String path = Configuration.BASE_URL + "api/getFlavorText.json";

		int responseCode = -1;
		try {

			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.connect();
			responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader r = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuilder total = new StringBuilder();
				String line;
				while ((line = r.readLine()) != null) {
				    total.append(line);
				}
				
				String jsonString = total.toString();
				
				JSONObject jsonObject = new JSONObject(jsonString);
				
				return jsonObject.getString("text");

			} else {
				return null;
			}

		} catch (Exception ex) {
			Log.e("Exception", ex.toString());
			return null;
		}

	}

	@Override
	protected void onPostExecute(String result) {
		activity.onFlavorText(result);
	}

}
