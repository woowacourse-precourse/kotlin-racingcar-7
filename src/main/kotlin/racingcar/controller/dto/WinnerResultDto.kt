package racingcar.controller.dto

import racingcar.model.Car

class WinnerResultDto(val name: String) {
    companion object {
        fun mapToWinnerResults(cars: List<Car>): List<WinnerResultDto> {
            return cars.map { WinnerResultDto(it.name) }
        }
    }
}
