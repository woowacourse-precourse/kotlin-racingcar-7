package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(names: List<String>) {
    val cars: List<Car> = names.map { Car(it) }.toList()

    fun startOneRound() {
        for (car in cars) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (isGo(randomNumber)) {
                car.plusDrivingDistance()
            }
        }
    }

    fun getLeadingCars(): MutableList<Car> {
        var top = 0
        val leadingCars: MutableList<Car> = mutableListOf()

        for (car in cars) {
            if (top < car.drivingDistance) {
                leadingCars.clear()
                leadingCars.add(car)
                top = car.drivingDistance
            } else if (top == car.drivingDistance) {
                leadingCars.add(car)
            } else {
                continue
            }
        }

        return leadingCars
    }

    private fun isGo(num: Int): Boolean {
        return num >= FORWARD_REFERENCE_NUMBER
    }

    companion object {
        const val FORWARD_REFERENCE_NUMBER = 4
    }
}