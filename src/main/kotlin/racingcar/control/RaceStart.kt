package racingcar.control

import racingcar.message.Other

class RaceStart(private val cars: List<CarData>, private val count: Int) {

    init {
        println("\n${Other.RESULT}")
    }

    fun repeatRace(): List<CarData> {
        repeat(count) {
            runRace()
        }
        return cars
    }

    private fun runRace() {
        cars.forEach { c ->
            if (ForwardStep().moveForward()) {
                ++c.point
            }
        }
        cars.forEach { c ->
            println(c.name + Other.NAME_FORWARD_STRING_SEPARATOR + printHyphen(c.point))
        }
        println()
    }

    private fun printHyphen(int: Int): String {
        return Other.FORWARD_STRING.repeat(int)
    }
}