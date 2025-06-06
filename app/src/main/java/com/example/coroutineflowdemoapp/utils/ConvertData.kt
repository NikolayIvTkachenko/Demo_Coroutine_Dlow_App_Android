package com.example.coroutineflowdemoapp.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

object ConvertData {
    var simpleFormat = DateTimeFormatter.ISO_DATE

    fun convertStringToDateLocalDate(dateStr: String): LocalDate{
        var convertedDate = LocalDate.parse(dateStr, simpleFormat)
        return convertedDate
    }

    fun convertStringToDateDate(dateStr: String): Date? {
        try {
            //"yyyy-MM-dd'T'HH:mm:ss.SSSSSSSX"
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSX")
            val date = formatter.parse(dateStr)
            return date
        } catch (e: Exception) {
            return null
        }
    }

}