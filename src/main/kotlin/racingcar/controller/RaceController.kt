package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race

class RaceController {
    private val inputController = InputController()
    private val race = Race()
    private val cars = race.cars

    private fun makeCar() = inputController.getCarNames().forEach { cars.add(Car(it)) }
}