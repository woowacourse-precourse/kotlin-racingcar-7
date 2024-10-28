package racingcar

import kotlin.random.Random

open class Car(val name: String) {
    var position = 0

    fun move() {
        if (checkForwardCondition(getRandomNumber())) {
            position++
        }
    }

    open fun getRandomNumber(): Int {
        val randomNumber = Random.nextInt(0, 10)
        return randomNumber
    }

    private fun checkForwardCondition(randomNumber: Int): Boolean {
        return randomNumber >= 4
    }
}