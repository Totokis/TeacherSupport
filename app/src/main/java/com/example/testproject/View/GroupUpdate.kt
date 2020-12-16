package com.example.testproject.View

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testproject.Model.data.Group
import com.example.testproject.R
import com.example.testproject.ViewModel.GroupViewModel
import kotlinx.android.synthetic.main.fragment_group_update.*
import kotlinx.android.synthetic.main.fragment_group_update.view.*


class GroupUpdate : Fragment() {

    private val args by navArgs<GroupUpdateArgs>()

    private lateinit var mGroupViewModel: GroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_group_update, container, false)

        view.update_groupName_et.setText(args.currentGroup.groupName)

        mGroupViewModel = ViewModelProvider(this).get(GroupViewModel::class.java)

        view.update_group_button.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        val groupName = update_groupName_et.text.toString()

        if(inputCheck(groupName)){
            val updatedGroup = Group(args.currentGroup.id,groupName)
            mGroupViewModel.updateGroup(updatedGroup)
            Toast.makeText(requireContext(),"Gratuluje", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_groupUpdate_to_groupFragment)
        }
        else{
            Toast.makeText(requireContext(),"Wybacz, ale musisz wpisać dane", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(groupName:String):Boolean{
        return !groupName.isEmpty();

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setPositiveButton("Yes"){_,_->
            mGroupViewModel.deleteGroup(args.currentGroup)
            Toast.makeText(requireContext(),"Gratuluje, usunąłeś grupę, to niezwykłe !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_groupUpdate_to_groupFragment)
        }
        builder.setNegativeButton("No"){_,_->}
        builder.setTitle("Delete ${args.currentGroup.groupName} ?")
        builder.setMessage("Are you sure you want to wyjebać ${args.currentGroup.groupName} ?")
        builder.create().show()
    }

}