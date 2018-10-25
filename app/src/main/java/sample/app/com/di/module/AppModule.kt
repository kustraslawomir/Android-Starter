package sample.app.com.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import sample.app.com.SampleApplication
import sample.app.com.di.scopes.AppScope

@Module
class AppModule(private val application: SampleApplication) {

    @Provides
    @AppScope
    fun provideContext() : Context = application

}