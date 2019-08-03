package com.valpu.seve.applicationtest.app

import android.app.Application
import com.valpu.seve.applicationtest.others.MySharedPreferences

val preferences: MySharedPreferences by lazy { MyApp.prefs!! }

class MyApp : Application() {

     companion object {
         var prefs: MySharedPreferences? = null
     }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}