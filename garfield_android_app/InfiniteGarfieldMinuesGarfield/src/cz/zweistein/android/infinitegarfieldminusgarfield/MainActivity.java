package cz.zweistein.android.infinitegarfieldminusgarfield;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NavUtils;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private JSONObject imageIdsModel;

	private String currentA;

	private String currentB;

	private String currentC;

	private String flavorText;

	private Random random;

	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		random = new Random();

		if (savedInstanceState != null) {

			if (savedInstanceState.getString("imageIdsModel") != null) {
				try {
					this.imageIdsModel = new JSONObject(
							savedInstanceState.getString("imageIdsModel"));
				} catch (JSONException e) {
				}
			}

			if (savedInstanceState.getString("currentA") != null) {
				DownloadImageAsyncTask taska = new DownloadImageAsyncTask(
						(ImageView) findViewById(R.id.comicsImageA));
				currentA = savedInstanceState.getString("currentA");
				taska.execute(new String[] { currentA });
			}
			if (savedInstanceState.getString("currentB") != null) {
				DownloadImageAsyncTask taska = new DownloadImageAsyncTask(
						(ImageView) findViewById(R.id.comicsImageB));
				currentB = savedInstanceState.getString("currentB");
				taska.execute(new String[] { currentB });
			}
			if (savedInstanceState.getString("currentC") != null) {
				DownloadImageAsyncTask taska = new DownloadImageAsyncTask(
						(ImageView) findViewById(R.id.comicsImageC));
				currentC = savedInstanceState.getString("currentC");
				taska.execute(new String[] { currentC });
			}

			if (savedInstanceState.getString("flavorText") != null) {
				onFlavorText(savedInstanceState.getString("flavorText"));
			} else {
				refreshFlavorText();
			}

		} else {
			refreshFlavorText();
		}

		if (imageIdsModel == null) {
			refreshImageIds();
		}

		findViewById(R.id.comicsImageA).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						refreshRandomA();
					}
				});

		findViewById(R.id.comicsImageB).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						refreshRandomB();
					}
				});

		findViewById(R.id.comicsImageC).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						refreshRandomC();
					}
				});

		findViewById(R.id.buttonRandomize).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						refreshRandomA();
						refreshRandomB();
						refreshRandomC();
						refreshFlavorText();
					}
				});

		findViewById(R.id.buttonShare).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						shareImage();
					}
				});

		findViewById(R.id.buttonHelp).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showHelp();
			}
		});

		Typeface tf = Typeface.createFromAsset(getAssets(), "WTTWmessy.ttf");
		((TextView) findViewById(R.id.flavorText)).setTypeface(tf);

		findViewById(R.id.flavorText).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				refreshFlavorText();
			}
		});

		if (savedInstanceState == null) {
			AppRater.appLaunched(this);
		}

		if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == ConnectionResult.SUCCESS) {
			adView = (AdView) findViewById(R.id.adView);
			adView.loadAd(new AdRequest.Builder().build());
		}

	}

	private void refreshImageIds() {
		GetNewImageIdAsyncTask task = new GetNewImageIdAsyncTask(this);
		task.execute(new Void[0]);
	}

	private File getOutputMediaFile() {
		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"igmg");

		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				return null;
			}
		}

		File mediaFile = new File(mediaStorageDir.getPath() + File.separator
				+ "igmg_" + getImageCode() + ".jpg");

		return mediaFile;
	}

	private String getImageCode() {
		StringBuilder base = new StringBuilder();

		base.append(this.currentA).append("|").append(this.currentB)
				.append("|").append(this.currentC);

		return Base64.encodeToString(base.toString().getBytes(),
				Base64.NO_PADDING).trim();
	}

	public String getUrl() {

		StringBuilder base = new StringBuilder();

		base.append(this.currentA).append("|").append(this.currentB)
				.append("|").append(this.currentC);

		return Configuration.BASE_URL + "strip." + random.nextInt() + "."
				+ getImageCode() + ".html";

	}

	protected void shareImage() {

		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {

			File outputMediaFile = getOutputMediaFile();

			Bitmap result = Bitmap.createBitmap(167 * 3, 149 + 20,
					Config.ARGB_8888);

			Canvas canvas = new Canvas(result);

			canvas.drawColor(Color.WHITE);

			Bitmap bitmapA = ((BitmapDrawable) ((ImageView) findViewById(R.id.comicsImageA))
					.getDrawable()).getBitmap();
			canvas.drawBitmap(bitmapA, 0, 0, new Paint());
			Bitmap bitmapB = ((BitmapDrawable) ((ImageView) findViewById(R.id.comicsImageB))
					.getDrawable()).getBitmap();
			canvas.drawBitmap(bitmapB, 167, 0, new Paint());
			Bitmap bitmapV = ((BitmapDrawable) ((ImageView) findViewById(R.id.comicsImageC))
					.getDrawable()).getBitmap();
			canvas.drawBitmap(bitmapV, 167 * 2, 0, new Paint());

			if (flavorText != null) {
				Paint fontPaint = new Paint();
				fontPaint.setTypeface(Typeface.createFromAsset(getAssets(),
						"WTTWmessy.ttf"));
				fontPaint.setColor(Color.rgb(128, 128, 128));
				fontPaint.setAntiAlias(true);
				fontPaint.setTextSize(20);
				fontPaint.setTextAlign(Align.CENTER);
				canvas.drawText(flavorText, canvas.getWidth() / 2,
						canvas.getHeight() - 4, fontPaint);
			}

			FileOutputStream out = null;
			try {
				out = new FileOutputStream(outputMediaFile);
				result.compress(Bitmap.CompressFormat.JPEG, 90, out);
			} catch (FileNotFoundException e) {
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
					}
				}
			}

			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("image/jpeg");
			intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(outputMediaFile));
			intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name)
					+ ": " + flavorText);
			intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name)
					+ ": " + flavorText + " - " + getString(R.string.app_at)
					+ " " + Configuration.BASE_URL);
			startActivity(Intent.createChooser(intent,
					getString(R.string.share_image)));
		} else {
			Toast.makeText(this, getString(R.string.no_external_storage),
					Toast.LENGTH_SHORT).show();
		}

	}

	protected void showHelp() {
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		if (AppRater.wasRated(this)) {
			menu.findItem(R.id.action_rate).setVisible(false);
		}

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_about:
			showHelp();
			return true;
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_randomize:
			refreshRandomA();
			refreshRandomB();
			refreshRandomC();
			refreshFlavorText();
			return true;
		case R.id.action_share_image:
			shareImage();
			return true;
		case R.id.action_open_browser:
			Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri
					.parse(getUrl()));
			startActivity(intent);
			return true;
		case R.id.action_rate:
			AppRater.showRateDialog(this);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private String getRandomImageId(String section) {
		try {
			JSONArray a = (JSONArray) imageIdsModel.get(section);
			return a.getString(random.nextInt(a.length()));
		} catch (JSONException e) {
			return "0000";
		}
	}

	private void refreshRandomA() {
		if (imageIdsModel != null) {

			((ImageView) findViewById(R.id.comicsImageA))
					.setImageDrawable(getApplicationContext().getResources()
							.getDrawable(R.drawable.wait));

			DownloadImageAsyncTask taska = new DownloadImageAsyncTask(
					(ImageView) findViewById(R.id.comicsImageA));
			currentA = getRandomImageId("a");
			taska.execute(new String[] { currentA });
		} else {
			refreshImageIds();
		}
	}

	private void refreshRandomB() {
		if (imageIdsModel != null) {
			((ImageView) findViewById(R.id.comicsImageB))
					.setImageDrawable(getApplicationContext().getResources()
							.getDrawable(R.drawable.wait));

			DownloadImageAsyncTask taska = new DownloadImageAsyncTask(
					(ImageView) findViewById(R.id.comicsImageB));
			currentB = getRandomImageId("b");
			taska.execute(new String[] { currentB });
		} else {
			refreshImageIds();
		}
	}

	private void refreshRandomC() {
		if (imageIdsModel != null) {
			((ImageView) findViewById(R.id.comicsImageC))
					.setImageDrawable(getApplicationContext().getResources()
							.getDrawable(R.drawable.wait));

			DownloadImageAsyncTask taska = new DownloadImageAsyncTask(
					(ImageView) findViewById(R.id.comicsImageC));
			currentC = getRandomImageId("c");
			taska.execute(new String[] { currentC });
		} else {
			refreshImageIds();
		}
	}

	private void refreshFlavorText() {
		onFlavorText("");
		GetNewFlavorTextAsyncTask taska = new GetNewFlavorTextAsyncTask(this);
		taska.execute(new Void[0]);
	}

	public void onImageIds(String imageIds) {

		if (imageIds == null) {
			Toast.makeText(getApplicationContext(), R.string.no_connection,
					Toast.LENGTH_LONG).show();
			((ImageView) findViewById(R.id.comicsImageC))
					.setImageDrawable(getResources().getDrawable(
							R.drawable.disconnected));
		} else {
			try {
				this.imageIdsModel = new JSONObject(imageIds);
			} catch (JSONException e) {
			}
		}

		if (this.imageIdsModel != null) {
			refreshRandomA();
			refreshRandomB();
			refreshRandomC();
			refreshFlavorText();
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString("currentA", currentA);
		outState.putString("currentB", currentB);
		outState.putString("currentC", currentC);
		outState.putString("flavorText", flavorText);
		if (imageIdsModel != null) {
			outState.putString("imageIdsModel", imageIdsModel.toString());
		}

	}

	public void onFlavorText(String flavorText) {
		this.flavorText = flavorText;
		((TextView) findViewById(R.id.flavorText)).setText(flavorText);
	}

	@Override
	public void onPause() {
		super.onPause();
		if (adView != null) {
			adView.pause();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (adView != null) {
			adView.resume();
		}
	}

	@Override
	public void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}

}
