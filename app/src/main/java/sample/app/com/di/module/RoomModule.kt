package sample.app.com.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import sample.app.com.SampleApplication
import sample.app.com.di.scopes.AppScope
import sample.app.com.repository.local.AppDataBase

@Module
class RoomModule(application: SampleApplication) {

    private val appDataBase: AppDataBase =
            Room.databaseBuilder<AppDataBase>(application, AppDataBase::class.java, "db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @AppScope
    fun provideDatabase() = appDataBase


    @Provides
    @AppScope
    fun provideSampleDao(database: AppDataBase) = database.sampleDao()


}