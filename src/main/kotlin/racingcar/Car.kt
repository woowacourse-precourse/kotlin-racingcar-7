package racingcar

class Car(val name: String, var position: Int = 0) {

    fun moving(num: Int) {
        if (isPossibleGoStraight(num)) position++
    }

    fun getStatus(): String {
        var status = "$name : "

        repeat(position) {
            status += DASH
        }
        return status
    }

    private fun isPossibleGoStraight(num: Int): Boolean = num >= 4
}