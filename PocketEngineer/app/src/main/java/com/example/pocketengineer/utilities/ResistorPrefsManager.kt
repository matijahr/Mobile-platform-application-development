package com.example.pocketengineer

import android.content.Context

interface UserDataProvider{
    var firstBand  : Int
    var secondBand  : Int
    var multiplier  : Int
    var tolerance  : Int
    var resault : String
}

object ResistorPrefsManager: UserDataProvider{
    private val PREFS_FILE = "preferences"
    private val FIRST_BAND = "firstColor"
    private val SECOND_BAND = "secondColor"
    private val MULTIPLIER = "multiplier"
    private val TOLERANCE = "tolerance"
    private val RESULT = "result"

    override var firstBand: Int
        get() = getFirstBandIndex()
        set(value) = setFirstBandIndex(value)

    override var secondBand: Int
        get() = getSecondBandIndex()
        set(value) = setSecondBandIndex(value)

    override var multiplier: Int
        get() = getMultiplierIndex()
        set(value) = setMultiplierIndex(value)

    override var tolerance: Int
        get() = getToleranceIndex()
        set(value) = setToleranceIndex(value)

    override var resault: String
        get() = getResultValue()
        set(value) = setResultValue(value)

    // for resistors first band
    private fun setFirstBandIndex(value:Int) {
        PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit()
                .putInt(FIRST_BAND, value)
                .apply()
    }

    private fun getFirstBandIndex(): Int {
        return PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getInt(FIRST_BAND, 0)?: 0
    }


    // for resistors second band
    private fun setSecondBandIndex(value: Int) {
        PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit()
                .putInt(SECOND_BAND, value)
                .apply()
    }

    private fun getSecondBandIndex(): Int {
        return PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getInt(SECOND_BAND, 0)?: 0
    }


    // for resistor multiplier
    private fun setMultiplierIndex(value: Int) {
        PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit()
                .putInt(MULTIPLIER, value)
                .apply()
    }

    private fun getMultiplierIndex(): Int {
        return PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getInt(MULTIPLIER, 0) ?: 0
    }


    // for resistor tolerance
    private fun setToleranceIndex(value: Int) {
        PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit()
                .putInt(TOLERANCE, value)
                .apply()
    }

    private fun getToleranceIndex(): Int {
        return PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getInt(TOLERANCE, 0) ?: 0
    }


    // for resistor value
    private fun setResultValue(value: String) {
        PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE)
                .edit()
                .putString(RESULT, value)
                .apply()
    }

    private fun getResultValue(): String {
        return PocketEngineerApp.context.getSharedPreferences(
                PREFS_FILE,
                Context.MODE_PRIVATE
        ).getString(RESULT, " ") ?: " "
    }

}