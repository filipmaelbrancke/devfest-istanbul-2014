package be.appfoundry.android.testing.util;

import android.content.Context;
import android.content.Intent;
import be.appfoundry.android.testing.ui.activity.WikipediaActivity;

/**
 * @author Filip Maelbrancke
 */
public class AppUtils {

    public static void launchWikipedia(final Context context, final String url, final String title) {
        final Intent intent = new Intent(context, WikipediaActivity.class);
        intent.putExtra(WikipediaActivity.WIKIPEDIA_URL, url);
        intent.putExtra(WikipediaActivity.WIKIPEDIA_TITLE, title);
        context.startActivity(intent);
    }
}
