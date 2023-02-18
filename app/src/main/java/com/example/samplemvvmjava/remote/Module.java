package com.example.samplemvvmjava.remote;


import com.google.gson.Gson;

import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@dagger.Module
@InstallIn(SingletonComponent.class)
public class Module {


    @Provides
    public OkHttpClient provideOkHttp() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    @Provides
    public MovieRemoteSource provideSource(Retrofit retrofit) {
        return retrofit.create(MovieRemoteSource.class);
    }


    static final String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/";
    static final String API_KEY = "000685b666299b11045d2bbd5b6e3562";

}
