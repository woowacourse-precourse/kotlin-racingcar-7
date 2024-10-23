package racingcar.presenter

import racingcar.model.Car

class RacingCarPresenter {

    fun createRacingCars(carNames: List<String>): List<Car> {
        val cars = carNames.map { name ->
            Car(name)
        }
        return cars
    }
}