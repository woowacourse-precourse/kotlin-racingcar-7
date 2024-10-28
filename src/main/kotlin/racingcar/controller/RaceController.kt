package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.Output

class RaceController(carNames: List<String>, private val round: Int, private val output: Output) {
    private val race = Race()

    init {
        race.addCar(carNames)
    }

    private fun moveCar() = race.cars.forEach { it.move(pickNumberInRange(0, 9)) }

    private fun getWinner(): List<Car> {
        val maxMoving = race.maxMoving()
        return race.cars.filter { car -> car.moving == maxMoving }
    }

    fun start() {
        output.infoGetCarNames()
        output.infoGetRound()

        repeat(round) {
            moveCar()
            output.showRoundResult(race.cars)
        }

        output.showRaceResult(getWinner())
    }
}