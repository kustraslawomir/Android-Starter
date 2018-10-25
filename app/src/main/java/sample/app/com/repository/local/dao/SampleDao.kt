package sample.app.com.repository.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sample.app.com.repository.local.entity.SampleEntity

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGoal(users: SampleEntity)

    @Query("SELECT * FROM sample WHERE sample_hash = :sampleHash")
    fun getSamples(sampleHash: String): LiveData<List<SampleEntity>>
}