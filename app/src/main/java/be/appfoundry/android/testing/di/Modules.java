package be.appfoundry.android.testing.di;

import be.appfoundry.android.testing.service.BigBangServiceModule;

/**
 * @author Filip Maelbrancke
 */
public class Modules {

    static Object[] list() {
        return new Object[] {
            new BigBangServiceModule()
        };
    }
}
