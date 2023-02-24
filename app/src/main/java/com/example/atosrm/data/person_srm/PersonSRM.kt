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
    @ColumnInfo(name = "avatar") var avatar: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PersonSRM

        if (id != other.id) return false
        if (fullName != other.fullName) return false
        if (skills != other.skills) return false
        if (shortInfo != other.shortInfo) return false
        if (fullInfo != other.fullInfo) return false
        if (!avatar.contentEquals(other.avatar)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + fullName.hashCode()
        result = 31 * result + skills.hashCode()
        result = 31 * result + shortInfo.hashCode()
        result = 31 * result + fullInfo.hashCode()
        result = 31 * result + avatar.contentHashCode()
        return result
    }
}