package com.vk

import android.content.Context
import com.vk.db.LEvent
import com.vk.db.LEventDatabase


interface Logger {

    fun initialize(c: Context, userID: String)

    fun logEvent(event: String)


}

class LoggerImpl : Logger {

    private lateinit var db: LEventDatabase
    private lateinit var userId: String

    override fun initialize(c: Context, uid: String) {
        LEventDatabase.getDatabase(c)?.let {
            db = it
        }
        userId = uid
    }


    override fun logEvent(e: String) {
        val event = LEvent(e, System.currentTimeMillis(), userId)
        db.eventDao().insert(event)
    }

//    private fun helper(): EventMeta {
//        return EventMeta(System.currentTimeMillis(), userId);
//    }

    companion object {
        private var INSTANCE: Logger? = null

        internal fun getLogger():  Logger? {
            if (INSTANCE == null) {
                synchronized(LoggerImpl::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = LoggerImpl()
                    }
                }
            }
            return INSTANCE
        }
    }

}
