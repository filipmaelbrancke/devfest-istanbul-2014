package be.appfoundry.android.testing.service;

import android.os.AsyncTask;
import be.appfoundry.android.testing.PersonListFragment;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

/**
 * @author Filip Maelbrancke
 */
@Module(injects = {
    PersonListFragment.class
})
public class BigBangServiceModule {

    @Singleton
    @Provides
    public BigBangService provideBigBangService() {
        return new RestAdapter.Builder()
            .setEndpoint(BigBangService.URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setExecutors(AsyncTask.THREAD_POOL_EXECUTOR, new MainThreadExecutor())
            .build()
            .create(BigBangService.class);
    }
}
