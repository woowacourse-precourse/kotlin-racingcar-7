package racingcar


object RaceView {
    fun displayRaceStatus(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${"-".repeat(it.distance)}") }
        println("\n")
    }

    fun displayWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxPosition }
        println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
    }
}
