package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val racingGame: RacingGame = RacingGame()

    fun start() {
        outputView.showPrompt("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = inputView.getInput()
        val nameList = racingGame.splitToList(input)
        if (!racingGame.isValidName(nameList)) {
            throw IllegalArgumentException()
        }

        outputView.showPrompt("시도할 횟수는 몇 회인가요?")
        val inputNumber = inputView.getInput()
        if (!racingGame.isNaturalNumber(inputNumber)) {
            throw IllegalArgumentException()
        }

        val cars = racingGame.createCars(nameList)
        val round = inputNumber.toInt()

        outputView.showPrompt("실행 결과")
        repeat(round) {
            cars.forEach {
                racingGame.play(it.key)
                val scoreSymbol = racingGame.getScoreSymbol(it.key)
                outputView.displayRacingProgress(it.key, scoreSymbol)
            }
        }
        val winner = racingGame.getWinner()
        outputView.displayWinner(winner)
    }
}