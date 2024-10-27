package racingcar.useCases

import racingcar.domain.Car
import racingcar.domain.RaceResult
import racingcar.infrastructure.Output
import racingcar.infrastructure.RandomNumber

class RaceManger (
    private val readyRacingCars: List<Car>,
    private val matches: Int,
    private val output: Output,
){
    fun playGame() {
        output.showMessage()
        repeat(matches) {
            readyRacingCars.forEach { readyRacingCar -> readyRacingCar.goOneStep(RandomNumber.pick()) }
            output.showRoundResult(readyRacingCars)
        }
    }

    fun findWinners(): RaceResult {
        val maxDistance: Int = readyRacingCars.maxOf { it.distance }
        val winners: List<Car> = readyRacingCars.filter { it.distance == maxDistance }
        val winnersName: List<String> = winners.map{ it.name }
        output.showWinners(winnersName)
        return RaceResult(winnersName)
    }
}