package com.example.testproject.View

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.testproject.R
import com.example.testproject.ViewModel.GroupViewModel
import kotlinx.android.synthetic.main.group_fragment.view.*

class GroupFragment : Fragment(){

    private lateinit var mGroupViewModel: GroupViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.group_fragment, container, false)

        val adapter = GroupListAdapter()
        val recyclerView = view.recyclerview_group
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mGroupViewModel = ViewModelProvider(this).get(GroupViewModel::class.java)
        mGroupViewModel.readAllData.observe(viewLifecycleOwner, Observer { group->
            adapter.setData(group)
        })



        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_groupFragment_to_addGroup)
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setPositiveButton("Yes"){_,_->
            mGroupViewModel.deleteAllGroups()
            Toast.makeText(requireContext(),"Gratuluje, usunąłeś WSZYSTKO, to niezwykłe !", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){_,_->}
        builder.setTitle("Delete ALL gROuPs !?")
        builder.setMessage("Are you sure you want to delete ALL gROuPs ?")
        builder.create().show()

    }
}