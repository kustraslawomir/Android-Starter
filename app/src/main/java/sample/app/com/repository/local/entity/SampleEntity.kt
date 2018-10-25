package sample.app.com.repository.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample")
class SampleEntity(@ColumnInfo(name = "sample_hash") val sampleHash: String) {
    @PrimaryKey(autoGenerate = true) var sampleId: Int? = null
}