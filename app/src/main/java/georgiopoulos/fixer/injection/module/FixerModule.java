package georgiopoulos.fixer.injection.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import georgiopoulos.fixer.data.remote.api.FixerService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by domg on 14/10/2017.
 */

@Module
public class FixerModule{

    private final String baseUrl;

    public FixerModule(String baseUrl){this.baseUrl = baseUrl;}

    @Provides
    @Singleton
    public Gson provideGson(){
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        OkHttpClient client = new OkHttpClient();
        return client;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson,OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public FixerService provideFixer(Retrofit retrofit){
        return retrofit.create(FixerService.class);
    }
}
