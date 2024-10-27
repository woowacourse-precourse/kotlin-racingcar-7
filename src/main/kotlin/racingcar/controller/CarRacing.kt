package racingcar.controller

import racingcar.model.Car
import racingcar.view.UserInterface
import camp.nextstep.edu.missionutils.Randoms

class CarRacing(private val view: UserInterface) {
    val carList = mutableListOf<Car>()

    fun run() {
        val cars = view.getCarName()
        val attempts = view.getNumberOfAttempts()
        if (cars == "") throw IllegalArgumentException("자동차 이름을 하나 이상 입력해주세요: null")
        generateCarList(cars)

    }
    fun generateCarList(input: String) {
        val carArray = input.split(",")
        for (i in carArray) {
            carList.add(Car(i, 0))
        }
    }

    fun driveCar(car: Car) {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            car.distanceCovered++
        }
    }

    fun simulateRace() {
        for (i in carList) {
            driveCar(i)
        }
    }

    fun getWinner(): List<String> {
        var max = 0
        for (i in carList) {
            max = if(i.distanceCovered>max) i.distanceCovered else max
        }
        val winners = mutableListOf<String>()
        for(i in carList){
            if(i.distanceCovered == max){
                winners.add(i.name)
            }
        }
        return winners
    }
}