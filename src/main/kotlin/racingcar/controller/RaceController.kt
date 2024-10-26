package racingcar.controller

import racingcar.model.CarList

class RaceController(private val carList: CarList) {
    private var raceCount: Int = 0

    fun setRaceCount(raceCount: Int) {
        this.raceCount = raceCount
    }

    fun race() {
        // raceCount를 기반으로 경주 로직을 실행
    }
}