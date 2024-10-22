package racingcar

class ResultOutput {

    fun printRaceResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}\n")
        }
    }

    fun printWinners(winnersName: List<String>) {
        val winnersResult = winnersName.joinToString(",")
        println("최종 우승자 : $winnersResult")
    }
}