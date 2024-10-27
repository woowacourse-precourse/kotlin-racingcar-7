package Model

fun findWinner(cars: List<Car>): List<String> {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }.map { it.name }
}