package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarList
import racingcar.view.UserInterface
import camp.nextstep.edu.missionutils.Randoms

class CarRacing(private val view: UserInterface) {

    fun run() {
        val carName = view.getCarName()
        val attempts = view.getNumberOfAttempts()
        val cars = CarList(generateCarList(carName))
        for( i in 0 until attempts){
            simulateRace(cars)
            val carNameList = cars.carList.map { it.name }
            val carMovedList = cars.carList.map { it.distanceCovered }
            view.printRacingCar(carNameList, carMovedList)
        }
        val winner = getWinner(cars)
        view.showResult(winner)
    }
    fun generateCarList(input: String): List<Car> {
        val carArray = input.split(",")
        val cars = mutableListOf<Car>()
        for (i in carArray) {
            cars.add(Car(i, 0))
        }
        return cars
    }

    fun driveCar(car: Car) {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            car.distanceCovered++
        }
    }

    fun simulateRace(cars: CarList) {
        for (i in cars.carList) {
            driveCar(i)
        }
    }

    fun getWinner(cars: CarList): List<String> {
        var max = 0
        for (i in cars.carList) {
            max = if(i.distanceCovered>max) i.distanceCovered else max
        }
        val winners = mutableListOf<String>()
        for(i in cars.carList){
            if(i.distanceCovered == max){
                winners.add(i.name)
            }
        }
        return winners
    }
}