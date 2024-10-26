package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarList
import racingcar.view.ConsoleView

class CarController(
    private val consoleView: ConsoleView = ConsoleView(),
    private val carList: CarList = CarList()) {
    fun addCarList() {
        // 자동차 이름 입력 받기
        val input = consoleView.inputCarName()
        val carNameList = input.split(",")
        for (index in carNameList.indices) {
            carList.addCar(Car(carNameList[index].trim()))
            println(carList.getCar(index).getName())
        }
    }

}