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
        val names = inputView.getInput()
        racingGame.splitToList(names)
        if (!racingGame.isValidName(names)) {
            throw IllegalArgumentException()
        }

        outputView.showPrompt("시도할 횟수는 몇 회인가요?")
        val round = inputView.getInput()
        if (!racingGame.isValidNaturalNumber(round)) {
            throw IllegalArgumentException()
        }

        racingGame.createCars()

        outputView.showPrompt("실행 결과")
        repeat(round.toInt()) {
            racingGame.getNameList().forEach {
                racingGame.play(it)
                val score = racingGame.getScore(it)
                outputView.displayRacingProgress(it, score)
            }
        }
        val winner = racingGame.getWinner()
        outputView.displayWinner(winner)
    }
}