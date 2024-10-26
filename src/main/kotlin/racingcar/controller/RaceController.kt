package racingcar.controller

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

    fun race() {
        for (count in 1 .. raceCount) {
            TurnController(carList, consoleView).playTurn()
        }
    }

}