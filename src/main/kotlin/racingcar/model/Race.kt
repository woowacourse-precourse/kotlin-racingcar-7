package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(private val carList: List<Car>, private val rounds: Int) {
    fun play() {
        repeat(rounds) {
            raceCars()
        }
    }

    private fun raceCars() {
        for (car in carList) if (shouldMove()) car.move()
    }

    private fun shouldMove() = Randoms.pickNumberInRange(0, 9) >= 4
}

data class Car(val name: String) {
    var moves = 0
        private set

    fun move() = moves++
}