package racingcar.controller.dto

import racingcar.model.Car

class RaceGameResultDto(
    val carName: String,
    val position: Int
) {
    companion object {
        fun mapToRaceGameResults(cars: List<Car>): List<RaceGameResultDto> {
            return cars.map { RaceGameResultDto(it.name, it.position) }
        }
    }
}
