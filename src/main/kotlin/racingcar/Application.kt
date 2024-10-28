package racingcar

import racingcar.domain.usecase.CreateCarsUseCase
import racingcar.domain.usecase.GetWinnersUseCase
import racingcar.domain.usecase.PlayRaceUseCase
import racingcar.ui.*

fun main() {
    val createCarsUseCase = CreateCarsUseCase()
    val getWinnersUseCase = GetWinnersUseCase()
    val playRaceUseCase = PlayRaceUseCase()
    val raceInputView = RacingInputView()
    val raceResultView = RacingResultView()
    val controller =
        RacingCarController(raceInputView, raceResultView, createCarsUseCase, getWinnersUseCase, playRaceUseCase)
    controller.run()
}