package racingcar.useCases

import racingcar.domain.Car
import racingcar.domain.RaceResult
import racingcar.infrastructure.RandomNumber

class RaceManger (
    private val readyRacingCars: List<Car>,
    private val matches: Int
){
    fun playRace() {
        repeat(matches) {
            readyRacingCars.forEach { readyRacingCar -> readyRacingCar.goOneStep(RandomNumber.pick()) }
        }
        findWinners()
    }

    private fun findWinners(): RaceResult {
        val maxDistance: Int = readyRacingCars.maxOf { it.distance }
        val winners: List<Car> = readyRacingCars.filter { it.distance == maxDistance }
        val winnersName: List<String> = winners.map{ it.name }
        return RaceResult(winnersName)
    }
}