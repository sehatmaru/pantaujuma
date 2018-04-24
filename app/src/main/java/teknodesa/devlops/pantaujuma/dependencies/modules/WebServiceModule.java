package teknodesa.devlops.pantaujuma.dependencies.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import teknodesa.devlops.pantaujuma.dependencies.webservices.PantauJumaAPI;

/**
 * Created by Marthin on 2/20/2018.
 */
@Module
public class WebServiceModule {
    public static final String ENDPOINT = "http://onanapi.marthinpsrb.com/";
    public static final String ACCESS_TOKEN_TEMP = "dev_onan";

    @Singleton
    @Provides
    public Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }

    @Singleton
    @Provides
    PantauJumaAPI provideService(Retrofit retrofit) {
        return retrofit.create(PantauJumaAPI.class);
    }
}
