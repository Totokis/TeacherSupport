package com.example.testproject.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testproject.Model.data.Group
import com.example.testproject.R
import com.example.testproject.ViewModel.GroupViewModel
import kotlinx.android.synthetic.main.fragment_add_group.*
import kotlinx.android.synthetic.main.fragment_add_group.view.*

class GroupAdd : Fragment() {

    private lateinit var mGroupViewModel: GroupViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_add_group, container, false)

        mGroupViewModel = ViewModelProvider(this).get(GroupViewModel::class.java)

        view.group_add_button.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val groupName = groupName_et.text.toString()

        if(inputCheck(groupName)){
            val group = Group(0,groupName)

            mGroupViewModel.addGroup(group)

            Toast.makeText(requireContext(),"Succesfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addGroup_to_groupFragment)
        }
        else{
            Toast.makeText(requireContext(),"Uzupełnij dane kurwo", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(groupName:String):Boolean{
        return !groupName.isEmpty();

    }

}