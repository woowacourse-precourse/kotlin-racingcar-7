package racingcar.control

import racingcar.message.Other

class Racing(private val cars: List<CarData>, private val count: Int) {
    init {
        println(Other().RESULT)
    }

    fun repeatRacing(): List<CarData> {
        repeat(count) {
            racing()
        }
        return cars
    }

    private fun racing() {
        cars.forEach { c ->
            if (OneStepForward().oneStepForward()) {
                ++c.point
            }
        }
        cars.forEach { c ->
            println(c.name + Other().NAME_FORWARD_STRING_SEPARATOR + hyphensCount(c.point))
        }
        println()
    }

    private fun hyphensCount(int: Int): String {
        return Other().FORWARD_STRING.repeat(int)
    }
}