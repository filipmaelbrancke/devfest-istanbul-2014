package be.appfoundry.android.testing;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.webkit.WebView;
import be.appfoundry.android.testing.model.Person;
import be.appfoundry.android.testing.ui.activity.PersonListActivity;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

/**
 * @author Filip Maelbrancke
 */
public class PersonListEspressoTest extends ActivityInstrumentationTestCase2<PersonListActivity> {

    public PersonListEspressoTest() {
        super(PersonListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Espresso will not automatically launch the Activity, we must launch it via getActivity().
        getActivity();
    }

    public void testClickOnHoward() {
        // search for a row and perform action
        //onData(hasToString(startsWith("Sheldon"))).perform(click());
        onData(is(instanceOf(Person.class))).atPosition(0).perform(click());
    }

    public void testClickAmyPictureShouldOpenWikipedia() {

        onData(allOf(is(instanceOf(Person.class)), hasToString(containsString("Amy"))))
            .onChildView(withId(R.id.list_item_photo))
            .perform(click());

        // check if the wikipedia page is being loaded in the webview
        onView(withId(R.id.wikipedia_webview))
            .check(ViewAssertions.matches(loadsUrl("https://en.wikipedia.org/wiki/Mayim_Bialik")));
    }

    public static Matcher<View> loadsUrl(final String url) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                // only applies for a WebView
                if (!(view instanceof WebView)) {
                    return false;
                }
                WebView webView = (WebView) view;
                return webView.getUrl().equalsIgnoreCase(url);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("webview's url does not match");
            }
        };
    }
}
