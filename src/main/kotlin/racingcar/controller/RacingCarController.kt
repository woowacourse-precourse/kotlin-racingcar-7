package racingcar.controller

import racingcar.model.RacingCar
import racingcar.validator.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    /* 순서
     * 1. 입력 값을 받는다.
     * 2, 입력 값을 검증한다.
     * 3. 입력 값을 가지고 레이싱을 진행한다.
     * 4. 각 시도 마다 레이싱을 진행하고, 매 결과를 출력
     * 5. 최종 우승자를 출력한다.
     * */

    private val inputView = InputView()

    fun runRacingGame() {
        val carNames = getInput()
        val tryCount = getTryCount()

        val carList = playRacing(carNames, tryCount)
        announceWinners(carList)
    }

    private fun getInput(): List<String> {
        val carNames = inputView.getCarNames()
        Validator.validateCarNames(carNames)
        return carNames.split(",")
    }

    private fun getTryCount(): Int {
        val tryCount = inputView.getTryCount()
        Validator.validateTryCount(tryCount)
        return tryCount.toInt()
    }

    fun playRacing(
        carNames: List<String>,
        tryCount: Int,
    ): List<RacingCar> {
        OutputView().printDefaultMessage() // "실행 결과" 출력

        val carList = carNames.map { RacingCar(it) }
        repeat(tryCount) {
            moveCars(carList)
            OutputView().printResult(carList)
        }
        return carList
    }

    private fun moveCars(carList: List<RacingCar>) {
        carList.forEach { car -> car.moveForward() }
    }

    fun announceWinners(carList: List<RacingCar>) {
        val winners = getWinners(carList)
        OutputView().printWinners(winners)
    }

    private fun getWinners(carList: List<RacingCar>): List<RacingCar> {
        val winners = mutableListOf<RacingCar>()
        carList.forEach {
            if (winners.isEmpty() || it.forwardCount == winners[0].forwardCount) {
                winners.add(it)
            } else if (it.forwardCount > winners[0].forwardCount) {
                winners.clear()
                winners.add(it)
            }
        }
        return winners
    }
}
