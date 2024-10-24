package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현
}

fun getUserInput(): MutableList<Pair<String,Int>> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine() ?: throw IllegalArgumentException()
    val carNames = input.split(",").map { it.trim() }
    carNames.forEach { name ->
        if (name.length > 5) {
            throw IllegalArgumentException()
        }
    }
    return carNames.map { Pair(it,0) }.toMutableList()
}

fun getAttemptCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
}

fun updateCarPosition(cars : MutableList<Pair<String,Int>>){
    cars.forEachIndexed { index, car ->
        if(Randoms.pickNumberInRange(0,9) >= 4){
            cars[index] = car.copy(second = car.second + 1)
        }
    }
}


