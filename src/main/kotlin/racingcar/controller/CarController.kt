package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarList

class CarController(private val carList: CarList) {

    fun addCarList(carNames: String) {
        val carNameList = carNames.split(",")
        for (index in carNameList.indices) {
            carList.addCar(Car(carNameList[index].trim()))
        }
    }

}