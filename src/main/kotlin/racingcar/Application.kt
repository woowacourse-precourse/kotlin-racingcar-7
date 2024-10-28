package racingcar

import camp.nextstep.edu.missionutils.*;

fun main() {
    val carNames = inputCars()
    val count = inputCount()

    raceCar(carNames,count)

}

fun inputCars(): List<String>{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine().split(",").map{it.trim()}
    if (carNames.any { it.isBlank() || it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해주세요.")
    }
    return carNames
}
fun inputCount(): Int{
    println("시도할 횟수는 몇 회인가요?")
    val count = Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("시도할 횟수는 숫자로 입력해주세요.")
    return count
}

fun findWinners(cars: List<Car>): String {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }
        .joinToString(", ") { it.name }
}

fun raceCar(carNames: List<String>, count: Int){
    var cars: List<Car> = carNames.map{Car(it)}

    println("실행 결과")
    repeat(count){
        cars.forEach {it.move()}
        cars.forEach { car -> println(car.getRaceStatus()) }
        println()
    }
    println("최종 우승자 : ${findWinners(cars)}")
}

class Car(val name: String){
    var position = 0
        private set

    fun move(){
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4){
            position++
        }
    }
    fun getRaceStatus(): String {
        return "$name : ${"-".repeat(position)}"
    }
}

