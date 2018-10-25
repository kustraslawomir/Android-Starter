package sample.app.com.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import sample.app.com.repository.local.dao.SampleDao
import sample.app.com.repository.local.entity.SampleEntity

@Database(entities = [(SampleEntity::class)], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun sampleDao(): SampleDao
}
