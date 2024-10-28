package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

//자동차 클래스: 속성(이름, 이동 거리, 순위)
data class Car(
    var name: String,
    var move: Int = 0
)

fun main() {
    val carNames = getCarNames()
    val moveCount = getMoveCount()
    val cars = createCars(carNames)
    val winners = winners(cars)

    repeat(moveCount) {
        moveCars(cars)
        printCarsStatus(cars)
    }

    println("최종 우승자 : ${winners.joinToString(", ")}")
}

//입력된 자동차 이름을 쉼표로 구분하여 리스트 반환
fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carNameInput = Console.readLine() ?: ""

    return carNameInput.split(",").map { it.trim() }
}

// 자동차 이름 리스트 -> Car 객체 리스트
fun createCars(carNames: List<String>): List<Car> {
    return carNames.map { name ->
        validateCarName(name)
        Car(name = name)
    }
}

// 자동차 이름 길이 검사
fun validateCarName(name: String) {
    if (name.length > 5) {
        throw IllegalArgumentException("자동차 이름은 5자 이내로 해주세요.: $name")
    }
}

// 이동 횟수 입력&반환
fun getMoveCount(): Int {
    println("시도할 횟수는 몇 회인가요?")

    val input = Console.readLine()

    return validateMoveCount(input)
}

// 이동 횟수 검증&숫자 반환
fun validateMoveCount(input: String?): Int {
    // 입력값 숫자 검증
    if (input.isNullOrBlank() || !input.all { it.isDigit() }) {
        throw IllegalArgumentException("숫자만 입력해주세요.")
    }

    return input.toInt()
}

// 랜덤 값에 따라 자동차 전진
fun randomMove(): Boolean {
    return Randoms.pickNumberInRange(0, 9) >= 4
}

// 자동차 전진
fun moveCars(cars: List<Car>){
    cars.forEach { car -> moveCarIfNeeded(car) }
}

fun moveCarIfNeeded(car: Car) {
    if (randomMove()) {
        car.move++
    }
}

fun printCarsStatus(cars: List<Car>) {
    println()

    cars.forEach { car -> println("${car.name} : ${"-".repeat(car.move)}")}
}

fun winners(cars: List<Car>): List<String> {
    val maxDistance = cars.maxOf { it.move }

    return cars.filter { it.move == maxDistance }.map { it.name }
}