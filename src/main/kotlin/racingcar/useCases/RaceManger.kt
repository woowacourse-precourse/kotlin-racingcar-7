package racingcar.useCases

import racingcar.domain.Car
import racingcar.domain.RaceResult

class RaceManger (private val cars: List<Car>){
    fun findWinners(): RaceResult {
        val maxDistance: Int = cars.maxOf { it.distance }
        val winners: List<Car> = cars.filter { it.distance == maxDistance }
        val winnersName: List<String> = winners.map{ it.name }
        return RaceResult(winnersName)
    }
}