package com.example.marketpulseevaluation

import android.text.SpannableString
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketpulseevaluation.adapter.CriteriaDataAdapter
import com.example.marketpulseevaluation.adapter.StockDataAdapter
import com.example.marketpulseevaluation.model.Criteria
import com.example.marketpulseevaluation.model.Stock


@BindingAdapter("stockList")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Stock>?) {
    val adapter = recyclerView.adapter as StockDataAdapter
    adapter.submitList(data)
}

@BindingAdapter("setVisibility")
fun setVisibility(textView: TextView, visibility: Boolean?) {
    if(visibility != null) {
        if(visibility) {
            textView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.INVISIBLE
        }
    }
}

@BindingAdapter("criteriaList")
fun bindRecyclerViewCriteria(recyclerView: RecyclerView, data: List<Criteria>?){
    val adapter = recyclerView.adapter as CriteriaDataAdapter
    adapter.submitList(data)
}


@BindingAdapter("clickableSpan")
fun bindClickableSpan(textView: TextView, text: String?) {
    var spanString : SpannableString = SpannableString(text)

}


@BindingAdapter("formatText")
fun bindFormatText(textView: TextView, criteria: Criteria?) {
    if (criteria != null) {
    if (criteria.text.contains("$1")) {
            if(criteria.variable?.`$1`?.studyType == null) {
                criteria.text = criteria.text.replace("$1", " (" + criteria.variable?.`$1`?.values?.get(0).toString() + ") ")
            } else {
                criteria.text = criteria.text.replace("$1", "(" +criteria.variable?.`$1`?.defaultValue.toString() + ") ")

            }
            textView.text = criteria.text
          }

        if (criteria.text.contains("$2")) {
            if(criteria.variable?.`$2`?.studyType == null) {
                criteria.text = criteria.text.replace("$2", "(" + criteria.variable?.`$2`?.values?.get(0).toString() + ") ")
            } else {
                criteria.text = criteria.text.replace("$2", "(" +criteria.variable?.`$2`?.defaultValue.toString() + ") ")
            }
            textView.text = criteria.text
        }

        if (criteria.text.contains("$3")) {
            if(criteria.variable?.`$3`?.studyType == null) {
                criteria.text = criteria.text.replace("$3", "(" + criteria.variable?.`$3`?.values?.get(0).toString() + ")")
            } else {
                criteria.text = criteria.text.replace("$3", "(" +criteria.variable?.`$3`?.defaultValue.toString() + ")")
            }
            textView.text = criteria.text
        }

        if (criteria.text.contains("$4")) {
            if(criteria.variable?.`$4`?.studyType == null) {
                criteria.text = criteria.text.replace("$4", "(" + criteria.variable?.`$4`?.values?.get(0).toString() + ")")
            } else {
                criteria.text = criteria.text.replace("$4", "(" +criteria.variable?.`$4`?.defaultValue.toString() + ")")
            }
            textView.text = criteria.text
        }

    }
    var emptySpannableString = ""

    if (criteria != null) {
        for (word in criteria.text.split(" ")) {
            if (word.contains("(")) {
                val spannableString = SpannableString(word.substring(word.indexOf('(') + 1, word.indexOf(')')))
                emptySpannableString += " ($spannableString)"
            } else {
                emptySpannableString += " $word "
            }
        }
    }
    textView.text = emptySpannableString
}
