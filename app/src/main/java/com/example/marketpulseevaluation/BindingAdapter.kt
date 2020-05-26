package com.example.marketpulseevaluation

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.text.InputType
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
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
    if (visibility != null) {
        if (visibility) {
            textView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.INVISIBLE
        }
    }
}

@BindingAdapter("criteriaList")
fun bindRecyclerViewCriteria(recyclerView: RecyclerView, data: List<Criteria>?) {
    val adapter = recyclerView.adapter as CriteriaDataAdapter
    adapter.submitList(data)
}


@BindingAdapter("clickableSpan")
fun bindClickableSpan(textView: TextView, criteria: Criteria?) {
    val spannableString = SpannableString(criteria?.text)

    if (criteria != null) {
        val openBracketPosition = findIndex(spannableString, "(")
        val closeBracketPosition = findIndex(spannableString, ")")
        val size = openBracketPosition.size
        var firstwordClick:ClickableSpan? = null
        var secondwordClick: ClickableSpan? = null

        if (openBracketPosition.isNotEmpty()) {
            if (size == 1) {
                firstwordClick = object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        if (criteria.variable?.`$1` != null) {
                            handleClick(widget, criteria, "$1")
                            return
                        }
                        if (criteria.variable?.`$2` != null) {
                            handleClick(widget, criteria, "$2")
                            return
                        }
                        if (criteria.variable?.`$3` != null) {
                            handleClick(widget, criteria, "$3")
                            return
                        }
                        if (criteria.variable?.`$4` != null) {
                            handleClick(widget, criteria, "$4")
                            return
                        }
                    }
                }
            } else if (size == 2) {
                firstwordClick = object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        if (criteria.variable?.`$1` != null) {
                            handleClick(widget, criteria, "$1")
                            return
                        }
                        if (criteria.variable?.`$2` != null) {
                            handleClick(widget, criteria, "$2")
                            return
                        }
                        if (criteria.variable?.`$3` != null) {
                            handleClick(widget, criteria, "$3")
                            return
                        }
                        if (criteria.variable?.`$4` != null) {
                            handleClick(widget, criteria, "$4")
                            return
                        }
                    }
                }

                secondwordClick = object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        if (criteria.variable?.`$4` != null) {
                            handleClick(widget, criteria, "$4")
                            return
                        }
                        if (criteria.variable?.`$3` != null) {
                            handleClick(widget, criteria, "$3")
                            return
                        }
                        if (criteria.variable?.`$2` != null) {
                            handleClick(widget, criteria, "$2")
                            return
                        }
                        if (criteria.variable?.`$1` != null) {
                            handleClick(widget, criteria, "$1")
                            return
                        }
                    }
                }
            }
        }

        if (openBracketPosition.isNotEmpty()) {
            if(size == 1) {
                spannableString.setSpan(firstwordClick,
                openBracketPosition[0],
                closeBracketPosition[0] + 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            if(size == 2) {
                spannableString.setSpan(firstwordClick,
                    openBracketPosition[0],
                    closeBracketPosition[0] + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

                spannableString.setSpan(secondwordClick,
                    openBracketPosition[1],
                    closeBracketPosition[1] + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
    textView.text = spannableString
    textView.isClickable = true
    textView.movementMethod = LinkMovementMethod.getInstance()

}


@BindingAdapter("formatText")
fun bindFormatText(textView: TextView, criteria: Criteria?) {
    var tempCritria = criteria
    if (tempCritria != null) {
        if (tempCritria.text.contains("$1")) {
            if (tempCritria.variable?.`$1`?.studyType == null) {
                tempCritria.text = tempCritria.text.replace(
                    "$1",
                    """ (${tempCritria.variable?.`$1`?.values?.get(0).toString()}) """
                )
            } else {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$1",
                    newValue = """(${tempCritria.variable?.`$1`?.defaultValue.toString()}) """
                )

            }
           // textView.text = tempCritria.text
        }

        if (tempCritria.text.contains("$2")) {
            if (tempCritria.variable?.`$2`?.studyType == null) {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$2",
                    newValue = "(" + tempCritria.variable?.`$2`?.values?.get(0).toString() + ") "
                )
            } else {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$2",
                    newValue = """(${tempCritria.variable?.`$2`?.defaultValue.toString()}) """
                )
            }
           // textView.text = tempCritria.text
        }

        if (tempCritria.text.contains("$3")) {
            if (tempCritria.variable?.`$3`?.studyType == null) {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$3",
                    newValue = """(${tempCritria.variable?.`$3`?.values?.get(0).toString()})"""
                )
            } else {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$3",
                    newValue = """(${tempCritria.variable?.`$3`?.defaultValue.toString()})"""
                )
            }
          //  textView.text = tempCritria.text
        }

        if (tempCritria.text.contains("$4")) {
            if (tempCritria.variable?.`$4`?.studyType == null) {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$4",
                    newValue = """(${tempCritria.variable?.`$4`?.values?.get(0).toString()})"""
                )
            } else {
                tempCritria.text = tempCritria.text.replace(
                    oldValue = "$4",
                    newValue = """(${tempCritria.variable?.`$4`?.defaultValue.toString()})"""
                )
            }
           // textView.text = tempCritria.text
        }
    }
}

