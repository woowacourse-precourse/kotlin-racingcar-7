package racingcar.controller

import racingcar.model.Move
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val move = Move()

    fun start() {
        outputView.printGetNameOfCar()
        val infoOfCar = inputView.inputName().associateWith { 0 }.toMutableMap()
        outputView.printGetCount()
        val count = inputView.getCount()
        play(infoOfCar, count)
    }

    private fun play(infoOfCar: MutableMap<String, Int>, count: Int) {
        outputView.printResultMessage()
        for (i in 1..count) {
            status(infoOfCar)
        }
        winner(infoOfCar)
    }

    private fun status(infoOfCar: MutableMap<String, Int>) {
        val updateInfo = step(infoOfCar)
        outputView.printStatusOfMove(updateInfo)
    }

    private fun step(infoOfCar: MutableMap<String, Int>): MutableMap<String, Int> {
        for ((name, step) in infoOfCar) {
            move.moveCar(infoOfCar, name, step, move.getRandomNumber())
        }
        return infoOfCar
    }

    private fun winner(infoOfCar: MutableMap<String, Int>) {
        val maxMove = infoOfCar.maxOf { it.value }
        val winner = infoOfCar.filter{ it.value == maxMove }.keys
        outputView.printWinnerMessage(winner)
    }
}