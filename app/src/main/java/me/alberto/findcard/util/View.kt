package me.alberto.findcard.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.beGone() {
    visibility = View.GONE
}

fun View.beVisible() {
    visibility = View.VISIBLE
}

fun View.beInvisible() {
    visibility = View.INVISIBLE
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}