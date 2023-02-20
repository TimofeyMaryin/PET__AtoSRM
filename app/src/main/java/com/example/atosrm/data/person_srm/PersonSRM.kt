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
    @Embedded @ColumnInfo(name = "short_info") var shortInfo: MutableList<String>,
    @ColumnInfo(name = "full_info") var fullInfo: String,
    @ColumnInfo(name = "Avatar", typeAffinity = ColumnInfo.BLOB) var avatar: ByteArray? = null
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
        if (avatar != null) {
            if (other.avatar == null) return false
            if (!avatar.contentEquals(other.avatar)) return false
        } else if (other.avatar != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + fullName.hashCode()
        result = 31 * result + skills.hashCode()
        result = 31 * result + shortInfo.hashCode()
        result = 31 * result + fullInfo.hashCode()
        result = 31 * result + (avatar?.contentHashCode() ?: 0)
        return result
    }
}
