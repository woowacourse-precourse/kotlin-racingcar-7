package Model

fun startRace(cars: List<Car>, rounds: Int, moveStrategy: MoveStrategy): List<List<String>> {
    require(rounds > 0) {
        throw IllegalArgumentException()
    }

    if (rounds == 0) {
        return emptyList()
    }

    val progress = mutableListOf<List<String>>()
    repeat(rounds) {
        cars.forEach { it.move(moveStrategy.isMovable()) }
        progress.add(cars.map { it.toString() })
    }
    return progress
}