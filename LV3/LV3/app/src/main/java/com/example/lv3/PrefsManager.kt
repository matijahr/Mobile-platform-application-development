package com.example.lv3

import android.content.Context

interface UserDataProvider{
    var birdCounter: Int
    var tvColor: String
}


object PrefsManager: UserDataProvider{

    private val PREFS_FILE = "preferences"
    private val COUNTER_ID = "counter_id"
    private val COLOR_ID = "color_id"

    override var birdCounter: Int
        get() = getCounter()
        set(value) = setCounter(value)

    override var tvColor: String
        get() = getColor()
        set(value) = setColor(value)


    //for color
    private fun getColor(): String {
        return BirdCounter.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getString(COLOR_ID, "#4A6572")?: "#4A6572"
    }

    private fun setColor(value: String){
        BirdCounter.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit()
                .putString(COLOR_ID, value)
                .apply()
    }


    //for counter
    private fun getCounter(): Int {
        return BirdCounter.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getInt(COUNTER_ID, 0)?:0
    }

    private fun setCounter(value: Int){
        BirdCounter.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit() // dobivamo Editor instancu koja se koristi za izmjenu SharedPreferences-a
                .putInt(COUNTER_ID, value)
                .apply() // pohranjujemo promjene
    }




}