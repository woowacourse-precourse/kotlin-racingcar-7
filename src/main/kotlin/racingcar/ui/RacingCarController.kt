package racingcar.ui

import racingcar.domain.entity.Car
import racingcar.domain.usecase.CreateCarUseCase
import racingcar.domain.usecase.GetWinnersUseCase
import racingcar.domain.usecase.PlayRaceUseCase

class RacingCarController(
    private val createCarUseCase: CreateCarUseCase,
    private val getWinnersUseCase: GetWinnersUseCase,
    private val playRaceUseCase: PlayRaceUseCase,
) {
    fun convertRaceCount(input: String): Int {
        val count = input.toIntOrNull()
        requireNotNull(count) { println(INPUT_INTEGER_ERROR_MESSAGE) }
        return count
    }

    private fun playRace(cars: List<Car>) {
        playRaceUseCase.execute(cars)
    }

    private fun createCars(input: String) = createCarUseCase.execute(input)

    private fun getWinners(cars: List<Car>) = getWinnersUseCase.execute(cars)

    companion object {
        private const val INPUT_INTEGER_ERROR_MESSAGE = "정수를 입력해주세요"
    }
}