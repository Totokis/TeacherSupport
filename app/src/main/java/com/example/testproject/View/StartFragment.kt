package com.example.testproject.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.testproject.R
import kotlinx.android.synthetic.main.start_fragment.view.*

class StartFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.start_fragment, container, false)
        view.button.setOnClickListener{
            view.findNavController().navigate(R.id.action_startFragment_to_groupFragment)

        }
        return view;
    }
}