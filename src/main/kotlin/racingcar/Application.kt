package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val (cars, n) = input()
    val carsProgressCount = race(cars,n)
    val winner = pickWinner(cars, carsProgressCount)
    outputWinner(winner)
}

fun input(): Pair<List<String>, Int> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = readLine()!!.trim().split(",")
    println("시도할 횟수는 몇 회인가요?")
    val n = readln().toInt()
    return Pair(cars, n)
}

fun race(cars: List<String>, n: Int): Array<Int> {
    val carsProgressCount = Array(cars.size){0}
    repeat(n){
        for(i in carsProgressCount.indices){
            carsProgressCount[i] += randomPick()
        }
        outputProgress(cars,carsProgressCount)
    }
    return carsProgressCount
}

fun randomPick(): Int {
    val n = Randoms.pickNumberInRange(0, 9)
    return if (n >= 4) 1
    else 0
}

fun outputProgress(cars: List<String>, carsProgressCount: Array<Int>) {
    println("\n실행 결과")
    for(i in cars.indices){
        print("${cars[i]} : ")
        repeat(carsProgressCount[i]){
            print("-")
        }
        println()
    }
}

fun pickWinner(cars: List<String>, carsProgressCount: Array<Int>): String {
    val winner = mutableListOf<String>()
    var max = 0
    for(i in carsProgressCount.indices){
        if(max < carsProgressCount[i]){
            winner.clear()
            winner.add(cars[i])
            max = carsProgressCount[i]
        }else if(max == carsProgressCount[i]){
            winner.add(cars[i])
        }
    }
    return winner.joinToString(", ")
}

fun outputWinner(winner: String) {
    println("\n최종 우승자 : $winner")
}