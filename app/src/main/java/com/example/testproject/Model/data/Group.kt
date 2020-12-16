package com.example.testproject.Model.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "group_table")
data class Group(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val groupName: String
): Parcelable