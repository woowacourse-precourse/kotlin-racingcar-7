package racingcar.controller

import racingcar.model.Move
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printGetNameOfCar()
        val name = inputView.getNameOfCar()
        outputView.printGetCount()
        val count = inputView.getCount()
        playGame(name, count)
    }

    private fun playGame(name: MutableMap<String, Int>, count: Int) {
        outputView.printResultMessage()
        for (i in 1..count) {
            printStatus(name)
        }
        // 최종 우승자 출력 필요
    }

    private fun printStatus(infoOfCar: MutableMap<String, Int>) {
        val move = Move()
        val presentInfo = move.move(infoOfCar)
        for ((key, value) in presentInfo) {
            outputView.printStatusOfName(key)
            for (i in 1..value) {
                outputView.printStatusOfMove()
            }
            outputView.printLineFeed()
        }
        outputView.printLineFeed()
    }
}