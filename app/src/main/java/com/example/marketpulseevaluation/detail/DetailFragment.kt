package com.example.marketpulseevaluation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.marketpulseevaluation.adapter.CriteriaDataAdapter
import com.example.marketpulseevaluation.databinding.FragmentDetailBinding
import com.example.marketpulseevaluation.model.Stock
import com.example.marketpulseevaluation.ui.main.MainFragment

class DetailFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val args = this.arguments
        var stock: Stock? = null
        if(args != null) {
            stock = args.getParcelable(MainFragment.KEY_STOCK)
        }
        val viewModelFactory = stock?.let { DetailViewModelFactory(it, application) }
        binding.viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(DetailViewModel::class.java)

        binding.criteriaList.adapter = CriteriaDataAdapter()
        return binding.root
    }
}