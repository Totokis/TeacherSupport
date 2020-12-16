package com.example.testproject.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.testproject.Model.data.Group
import com.example.testproject.Model.data.GroupDatabase
import com.example.testproject.Model.data.GroupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupViewModel(application: Application) : AndroidViewModel(application){

    val readAllData: LiveData<List<Group>>
    private val repository: GroupRepository

    init{
        val groupDao = GroupDatabase.getDatabase(application).groupDao()
        repository = GroupRepository(groupDao)
        readAllData = repository.readAllData

    }

    fun addGroup(group: Group){
        viewModelScope.launch(Dispatchers.IO){
            repository.addGroup(group)
        }
    }

    fun updateGroup(group: Group){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateGroup(group)
        }
    }

    fun deleteGroup(group: Group){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteGroup(group)
        }
    }

    fun deleteAllGroups(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllGroups()
        }
    }
}