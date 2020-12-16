package com.example.testproject.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.Model.data.Student
import com.example.testproject.R
import kotlinx.android.synthetic.main.student_row.view.*

class StudentListAdapter:RecyclerView.Adapter<StudentListAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = studentList[position]
        holder.itemView.row_student_id.text = currentItem.id.toString()
        holder.itemView.row_student_name.text = currentItem.name
        holder.itemView.row_student_last_name.text = currentItem.lastName

        holder.itemView.studentRow.setOnClickListener {

        }
    }

    fun setData(student: List<Student>){
        this.studentList = student
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}