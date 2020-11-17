package com.acme.summary

import com.acme.shared.MonthUtil
import com.acme.shared.SummaryData
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class SummaryReader {
        companion object {
            fun readMonthData(month: Int, year: Int): SummaryData {
                val TRIPS_INDEX = 0
                val DISTANCE_INDEX = 1
                val DURATION_INDEX = 2

                var isNotHeader = false
                val monthAsString = MonthUtil.padMonth(month)
                var totalTrips = 0
                var totalDistance = 0L
                var totalDuration = 0L
                csvReader().open("src/main/resources/od-trips-$year/$monthAsString-summary.csv") {
                    readAllAsSequence().forEach { row: List<String> ->
                        if (isNotHeader) {
                            totalTrips = row[TRIPS_INDEX].toInt()
                            totalDistance = row[DISTANCE_INDEX].toLong()
                            totalDuration = row[DURATION_INDEX].toLong()
                        }
                        isNotHeader = true
                    }
                }
                return SummaryData(
                    totalTrips = totalTrips,
                    totalDistance = totalDistance,
                    totalDuration = totalDuration
                )
            }
        }
}