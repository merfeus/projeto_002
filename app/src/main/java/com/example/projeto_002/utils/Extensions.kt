package com.example.projeto_002.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.projeto_002.R
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ln
import kotlin.math.pow

fun String.toUpperFirstChar(): String{
    return replaceFirstChar { it.uppercase() }
}

fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes containerId: Int = R.id.container){
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commitNow()
}
fun Int.formatMin(): String {
    val suffixChars = "KMGTPE"
    val formatter = DecimalFormat("###.#")
    formatter.roundingMode = RoundingMode.DOWN

    return if (this < 1000.0) formatter.format(this)
    else {
        val exp = (ln(this.toDouble()) / ln(1000.0)).toInt()
        formatter.format(this / 1000.0.pow(exp.toDouble())) + suffixChars[exp - 1]
    }
}
