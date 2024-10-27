package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val (cars, n) = input()
    race(cars,n)
}

fun input(): Pair<List<String>, Int> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = readLine()!!.trim().split(",")
    println("시도할 횟수는 몇 회인가요?")
    val n = readln().toInt()
    return Pair(cars, n)
}

fun race(cars: List<String>, n: Int) {
    val carsProgressCount = Array(cars.size){0}
    repeat(n){
        for(i in carsProgressCount.indices){
            carsProgressCount[i] += randomPick()
        }
        outputProgress(cars,carsProgressCount)
    }
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