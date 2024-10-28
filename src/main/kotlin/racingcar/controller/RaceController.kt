package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarList
import racingcar.view.ConsoleView

class RaceController(
    private val carList: CarList,
    private val consoleView: ConsoleView
) {
    private var raceCount: Int = 0

    fun setRaceCount(raceCount: Int) {
        this.raceCount = raceCount
    }

    fun getRaceCount(): Int {
        return raceCount
    }

    fun pickWinner(): List<Car> {
        val winnerList = mutableListOf<Car>()
        var maxMoveCount = 0

        for (index in 0 until carList.getSize()) {
            val car = carList.getCar(index)
            val moveCount = car.getMoveCount()

            if (moveCount > maxMoveCount) {
                // 새로운 최대 이동 횟수를 발견하면 리스트를 초기화하고 추가
                maxMoveCount = moveCount
                winnerList.clear()
                winnerList.add(car)
            } else if (moveCount == maxMoveCount) {
                // 현재 최대 이동 횟수와 같은 경우 리스트에 추가
                winnerList.add(car)
            }
        }

        return winnerList
    }

    fun race() {
        consoleView.printRaceStart()
        for (count in 1..raceCount) {
            TurnController(carList, consoleView).playTurn()
        }
        consoleView.printWinner(pickWinner())
    }

}