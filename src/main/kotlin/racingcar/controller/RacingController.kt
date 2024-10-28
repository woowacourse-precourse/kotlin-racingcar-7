package racingcar.controller

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    fun race() {
        val carList = getCarList()
        val attemptCount = getAttemptCount()
        showResult()
        processRacing(carList, attemptCount)
        showWinners(carList)
    }

    private fun getCarList(): CarList {
        OutputView.printStartMessage()
        val input = InputView.getCars()
        return CarList(input)
    }

    private fun getAttemptCount(): AttemptCount {
        OutputView.printAttemptMessage()
        val input = InputView.getAttempt()
        return AttemptCount(input)
    }

    private fun showResult() {
        OutputView.printResultMessage()
    }

    private fun processRacing(carList: CarList, attemptCount: AttemptCount) {
        val round = Round(RandomNumberGenerator())
        repeat(attemptCount.count) {
            round.play(carList.cars)
            showRoundStatus(carList)
        }
    }

    private fun showRoundStatus(carList: CarList) {
        val racingStatus = RacingStatus()
        val carDtoList = racingStatus.getCurrentRacingStatus(carList.cars)
        carDtoList.forEach { OutputView.printPosition(it.name, it.position) }
        println()
    }

    private fun showWinners(carList: CarList) {
        val referee = Referee()
        val winners = referee.getWinners(carList.cars)
        OutputView.printWinners(winners)
    }
}
