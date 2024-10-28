package racingcar.model

class Race(val cars: List<Car>, val numberOfRounds: Int) {
    fun raceRound(randomValueProvider: () -> Int) {
        cars.forEach { car ->
            if (randomValueProvider() >= 4) car.move()
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
