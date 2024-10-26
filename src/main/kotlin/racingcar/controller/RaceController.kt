package racingcar.controller

import racingcar.model.CarList

class RaceController(private val carList: CarList) {
    private var raceCount: Int = 0

    fun setRaceCount(raceCount: Int) {
        this.raceCount = raceCount
    }

    fun race() {
        for (count in 1 .. raceCount) {
            TurnController(carList).playTurn()
        }
    }

}