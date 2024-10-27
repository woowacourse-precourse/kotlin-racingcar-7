package racingcar.control

import racingcar.view.Message

class Racing(private val cars: List<CarData>, private val count: Int) {
    init {
        println(Message().RESULT)
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
            println(c.name + Message().NAME_FORWARD_STRING_SEPARATOR + hyphensCount(c.point))
        }
        println()
    }

    private fun hyphensCount(int: Int): String {
        return Message().FORWARD_STRING.repeat(int)
    }
}