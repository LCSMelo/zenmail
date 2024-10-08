package br.com.fiap.zenmail.shared.utils

import java.text.SimpleDateFormat
import java.util.Calendar

fun getDate(milliSeconds : Long, dateFormat: String): String {
    val formatter = SimpleDateFormat(dateFormat)

    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return formatter.format(calendar.time)
}