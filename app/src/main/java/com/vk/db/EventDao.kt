package com.vk.db

import androidx.room.*


@Entity(tableName = "event_table")
data class LEvent(val event: String, val time: Long, val userID: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

//data class EventMeta (val time: Long, val userID: String)


@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(event: LEvent)

    @Query("DELETE FROM event_table")
    fun deleteAll()
}
