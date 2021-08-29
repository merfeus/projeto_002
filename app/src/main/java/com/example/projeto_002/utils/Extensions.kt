package com.example.projeto_002.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.projeto_002.R

fun String.toUpperFirstChar(): String{
    return replaceFirstChar { it.uppercase() }
}

fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes containerId: Int = R.id.container){
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commitNow()
}