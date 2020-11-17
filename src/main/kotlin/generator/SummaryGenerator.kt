package com.acme.generator

class SummaryGenerator {
    companion object {
        fun generateAllRides()  {
            val years = listOf(2016, 2017, 2018, 2019, 2020)
            val months = listOf(5, 6, 7, 8, 9, 10)
            val reader = OpendataReader()
            for (year in years) {
                for (month in months) {
                    val summarydata = reader.readMonthData(month = month, year = year)
                    reader.writeMonthData(month = month, year = year, summaryData = summarydata)
                }
            }
        }
    }
}