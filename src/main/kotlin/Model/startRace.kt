package Model

fun startRace(cars: List<Car>, rounds: Int, moveStrategy: MoveStrategy): List<List<String>> {
    val progress = mutableListOf<List<String>>()
    repeat(rounds) {
        cars.forEach { it.move(moveStrategy.isMovable()) }
        progress.add(cars.map { it.toString() })
    }
    return progress
}