package Model

class Race(private val cars: List<Car>, private val rounds: Int, private val moveStrategy: MoveStrategy) {

    fun startRace(): List<List<String>> {
        val progress = mutableListOf<List<String>>()
        repeat(rounds) {
            cars.forEach { it.move(moveStrategy.isMovable()) }
            progress.add(cars.map { it.toString() })
        }
        return progress
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
