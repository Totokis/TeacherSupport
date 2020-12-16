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
import com.example.testproject.Model.data.Student
import com.example.testproject.R
import com.example.testproject.ViewModel.GroupViewModel
import com.example.testproject.ViewModel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_add_group.*
import kotlinx.android.synthetic.main.fragment_add_group.view.*
import kotlinx.android.synthetic.main.fragment_student_add.*
import kotlinx.android.synthetic.main.fragment_student_add.view.*


class StudentAdd : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_student_add, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.add_student_button.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val studentName = student_name_et.text.toString()
        val studentLastName = student_last_name_et.text.toString()

        if(inputCheck(studentName,studentLastName)){
            val student = Student(0,studentName,studentLastName)

            mStudentViewModel.addStudent(student)

            Toast.makeText(requireContext(),"Succesfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_studentAdd_to_studentFragment)
        }
        else{
            Toast.makeText(requireContext(),"Uzupełnij dane kurwo", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(studentName:String,studentLastName:String):Boolean{
        return !(studentName.isEmpty()&&studentLastName.isEmpty())
    }

}