package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.constant.Message.RANDOM_VALUE_RANGE
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.Output

class RaceController(carNames: List<String>, private val round: Int, private val output: Output) {
    private val race = Race()

    init {
        race.addCar(carNames)
    }

    private fun moveCar() =
        race.cars.forEach { it.move(pickNumberInRange(RANDOM_VALUE_RANGE.first, RANDOM_VALUE_RANGE.last)) }

    private fun getWinner(): List<Car> {
        val maxMoving = race.maxMoving()
        return race.cars.filter { car -> car.moving == maxMoving }
    }

    fun start() {
        repeat(round) {
            moveCar()
            output.showRoundResult(race.cars)
        }

        output.showRaceResult(getWinner())
    }
}