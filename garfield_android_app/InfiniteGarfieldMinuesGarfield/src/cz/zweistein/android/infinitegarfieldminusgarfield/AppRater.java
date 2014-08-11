package cz.zweistein.android.infinitegarfieldminusgarfield;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppRater {

	private final static String APP_PNAME = "cz.zweistein.android.infinitegarfieldminusgarfield";

	private final static int[] LAUNCHES_UNTIL_PROMPT = { 5, 8, 13, 21, 34, 45,
			89 };

	private final static String WAS_RATED = "wasrated";
	private final static String DONT_SHOW_AGAIN = "dontshowagain";
	private final static String LAUNCH_COUNT = "launch_count";

	private final static String SHARED_REFERENCES_NAME = "apprater";

	public static boolean wasRated(Context mContext) {
		SharedPreferences prefs = mContext.getSharedPreferences(
				SHARED_REFERENCES_NAME, 0);
		return prefs.getBoolean(WAS_RATED, false);
	}

	public static void appLaunched(Context mContext) {
		SharedPreferences prefs = mContext.getSharedPreferences(
				SHARED_REFERENCES_NAME, 0);
		if (prefs.getBoolean(DONT_SHOW_AGAIN, false)
				|| prefs.getBoolean(WAS_RATED, false)) {
			return;
		}

		SharedPreferences.Editor editor = prefs.edit();

		long launchCount = prefs.getLong(LAUNCH_COUNT, 0) + 1;
		editor.putLong(LAUNCH_COUNT, launchCount);
		editor.commit();

		// Wait at least n days before opening

		for (int i = 0; i < LAUNCHES_UNTIL_PROMPT.length; i++) {
			if (launchCount == LAUNCHES_UNTIL_PROMPT[i]) {
				showRateDialog(mContext);
			}
		}

	}

	public static void showRateDialog(final Context mContext) {
		SharedPreferences prefs = mContext.getSharedPreferences(
				SHARED_REFERENCES_NAME, 0);
		final Editor editor = prefs.edit();
		final Dialog dialog = new Dialog(mContext);
		dialog.setTitle(mContext.getString(R.string.rate)
				+ mContext.getString(R.string.app_name));

		LinearLayout ll = new LinearLayout(mContext);
		ll.setOrientation(LinearLayout.VERTICAL);

		TextView tv = new TextView(mContext);
		tv.setText(mContext.getString(R.string.rate_blub_start)
				+ mContext.getString(R.string.app_name)
				+ mContext.getString(R.string.rate_blub_end));
		tv.setWidth(240);
		tv.setPadding(4, 0, 4, 10);
		ll.addView(tv);

		Button b1 = new Button(mContext);
		b1.setText(mContext.getString(R.string.rate)
				+ mContext.getString(R.string.app_name));
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("market://details?id=" + APP_PNAME)));
				editor.putBoolean(WAS_RATED, true);
				editor.commit();
				dialog.dismiss();
			}
		});
		ll.addView(b1);

		Button b2 = new Button(mContext);
		b2.setText(mContext.getString(R.string.remind_me_later));
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		ll.addView(b2);

		Button b3 = new Button(mContext);
		b3.setText(mContext.getString(R.string.no_thanks));
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (editor != null) {
					editor.putBoolean(DONT_SHOW_AGAIN, true);
					editor.commit();
				}
				dialog.dismiss();
			}
		});
		ll.addView(b3);

		dialog.setContentView(ll);
		dialog.show();
	}
}