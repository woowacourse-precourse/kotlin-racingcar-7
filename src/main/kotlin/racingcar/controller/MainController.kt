package racingcar.controller

import racingcar.model.CarList
import racingcar.view.ConsoleView

class MainController {
    private val consoleView = ConsoleView()
    private val carList = CarList()
    private val carController = CarController(carList)
    private val raceController = RaceController(carList, consoleView)

    fun run() {
        val carNames = consoleView.inputCarName()
        carController.addCarList(carNames)

        val raceCount = consoleView.inputRaceCount()
        raceController.setRaceCount(raceCount)

        raceController.race()
    }
}