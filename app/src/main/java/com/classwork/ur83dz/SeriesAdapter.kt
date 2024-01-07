package com.classwork.ur83dz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.classwork.ur83dz.databinding.ItemSeiriasBinding

class SeriesAdapter(private val seriesList: List<Series>, var onClick: (position: Series) -> Unit) :
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSeiriasBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = seriesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(seriesList[position])
    }

    inner class ViewHolder(private val binding: ItemSeiriasBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(series: Series) {
            binding.apply {
                series.apply {
                    nameTv.text = name
                    statusTv.text = status
                    posterImg.loadImage(img)
                }
            }
            itemView.setOnClickListener {
                onClick(series)
            }
        }
    }
}