package com.example.recycleview;

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter(
private val myDataSet: ArrayList<String>,
private val listener: OnItemClickListener):
RecyclerView.Adapter<MyAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh =LayoutInflater.from(parent.context).inflate(R.layout.ligne,parent,false)
        return ViewHolder(vh)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current = myDataSet[position]
        holder.vText.text = current.toString()
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)}
    override fun getItemCount(): Int {
        return myDataSet.size
    }
    inner class ViewHolder(val itemview: View): RecyclerView.ViewHolder(itemview),View.OnClickListener {
        val vText = itemView.findViewById(R.id.word) as TextView
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
}


