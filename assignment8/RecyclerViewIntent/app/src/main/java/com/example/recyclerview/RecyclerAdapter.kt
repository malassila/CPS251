package com.example.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView




class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
var itemImage: ImageView
var itemTitle: TextView
var itemDetail: TextView
    init {
        itemImage = itemView.findViewById(R.id.itemImage)
        itemTitle = itemView.findViewById(R.id.itemTitle)
        itemDetail = itemView.findViewById(R.id.itemDetail)


        itemView.setOnClickListener { v: View ->
            val i = Intent(v.context,MainActivity2::class.java)


            var title = itemTitle.text
            var detail = itemDetail.text
            var image = itemImage.tag.toString()


            i.putExtra("title", title)
            i.putExtra("details", detail)
            i.putExtra("image", image)


            startActivity(v.context,i,null)


        }
    }
}
    var viewModel = MainViewModel




    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = viewModel.randomTitle(i)
        viewHolder.itemDetail.text = viewModel.randomDetail(i)
        viewHolder.itemImage.setImageResource(viewModel.randomImage(i)


        )

        viewHolder.itemImage.tag = viewModel.randomImage(i)




    }


    override fun getItemCount(): Int {
       //return Data.titles.size
        return 20 //Just wanted more items on the list
    }
}


