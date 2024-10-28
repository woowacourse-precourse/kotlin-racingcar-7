package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.Input
import racingcar.view.Output

class RaceController {
    private val input = Input()
    private val output = Output()
    private val race = Race()
    private val cars = race.cars

    private fun makeCar() = input.getCarNames().forEach { cars.add(Car(it)) }
    private fun moveCar() = cars.forEach { it.move(pickNumberInRange(0, 9)) }
    private fun getWinner(): List<Car> {
        val maxMoving = cars.maxOf { it.moving }
        return cars.filter { car -> car.moving == maxMoving }
    }

    fun start() {
        output.infoGetCarNames()
        makeCar()

        output.infoGetRound()

        repeat(input.getRaceRound()) {
            moveCar()
            output.showRoundResult(cars)
        }

        output.showRaceResult(getWinner())
    }
}