package com.example.marketpulseevaluation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marketpulseevaluation.databinding.StockListItemBinding
import com.example.marketpulseevaluation.model.Stock

class StockDataAdapter(val onClickListener: OnClickListener) :
    ListAdapter<Stock, StockDataAdapter.StockViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Stock>() {
        override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem.id == newItem.id

        }
    }


    class StockViewHolder(private var binding: StockListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stock: Stock) {
            binding.stock = stock
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StockViewHolder {
        return StockViewHolder(StockListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(stock)
        }
        holder.bind(stock)
    }


    class OnClickListener(val clickListener: (stock: Stock) -> Unit) {
        fun onClick(stock: Stock) = clickListener(stock)

    }
}