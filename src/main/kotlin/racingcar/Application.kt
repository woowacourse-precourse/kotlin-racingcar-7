package racingcar

import racingcar.domain.usecase.CreateCarUseCase
import racingcar.domain.usecase.GetWinnersUseCase
import racingcar.domain.usecase.PlayRaceUseCase
import racingcar.ui.*

fun main() {
    val createCarUseCase = CreateCarUseCase()
    val getWinnersUseCase = GetWinnersUseCase()
    val playRaceUseCase = PlayRaceUseCase()
    val raceInputView = RacingInputView()
    val raceResultView = RacingResultView()
    val controller =
        RacingCarController(raceInputView, raceResultView, createCarUseCase, getWinnersUseCase, playRaceUseCase)
    controller.run()
}