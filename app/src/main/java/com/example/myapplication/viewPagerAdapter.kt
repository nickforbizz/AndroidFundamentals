package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class viewPagerAdapter(
    val images: List<Int>
): RecyclerView.Adapter<viewPagerAdapter.viewPagerViewHolder>() {
    inner class viewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return viewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: viewPagerViewHolder, position: Int) {
        val currImg = images[position]
        holder.itemView.ivViewPager.setImageResource(currImg)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}