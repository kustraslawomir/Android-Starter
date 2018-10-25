package sample.app.com.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.util.concurrent.TimeUnit

import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import sample.app.com.repository.remote.RemoteRepository

@Module(includes = [ContextModule::class])
class NetworkModule {

    private val baseUrl = "http://sample/api/"

    @Provides
    @Singleton
    fun remoteRepository(retrofit: Retrofit): RemoteRepository = retrofit.create(RemoteRepository::class.java)


    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor { s -> Timber.e("NETWORK: %s", s) }
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setLenient()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

}
