package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val racingGame: RacingGame = RacingGame()

    fun start() {
        val racingCars = createCarByName()
        val numberOfRound = getRound()
        progressRace(racingCars, numberOfRound)
        presentWinner()
    }

    private fun createCarByName(): Map<String, Car> {
        outputView.showPrompt("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputName = inputView.getInput()
        val nameList = racingGame.splitToList(inputName)
        if (!racingGame.isValidName(nameList)) {
            throw IllegalArgumentException()
        }
        return racingGame.createCars(nameList)
    }

    private fun getRound(): Int {
        outputView.showPrompt("시도할 횟수는 몇 회인가요?")
        val inputNumber = inputView.getInput()
        if (!racingGame.isNaturalNumber(inputNumber)) {
            throw IllegalArgumentException()
        }
        return inputNumber.toInt()
    }

    private fun progressRace(cars: Map<String, Car>, round: Int) {
        outputView.showPrompt("실행 결과")
        repeat(round) {
            cars.forEach {
                racingGame.play(it.key)
                outputView.displayRacingProgress(name = it.key, scoreSymbol = it.value.scoreSymbol)
            }
        }
    }

    private fun presentWinner() {
        val winner = racingGame.getWinner()
        outputView.displayWinner(winner)
    }
}