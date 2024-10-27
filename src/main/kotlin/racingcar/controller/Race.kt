package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Move
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printInputNameMessage()
        val infoOfCar = inputView.inputName().associateWith { 0 }.toMutableMap()
        outputView.printInputCountMessage()
        val count = inputView.inputCount()
        play(infoOfCar, count)
        winner(infoOfCar)
    }

    private fun play(infoOfCar: MutableMap<String, Int>, count: Int) {
        outputView.printResultMessage()
        for (i in 1..count) {
            status(infoOfCar)
        }
    }

    private fun status(infoOfCar: MutableMap<String, Int>) {
        val updateInfo = step(infoOfCar)
        outputView.printStatusOfMove(updateInfo)
    }

    private fun step(infoOfCar: MutableMap<String, Int>): MutableMap<String, Int> {
        val move = Move()
        for ((name, nowStep) in infoOfCar) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            move.moveCar(infoOfCar, name, nowStep, randomNumber)
        }
        return infoOfCar
    }

    fun winner(infoOfCar: MutableMap<String, Int>) {
        val maxMove = infoOfCar.maxOf { it.value }
        val winnerName = infoOfCar.filter{ it.value == maxMove }.keys
        outputView.printWinnerMessage(winnerName)
    }
}