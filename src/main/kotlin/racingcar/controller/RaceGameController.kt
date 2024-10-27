package racingcar.controller

import racingcar.controller.dto.RaceGameResultDto
import racingcar.controller.dto.WinnerResultDto
import racingcar.model.Car
import racingcar.service.RaceGameService
import racingcar.view.RaceGameView

class RaceGameController(
    private val raceGameView: RaceGameView,
    private val raceGameService: RaceGameService
) {
    fun startRaceProcess() {
        val carNames: String = raceGameView.inputCarNames()
        val tryCount: Int = raceGameView.inputTryCount()
        conductRace(carNames, tryCount)
    }

    private fun conductRace(carNames: String, tryCount: Int) {
        val raceCars: List<Car> = raceGameService.setupCars(carNames)

        repeat(tryCount) {
            raceGameService.performRace(raceCars)
            val raceResults: List<RaceGameResultDto> = RaceGameResultDto.mapToRaceGameResults(raceCars)
            raceGameView.printRaceGameResults(raceResults)
        }

        val winningResults: List<WinnerResultDto> = raceGameService.findWinners(raceCars)
        raceGameView.printRaceGameWinners(winningResults)
    }
}
