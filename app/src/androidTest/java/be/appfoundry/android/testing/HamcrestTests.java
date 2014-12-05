package be.appfoundry.android.testing;

import be.appfoundry.android.testing.hamcrest.IsNotANumber;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import junit.framework.TestCase;
import org.hamcrest.CoreMatchers;

/**
 * @author Filip Maelbrancke
 */
public class HamcrestTests extends TestCase {

    public void testSquareRootOfMinusOneIsNotANumber() {
        ViewMatchers.assertThat(Math.sqrt(-1), CoreMatchers.is(IsNotANumber.notANumber()));
    }
}
