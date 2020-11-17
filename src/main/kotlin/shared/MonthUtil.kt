package com.acme.shared

class MonthUtil {
    companion object {
        fun padMonth(month: Int) : String {
            var monthAsString = month.toString()
            if(monthAsString.length == 1) {
                monthAsString = monthAsString.padStart(2, '0')
            }
            return monthAsString
        }
    }
}