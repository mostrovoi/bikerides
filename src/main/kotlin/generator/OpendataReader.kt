package com.acme.generator

import com.acme.shared.MonthUtil
import com.acme.shared.SummaryData
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter

class OpendataReader {

    private val DISTANCE_INDEX = 6
    private val DURATION_INDEX = 7

    private fun parseValue(distance: String): Long {
        return if(distance == "")
            0L
        else
            distance.toDouble().toLong()
    }

    fun readMonthData(month: Int, year: Int) : SummaryData {
        var totalDistance = 0L
        var totalDuration = 0L
        var totalTrips = 0

        val monthAsString = MonthUtil.padMonth(month)

        csvReader().open("src/main/resources/od-trips-$year/$year-$monthAsString.csv") {
            readAllAsSequence().forEach { row : List<String> ->
                if(totalTrips != 0) {
                    totalDistance += parseValue(row[DISTANCE_INDEX])
                    totalDuration += parseValue(row[DURATION_INDEX])
                }
                totalTrips++
            }
        }
        return SummaryData(totalTrips = totalTrips, totalDistance = totalDistance, totalDuration = totalDuration)
    }

    fun writeMonthData(month: Int, year: Int, summaryData: SummaryData) {
        val monthAsString = MonthUtil.padMonth(month)
        val rowHeader = listOf("Total trips", "Total distance", "Total duration")
        val rowData = listOf(summaryData.totalTrips, summaryData.totalDistance, summaryData.totalDuration)
        csvWriter().open("src/main/resources/od-trips-$year/$monthAsString-summary.csv") {
            writeRow(rowHeader)
            writeRow(rowData)
        }
    }


}