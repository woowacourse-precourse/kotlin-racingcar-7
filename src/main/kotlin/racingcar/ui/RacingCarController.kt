package racingcar.ui

import racingcar.domain.entity.Car
import racingcar.domain.usecase.CreateCarUseCase
import racingcar.domain.usecase.GetWinnersUseCase
import racingcar.domain.usecase.PlayRaceUseCase

class RacingCarController(
    private val racingInputView: RacingInputView,
    private val racingResultView: RacingResultView,
    private val createCarUseCase: CreateCarUseCase,
    private val getWinnersUseCase: GetWinnersUseCase,
    private val playRaceUseCase: PlayRaceUseCase,
) {
    fun run() {
        val cars = createCars()
        val raceCount = getRaceCount()
        startRace(raceCount, cars)
        outputWinners(cars)
    }

    private fun createCars(): List<Car> {
        racingInputView.guideInputCarsName()
        val input = racingInputView.getCarsNameInput()
        return createCars(input)
    }

    private fun createCars(input: String) = createCarUseCase.execute(input)


    private fun getRaceCount(): Int {
        racingInputView.guideInputRaceCount()
        val input = racingInputView.getRaceCountInput()
        return convertRaceCount(input)
    }

    private fun convertRaceCount(input: String): Int {
        val count = input.toIntOrNull()
        requireNotNull(count) { println(INPUT_INTEGER_ERROR_MESSAGE) }
        return count
    }

    private fun startRace(raceCount: Int, cars: List<Car>) {
        racingResultView.guideExecuteResult()
        repeat(raceCount) {
            playRace(cars = cars)
            racingResultView.printRaceResult(cars)
        }
    }

    private fun playRace(cars: List<Car>) {
        playRaceUseCase.execute(cars)
    }

    private fun outputWinners(cars: List<Car>) {
        val winners = getWinners(cars)
        racingResultView.printWinners(winners)
    }

    private fun getWinners(cars: List<Car>) = getWinnersUseCase.execute(cars)

    companion object {
        private const val INPUT_INTEGER_ERROR_MESSAGE = "정수를 입력해주세요"
    }
}