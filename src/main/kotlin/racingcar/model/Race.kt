package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(private val carList: List<Car>, private val rounds: Int) {
    fun play(onShowRoundResult: (List<Car>) -> Unit) {
        repeat(rounds) {
            moveCar()
            onShowRoundResult(carList)
        }
    }

    fun getRaceWinner(): List<String> {
        val maxMoves = carList.maxOf { it.moves }
        return carList.filter { it.moves == maxMoves }.map { it.name }
    }

    private fun moveCar() {
        for (car in carList) if (shouldMove()) car.move()
    }

    private fun shouldMove() = Randoms.pickNumberInRange(0, 9) >= 4
}

data class Car(val name: String) {
    var moves = 0
        private set

    fun move() = moves++
}