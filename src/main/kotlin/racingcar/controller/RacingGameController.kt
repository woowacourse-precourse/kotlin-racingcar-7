package racingcar.controller

import racingcar.view.RacingGameView
import racingcar.model.Car
import racingcar.domain.InputValidator
import racingcar.domain.RacingGameService

class RacingGameController(
    private val racingGameView: RacingGameView,
    private val validator: InputValidator,
    private val racingGameService: RacingGameService
) {
    private var cars: List<Car> = emptyList()
    private var tryCount: Int = 0

    fun gameStart() {
        cars = readCarNames()
        tryCount = inputTryCount()
        multiRace()
        announceFinalWinner()
    }

    /**
     * 자동차 이름들을 사용자로부터 입력받아 Car객채 초기화
     * @return 자동차 이름들과 0으로 초기화된 LinkedHashMap 값
     */
    private fun readCarNames(): List<Car> {
        racingGameView.showGameStart()
        val inputString = racingGameView.readLine()
        validator.carNamesValidate(inputString)

        return racingGameService.generateCarsByInput(inputString)
    }

    /**
     * 자동차 경주 횟수를 사용자로 부터 입력받기
     * @return 자동차 경주 횟수를 나타내는 Int 값
     */
    private fun inputTryCount(): Int {
        racingGameView.showInputCount()
        val inputCountString = racingGameView.readLine()
        validator.tryCountValidate(inputCountString)

        return inputCountString.toInt()
    }

    /**
     * 경주를 한번 진행 하고 결과를 출력
     */
    private fun singleRace() {
        cars.forEach {
            racingGameService.moveCarRandomly(it)
            racingGameView.showCarNameWithIndicator(it.name, it.distance)
        }
        racingGameView.showBlankLine()
    }

    /**
     * 경주를 시도횟수 만큼 진행 하고 결과를 출력
     */
    private fun multiRace() {
        racingGameView.showBlankLine()
        racingGameView.showRaceResultHeader()
        for (i in 1..tryCount) {
            singleRace()
        }
    }

    /**
     * 최종 우승자 출력
     */
    private fun announceFinalWinner() {
        val winnersName = racingGameService.findWinnerNames(cars)
        racingGameView.showWinners(winnersName)
    }
}