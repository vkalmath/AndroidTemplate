package com.vk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vk.db.LEventDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        LoggerImpl.getLogger()?.initialize(applicationContext, "asd")
//
//        send_btn.setOnClickListener {
//            LEventDatabase.databaseWriteExecutor.execute {
//                LoggerImpl.getLogger()?.logEvent(send_btn.text.toString())
//            }
//
//        }

    }
}
