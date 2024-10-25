package racingcar.useCases

import racingcar.domain.Car
import racingcar.domain.RaceResult
import racingcar.infrastructure.RandomNumber

class RaceManger (
    private val cars: List<Car>
){
    fun playRace(matches: Int) {
        repeat(matches) {
            cars.forEach { car -> car.goOneStep(RandomNumber.pick()) }
        }
        findWinners()
    }

    private fun findWinners(): RaceResult {
        val maxDistance: Int = cars.maxOf { it.distance }
        val winners: List<Car> = cars.filter { it.distance == maxDistance }
        val winnersName: List<String> = winners.map{ it.name }
        return RaceResult(winnersName)
    }
}