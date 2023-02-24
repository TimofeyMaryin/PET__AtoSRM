package com.example.atosrm.data.person_srm

import android.graphics.Bitmap
import androidx.room.*


@Entity("person")
data class PersonSRM(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "full_name") var fullName: String,
    @ColumnInfo(name = "skills") var skills: String,
    @TypeConverters(ShortInfoConverters::class) var shortInfo: List<String>,
    @ColumnInfo(name = "full_info") var fullInfo: String,
    @ColumnInfo(name = "avatar") var avatar: String,
)