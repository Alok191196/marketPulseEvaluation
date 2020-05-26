package com.example.marketpulseevaluation.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.marketpulseevaluation.R
import com.example.marketpulseevaluation.adapter.StockDataAdapter
import com.example.marketpulseevaluation.databinding.MainFragmentBinding
import com.example.marketpulseevaluation.detail.DetailFragment
import com.example.marketpulseevaluation.model.Stock

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        const val KEY_STOCK = "STOCK"
        var stock : Stock? = null
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.stockApiStatus.observe(viewLifecycleOwner, Observer { apiStatus ->
            if (apiStatus != null) {
                binding.progressBar.visibility = View.INVISIBLE
            }
        })

        binding.viewStocks.adapter = StockDataAdapter(StockDataAdapter.OnClickListener {
            val detailFragment = DetailFragment()
            val args = Bundle()
            args.putParcelable(KEY_STOCK, it)
            detailFragment.arguments = args
            stock = it
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.container, detailFragment, "detail")
                ?.addToBackStack(null)
                ?.commit()
        })
        return binding.root
    }

}
