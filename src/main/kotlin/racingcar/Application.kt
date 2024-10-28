package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = inputCars()
    val tryCount = inputTryCount()
    val racingGame = RacingGame(cars, tryCount)
    racingGame.start()
    println("최종 우승자 : ${racingGame.getWinners()}")
}

fun inputCars(): List<Car> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    return input.split(",").map { name ->
        if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        Car(name)
    }
}

fun inputTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("유효한 숫자를 입력하세요.")
}
