package com.example.atosrm.data.person_srm

import androidx.room.TypeConverter

class ShortInfoConverters {

    @TypeConverter
    fun fromStringToList(value: String): List<String> {
        val words = value.split(",")
        return words.map {  it.trim() }
    }

    @TypeConverter
    fun fromListToString(value: List<String>): String {
        var res: String = ""

        value.forEach {
            res += it
        }

        return res
    }

}