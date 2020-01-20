package com.vk.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import java.util.concurrent.Executors


@Database(entities = [LEvent::class], version = 1, exportSchema = false)
abstract class LEventDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {

        @Volatile
        private var INSTANCE: LEventDatabase? = null
        private val NUMBER_OF_THREADS = 4
        internal val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        internal fun getDatabase(context: Context):  LEventDatabase? {
            if (INSTANCE == null) {
                synchronized(LEventDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            LEventDatabase::class.java, "event_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
