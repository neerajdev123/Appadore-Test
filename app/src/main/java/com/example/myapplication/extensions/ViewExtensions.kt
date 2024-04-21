package com.example.myapplication.extensions

import android.view.View

fun View.show(show: Boolean = true) {
    visibility = if (show) View.VISIBLE else View.GONE
}