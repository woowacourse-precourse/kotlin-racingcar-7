package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현
    val carList = getCarNames()
    val attemptCount = getAttemptCount()

    println("\n실행 결과")

    repeat(attemptCount) {
        updateCarsPosition(carList)
        printCarsPosition(carList)
    }

    printWinner(carList)
}

fun getCarNames(): MutableList<Pair<String,Int>> {
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

fun updateCarsPosition(cars : MutableList<Pair<String,Int>>){
    cars.forEachIndexed { index, car ->
        if(Randoms.pickNumberInRange(0,9) >= 4){
            cars[index] = car.copy(second = car.second + 1)
        }
    }
}

fun printCarsPosition(cars : MutableList<Pair<String, Int>>){
    cars.forEach { (name, position) ->
        println("$name : ${"-".repeat(position)}")
    }
    println()
}

fun printWinner(cars: MutableList<Pair<String, Int>>){
    val maxSecond = cars.maxOf { it.second }
    val winner = cars.filter { it.second == maxSecond }.joinToString(", ") {it.first}
    println("최종 우승자 : $winner")
}