private fun handleClick(
    widget: View,
    criteria: Criteria,
    clickType: String
) {
    if(clickType  == "$1") {
        if (criteria.variable?.`$1`?.studyType != null) {
            if(criteria.variable?.`$1`?.defaultValue != null) {
                showAlert(criteria.variable?.`$1`?.defaultValue, widget.context)
            }
        } else {
            if (criteria.variable?.`$1`?.values != null) {
                showList(criteria.variable?.`$1`?.values, widget.context)
            }
        }
    }


    if(clickType == "$2"){
        if (criteria.variable?.`$2`?.studyType != null) {
            if(criteria.variable?.`$2`?.defaultValue != null) {
                showAlert(criteria.variable?.`$2`?.defaultValue, widget.context)
            }
        } else {
            if (criteria.variable?.`$2`?.values != null) {
                showList(criteria.variable?.`$2`?.values, widget.context)
            }
        }
    }

    if(clickType == "$3") {
        if (criteria.variable?.`$3`?.studyType != null) {
            if(criteria.variable?.`$3`?.defaultValue != null) {
                showAlert(criteria.variable?.`$3`?.defaultValue, widget.context)
            }
        } else {
            if (criteria.variable?.`$3`?.values != null) {
                showList(criteria.variable?.`$3`?.values, widget.context)
            }
        }
    }


    if(clickType == "$4") {
        if (criteria.variable?.`$4`?.studyType != null) {
            if(criteria.variable?.`$4`?.defaultValue != null) {
                showAlert(criteria.variable?.`$4`?.defaultValue, widget.context)
            }
        } else {
            if (criteria.variable?.`$4`?.values != null) {
                showList(criteria.variable?.`$4`?.values, widget.context)
            }
        }
    }
}

fun showAlert(
    defaultValue: Int?,
    context: Context
) {
    val alertDialogBuilder =
        AlertDialog.Builder(context, AlertDialog.THEME_HOLO_DARK)
            .setTitle(context.getString(com.example.marketpulseevaluation.R.string.set_parameter))
            .setMessage(context.getString(com.example.marketpulseevaluation.R.string.period))
    val editText = EditText(context)
    val lp = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
    )
    editText.layoutParams = lp
    editText.hint = defaultValue.toString()
    editText.setHintTextColor(Color.WHITE)
    editText.setTextColor(Color.WHITE)
    editText.inputType = InputType.TYPE_CLASS_NUMBER
    alertDialogBuilder.setView(editText)
    alertDialogBuilder.show()
}

 fun showList(values: List<Double>?, context: Context?) {
    val alertDialogBuilder =
        AlertDialog.Builder(context, AlertDialog.THEME_HOLO_DARK)
    val array: Array<String> =
        values?.map { it.toString() }!!.toTypedArray()
    alertDialogBuilder.setItems(array) { dialog, which ->

    }
    val dialog = alertDialogBuilder.create()

    dialog.show()
}


fun findIndex(str: SpannableString, subStr: String): List<Int> {
    val positionList = ArrayList<Int>()
    val size = str.length.minus(subStr.length)
    for (char in 0..size.minus(1)) {
        if (str.substring(char, char.plus(subStr.length)) == subStr) {
            positionList.add(char)
        }
    }
    return positionList
}
