package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.util.Collections.max

var input: List<String>? = null
var num = 0
var runSizeList = mutableListOf<Int>()

fun main() {
    startRacingCar()
}

// 입력 받기
private fun inputCar() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    input = Console.readLine().split(",")

    println("시도할 횟수는 몇 회인가요?")
    num = Console.readLine().toInt()

    // 입력 검사하기
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException()
    }

    input!!.forEach {
        if (it.length > 5) {
            throw IllegalArgumentException("이름은 5자보다 짧게 입력해주세요")
        }
    }
    runSizeList = MutableList(input!!.size) { 0 }
}

// 자동차 경주 로직
private fun raceCar() {
    println("실행 결과")
    repeat(num) {
        // 출력 받기
        input?.forEachIndexed { index, name ->
            val run = Randoms.pickNumberInRange(0, 9)
            if (run >= 4) {
                runSizeList[index] += 1
                println("$name : ${"-".repeat(runSizeList[index])}")
            } else {
                println("$name : ${"-".repeat(runSizeList[index])}")
            }
        }
        println()
    }
}

// 우승자 출력하기
private fun printWinner() {
    // 최대값 저장
    val maxRun = max(runSizeList)
    // 우승자 리스트
    val winnerList =
        runSizeList
            .mapIndexedNotNull { index, it ->
                if (it == maxRun) index else null
            }.map { input!![it] }

    // 우승자 리스트 출력
    println("최종 우승자 : ${winnerList.joinToString(",")}")
}

private fun startRacingCar() {
    inputCar()
    raceCar()
    printWinner()
}
