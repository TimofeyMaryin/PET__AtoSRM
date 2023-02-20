package com.example.atosrm.data.person_srm

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("person")
data class PersonSRM(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "full_name") var fullName: String,
    @ColumnInfo(name = "skills") var skills: String,
    @ColumnInfo var shortInfo: String,
    @ColumnInfo(name = "full_info") var fullInfo: String,
)