package com.acme.summary

class SummaryPresentator {
    companion object {
        fun readAllRides() : List<YearRideSummary> {
            val years = listOf(2016, 2017, 2018, 2019, 2020)
            val months = listOf(5, 6, 7, 8, 9, 10)
            val yearRides = mutableListOf<YearRideSummary>()
            for (year in years) {
                val monthRides = mutableListOf<MonthRideSummary>()
                for (month in months) {
                    val data = SummaryReader.readMonthData(month = month, year = year)
                    val monthRideSummary = MonthRideSummary(month = month, data = data)
                    monthRides.add(monthRideSummary)
                }
                yearRides.add(YearRideSummary(year, monthRides))
            }
            return yearRides
        }
    }
}