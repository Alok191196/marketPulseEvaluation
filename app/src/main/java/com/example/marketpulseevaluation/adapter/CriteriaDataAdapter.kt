package com.example.marketpulseevaluation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketpulseevaluation.databinding.CriteraListItemBinding
import com.example.marketpulseevaluation.model.Criteria
import com.example.marketpulseevaluation.ui.main.MainFragment

class CriteriaDataAdapter :
    ListAdapter<Criteria, CriteriaDataAdapter.CriteriaViewHolder>(DiffCallback) {

    class CriteriaViewHolder(private var binding: CriteraListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(criteria: Criteria) {
            binding.criteria = criteria
            binding.stock = MainFragment.stock
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CriteriaViewHolder {
        return CriteriaViewHolder(CriteraListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CriteriaViewHolder, position: Int) {
        val criteria = getItem(position)
        holder.bind(criteria)
    }


    companion object DiffCallback: DiffUtil.ItemCallback<Criteria>() {
        override fun areItemsTheSame(oldItem: Criteria, newItem: Criteria): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Criteria, newItem: Criteria): Boolean {
            return true
        }

    }
}