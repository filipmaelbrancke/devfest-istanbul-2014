package be.appfoundry.android.testing;

import android.test.ActivityInstrumentationTestCase2;
import be.appfoundry.android.testing.model.Person;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
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
}
