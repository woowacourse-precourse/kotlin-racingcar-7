package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarList
import racingcar.view.UserInterface
import camp.nextstep.edu.missionutils.Randoms

class CarRacing(private val view: UserInterface) {

    fun run() {
        val (cars, attempts) = handleInput()

        view.showRaceStart()
        for (i in 0 until attempts) {
            simulateRace(cars)
            val carNameList = cars.carList.map { it.name }
            val carMovedList = cars.carList.map { it.distanceCovered }
            view.printRacingCar(carNameList, carMovedList)
        }

        val winner = getWinner(cars)
        view.showResult(winner)
    }

    private fun handleInput(): Pair<CarList, Int> {
        val carName = view.getCarName()
        val attempts: Int
        val carArray: List<String>

        try {
            attempts = view.getNumberOfAttempts().toInt()

            if (attempts <= 0) {
                throw IllegalArgumentException("Number of attempts must be greater than zero.")
            }

            carArray = carName.split(",").map { it.trim() }

            for (i in carArray) {
                if (i.length > 5) {
                    throw IllegalArgumentException("Car name cannot exceed 5 characters.")
                } else if (i.isBlank()) {
                    throw IllegalArgumentException("Car name cannot be blank.")
                } else if (!i.matches(Regex("^[a-zA-Z]+$"))) {
                    throw IllegalArgumentException("Car name must contain only alphabetic characters.")
                }
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("Invalid input: ${e.message}")
        }

        val cars = CarList(generateCarList(carArray))
        return Pair(cars, attempts)
    }


    private fun generateCarList(carArray: List<String>): List<Car> {

        val cars = mutableListOf<Car>()
        for (i in carArray) {
            cars.add(Car(i, 0))
        }
        return cars
    }

    private fun simulateRace(cars: CarList) {
        for (i in cars.carList) {
            driveCar(i)
        }
    }

    private fun driveCar(car: Car) {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            car.distanceCovered++
        }
    }

    private fun getWinner(cars: CarList): List<String> {
        var max = 0
        for (i in cars.carList) {
            max = if (i.distanceCovered > max) i.distanceCovered else max
        }
        val winners = mutableListOf<String>()
        for (i in cars.carList) {
            if (i.distanceCovered == max) {
                winners.add(i.name)
            }
        }
        return winners
    }
}