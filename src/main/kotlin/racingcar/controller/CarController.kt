package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarList
import racingcar.util.CarNameValidator

class CarController(private val carList: CarList) {

    fun addCarList(carNames: String) {
        val carNameList = carNames.split(",")
        CarNameValidator.validateDuplicate(carNameList) // 자동차 이름 중복 유효성 검사

        for (carName in carNameList) {
            CarNameValidator.validateLength(carName.trim()) // 자동차 이름 길이 유효성 검사
            carList.addCar(Car(carName.trim()))
        }
    }

}