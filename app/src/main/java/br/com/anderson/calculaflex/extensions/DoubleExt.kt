package br.com.anderson.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)
fun String.formatDecimal(digits: Int, value: Double) = String.format("%.${digits}f", value)

