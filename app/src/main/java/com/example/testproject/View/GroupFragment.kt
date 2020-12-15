package com.example.testproject.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testproject.R
import kotlinx.android.synthetic.main.group_fragment.view.*

class GroupFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.group_fragment, container, false)
        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_groupFragment_to_addGroup)
        }
        return view
    }
}