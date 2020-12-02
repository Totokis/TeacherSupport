package com.example.project_nr_one

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GroupViewModel : ViewModel() {
    private val groups: MutableLiveData<List<Group>> by lazy {
        MutableLiveData<List<Group>>().also {
            loadGroups()
        }
    }

    fun getGroups(): LiveData<List<Group>> {
        return groups;
    }

    private fun loadGroups() {

    }
    // TODO: Implement the ViewModel
}