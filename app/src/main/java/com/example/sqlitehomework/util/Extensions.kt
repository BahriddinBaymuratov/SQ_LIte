package com.example.sqlitehomework.util

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Context.snack(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}