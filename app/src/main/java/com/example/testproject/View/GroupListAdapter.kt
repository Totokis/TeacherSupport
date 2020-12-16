package com.example.testproject.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.Model.data.Group
import com.example.testproject.R
import kotlinx.android.synthetic.main.group_row.view.*

class GroupListAdapter: RecyclerView.Adapter<GroupListAdapter.MyViewHolder>() {

    private var groupList = emptyList<Group>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.group_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = groupList[position]
        holder.itemView.row_group_name.text = currentItem.groupName.toString()

        holder.itemView.groupRow.setOnClickListener {
            val action = GroupFragmentDirections.actionGroupFragmentToGroupUpdate(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(group: List<Group>){
        this.groupList = group
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

}