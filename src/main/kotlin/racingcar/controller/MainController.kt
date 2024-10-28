package racingcar.controller

import racingcar.model.CarList
import racingcar.util.RaceCountValidator
import racingcar.view.ConsoleView

class MainController {
    private val consoleView = ConsoleView()
    private val carList = CarList()
    private val carController = CarController(carList)
    private val raceController = RaceController(carList, consoleView)

    fun run() {
        val carNames = consoleView.inputCarName()
        carController.addCarList(carNames)

        val raceCountString = consoleView.inputRaceCount()
        val raceCount = RaceCountValidator.validatePositiveInteger(raceCountString) // 경주(이동) 횟수가 양의 정수인지 유효성 검사 후 정수 반환
        RaceCountValidator.validateNumberSize(raceCount) // 경주 횟수 제한
        raceController.setRaceCount(raceCount)

        raceController.race()
    }
}