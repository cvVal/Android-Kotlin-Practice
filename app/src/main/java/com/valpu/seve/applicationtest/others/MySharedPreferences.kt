package com.valpu.seve.applicationtest.others

import android.content.Context

class MySharedPreferences(context: Context) {

    //Nombre fichero
    private val fileName = "my_preferences"

    //Instancia Fichero
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)


    //Por cada una de las variables que vamos a guardar en nuesto fichero shared preferences
    var name: String
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}