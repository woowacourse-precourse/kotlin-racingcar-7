package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// 자동차를 나타내는 클래스, 이름과 이동 거리, 순위를 속성으로 가짐
data class Car(
    var name: String,
    var move: Int = 0,
    var rank: Int = 0,
)

fun main() {
    val carNames = getCarNames()
    val moveCount = getMoveCount()
    val cars = createCars(carNames)


}

// 사용자가 입력한 자동차 이름을 ','로 구분하여 리스트로 반환
fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")
    val carNameInput = Console.readLine() ?: ""

    return carNameInput.split(",").map { it.trim() }
}

// 자동차 이름 리스트로 Car 객체 리스트를 생성
fun createCars(carNames: List<String>): List<Car> {
    return carNames.map { name ->
        validateCarName(name)
        Car(name = name)
    }
}

// 자동차 이름 길이 검사
fun validateCarName(name: String) {
    if (name.length > 5) {
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: $name")
    }
}

// 이동 횟수를 입력받아 반환
fun getMoveCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()
    return validateMoveCount(input)
}

// 이동횟수 검증하고 숫자로 반환
fun validateMoveCount(input: String?): Int {
    // 입력값이 숫자인지 확인
    if (input.isNullOrBlank() || !input.all { it.isDigit() }) {
        throw IllegalArgumentException("숫자만 입력가능 합니다.")
    }
    return input.toInt()
}

// 랜덤값에 따라 자동차 전진여부 결정
fun randomMove(): Boolean {
    return Randoms.pickNumberInRange(0, 9) >= 4
}

// 자동차를 전진 시키는 로직
fun moveCars(cars: List<Car>) {
    cars.forEach { car ->
        moveCarIfNeeded(car)
    }
}

fun moveCarIfNeeded(car: Car) {
    if (randomMove()) {
        car.move++
    }
}