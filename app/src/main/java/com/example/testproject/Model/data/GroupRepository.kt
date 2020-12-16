package com.example.testproject.Model.data

import androidx.lifecycle.LiveData

class GroupRepository(private val groupDao: GroupDao) {

    val readAllData: LiveData<List<Group>> = groupDao.readAllData()

    suspend fun addGroup(group:Group){
        groupDao.addGroup(group)
    }

    suspend fun updateGroup(group: Group){
        groupDao.updateGroup(group)
    }

    suspend fun deleteGroup(group: Group){
        groupDao.deleteGroup(group)
    }

    suspend fun deleteAllGroups(){
        groupDao.deleteAllGroups()
    }
}