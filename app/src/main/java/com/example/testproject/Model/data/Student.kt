package com.example.testproject.Model.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val lastName: String
): Parcelable