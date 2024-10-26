package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun lenCheck(nameList: List<String>): Boolean {
    nameList.forEach {
        if (it.length >= 6)
            return false
    }
    return true
}

fun inputCar(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val nameList = Console.readLine()
    val splitNameList = nameList.split(",")
    if (lenCheck(splitNameList)){
        return splitNameList
    } else
        throw IllegalArgumentException()
}

fun inputNum(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val numOfAttempts = Console.readLine().toInt()

    return requireNotNull(numOfAttempts)
}

fun printResult(record: MutableMap<String, Int>) {
    record.forEach {
        print("${it.key} : ")
        println("-".repeat(it.value))
    }
    println("")

}

fun printWinner(winner: Map<String, Int>) {
    println("최종 우승자 : ${winner.keys.joinToString(", ")}")
}

fun movementDecision(): Boolean {
    if (Randoms.pickNumberInRange(0, 9) >= 4)
        return true
    return false
}

fun raceRun(record: MutableMap<String, Int>, atmpNum: Int) {
    println("\n실행 결과")
    for (i: Int in 1..atmpNum) {
        for (car in record.keys)
           if (movementDecision())
               record[car] = record[car]!!.plus(1)
        printResult(record)
    }
}

fun compareScores(record: MutableMap<String, Int>) {
    val maxValue = record.values.max()
    val result = record.filterValues { it == maxValue }

    printWinner(result)
}

fun main() {
    // TODO: 프로그램 구현
    val nameList = inputCar()
    val attemptNum = inputNum()

    var distanceRecord: MutableMap<String, Int> = nameList.map { it to 0 }.toMap().toMutableMap()

    raceRun(distanceRecord, attemptNum)
    compareScores(distanceRecord)

}
