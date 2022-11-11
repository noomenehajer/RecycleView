package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    val values = arrayListOf<String>("item1", "item2" , "item3", "item4", "item5")
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    private lateinit var bt :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = manager
            adapter = myAdapter
        }
      bt=findViewById(R.id.bt)
        bt.setOnClickListener{
            var n:Int = values.size + 1
            values.add("item$n")
            myAdapter.notifyItemInserted(values.size)
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked",
            Toast.LENGTH_SHORT).show()
        values[position]="Clicked"
        myAdapter.notifyItemChanged(position)
    }

        }
