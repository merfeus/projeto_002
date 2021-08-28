package com.example.projeto_002.utils

fun String.toUpperFirstChar(): String{
    return replaceFirstChar { it.uppercase() }
}