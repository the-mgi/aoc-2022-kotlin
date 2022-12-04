package day_03

import readInput
import java.io.File
import java.util.*

fun main() {
    fun getPriority(character: Char) =
        if (character.isLowerCase()) (character.code - 97) % 26 + 1 else (character.code - 65) % 26 + 1 + 26

    fun characterTransform(character: Char, map: MutableMap<Char, Int>) {
        map.also { hashMap ->
            hashMap[character] = getPriority(character)
        }
    }

    fun questionOne(): Int {
        return readInput("day_03/input").map {
            val mid = it.length / 2
            val firstPartMap = mutableMapOf<Char, Int>()
            val secondPartMap = mutableMapOf<Char, Int>()

            it.subSequence(0, mid).forEach { character -> characterTransform(character, firstPartMap) }
            it.subSequence(mid, it.length).forEach { character -> characterTransform(character, secondPartMap) }

            val commonKey = firstPartMap.keys.find { mapKey -> secondPartMap.containsKey(mapKey) }
            if (commonKey != null) return@map firstPartMap[commonKey]!! else return@map 0
        }.sum()
    }

    fun questionTwo(): Int {
        val scanner = Scanner(File("/media/themgi/Local Disk/aoc-2022-kotlin/src/day_03/input.txt"))
        var indexGroupCount = 0
        val inputList = ArrayList<String>()
        while (scanner.hasNextLine()) {
             if (indexGroupCount != 0 && indexGroupCount % 3 != 0) {
                inputList[inputList.size - 1] = "${inputList.last()};${scanner.nextLine()}"
            } else {
                inputList.add(scanner.nextLine())
            }

            indexGroupCount += 1
        }
        return inputList.map {
            val (first, second, third) = it.split(";").map { singleString ->
                val map = mutableMapOf<Char, Int>()
                singleString.forEach { character -> characterTransform(character, map) }
                map
            }
            val commonKey = first.keys.find { mapKey -> second.containsKey(mapKey) && third.containsKey(mapKey) }
            if (commonKey != null) return@map first[commonKey]!! else return@map 0
        }.sum()
    }

    println("Question 01: ${questionOne()}")
    println("Question 02: ${questionTwo()}")
}