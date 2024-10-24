package racingcar.controller

import racingcar.model.Move
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printGetNameOfCar()
        val infoOfCar = setInfoOfCar(inputView.getNameOfCar())
        outputView.printGetCount()
        val count = inputView.getCount()
        play(infoOfCar, count)
    }

    private fun setInfoOfCar(nameList: List<String>): MutableMap<String, Int> {
        return nameList.associateWith { 0 }.toMutableMap()
    }

    private fun play(infoOfCar: MutableMap<String, Int>, count: Int) {
        outputView.printResultMessage()
        for (i in 1..count) {
            status(infoOfCar)
        }
        winner(infoOfCar)
    }

    private fun status(infoOfCar: MutableMap<String, Int>) {
        val move = Move()
        val updateInfo = move.move(infoOfCar)
        outputView.printStatusOfMove(updateInfo)
    }

    private fun winner(infoOfCar: MutableMap<String, Int>) {
        val maxMove = infoOfCar.maxOf { it.value }
        val winnerList = infoOfCar.filter{ it.value == maxMove }.keys.joinToString(", ")
        outputView.printWinnerMessage(winnerList)
    }
}