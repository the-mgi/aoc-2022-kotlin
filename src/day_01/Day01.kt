package day_01

import java.io.File
import java.util.*

fun readFile(): ArrayList<String> {
    val scanner =
        Scanner(File("/media/themgi/Local Disk/aoc-2022-kotlin/src/day_01/input.txt"))
    val arrayList = ArrayList<String>()
    while (scanner.hasNextLine()) {
        val currentLine = scanner.nextLine()
        arrayList.add(if (currentLine.trim().isNotEmpty()) currentLine else "\n")
    }
    return arrayList
}

fun main() {
    fun questionOne(): Int {
        val list = readFile()
        var currentMax = 0
        var overallMax = 0
        list.forEach {
            if (it == "\n") {
                if (currentMax > overallMax) {
                    overallMax = currentMax
                }
                currentMax = 0
            } else {
                currentMax += it.toInt()
            }
        }
        return overallMax
    }

    fun questionTwo(): Int {
        val list = readFile()
        var sumOfCurrent = 0
        val totalSums = java.util.ArrayList<Int>()
        list.forEach {
            if (it == "\n") {
                totalSums.add(sumOfCurrent)
                sumOfCurrent = 0
            } else {
                sumOfCurrent += it.toInt()
            }
        }

        totalSums.sortDescending()
        return totalSums.take(3).sum()
    }

    println("Question 01: ${questionOne()}")
    println("Question 02: ${questionTwo()}")
}
