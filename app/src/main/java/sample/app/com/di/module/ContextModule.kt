package sample.app.com.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import sample.app.com.di.scopes.AppScope

@Module
class ContextModule(private val context: Context) {

    @AppScope
    @Provides
    fun provideContext() = context
}