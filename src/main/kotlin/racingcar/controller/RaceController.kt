package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.Output

class RaceController {
    private val inputController = InputController()
    private val output = Output()
    private val race = Race()
    private val cars = race.cars

    private fun makeCar() = inputController.getCarNames().forEach { cars.add(Car(it)) }
    private fun moveCar() = cars.forEach { it.move(pickNumberInRange(1, 9)) }
    private fun getWinner(): List<Car> {
        val maxMoving = cars.maxOf { it.moving }
        return cars.filter { car -> car.moving == maxMoving }
    }

    fun start() {
        output.infoGetCarNames()
        makeCar()

        output.infoGetRound()

        repeat(inputController.getRaceRound()) {
            moveCar()
            output.showRoundResult(cars)
        }

        output.showRaceResult(getWinner())
    }
}