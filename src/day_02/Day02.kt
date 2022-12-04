package day_02

import readInput

fun main() {
      fun obtainResult(myChoice: String, elfChoice: String): Int {
        return when (myChoice) {
            "X" -> if (elfChoice == "C") (1 + 6) else if (elfChoice == "A") (1 + 3) else 1
            "Y" -> if (elfChoice == "A") (2 + 6) else if (elfChoice == "B") (2 + 3) else 2
            "Z" -> if (elfChoice == "B") (3 + 6) else if (elfChoice == "C") (3 + 3) else 3
            else -> 0
        }
    }

    fun questionOne(): Int {
        return readInput("day_02/input")
            .map {
                val (elfChoice, myChoice) = it.split(" ")
                return@map obtainResult(myChoice, elfChoice)
            }.sum()
    }

    fun questionTwo(): Int {
        return readInput("day_02/input")
            .map {
                val (elfChoice, indicatingOutcome) = it.split(" ")
                return@map when (elfChoice) {
                    "A" -> obtainResult(if (indicatingOutcome == "X") "Z" else if (indicatingOutcome == "Y") "X" else "Y", elfChoice)
                    "B" -> obtainResult(if (indicatingOutcome == "X") "X" else if (indicatingOutcome == "Y") "Y" else "Z", elfChoice)
                    "C" -> obtainResult(if (indicatingOutcome == "X") "Y" else if (indicatingOutcome == "Y") "Z" else "X", elfChoice)
                    else -> 0
                }
            }
            .sum()
    }

    println("Question 01: ${questionOne()}")
    println("Question 02: ${questionTwo()}")
}