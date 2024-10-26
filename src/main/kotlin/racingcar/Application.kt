package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun getWinnerIndex(carsMovings : Array<Int>): MutableList<Int> {
    val winners  = mutableListOf<Int>()
    var maxNumber = 0

    carsMovings.forEachIndexed { idx, it ->
        if(it == maxNumber){
            winners.addLast(idx)
        }
        if(it > maxNumber){
            maxNumber = it
            winners.clear()
            winners.addLast(idx)
        }
    }

    return winners
}

fun main() {
    // TODO: 프로그램 구현
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputCar = Console.readLine()
    val cars = inputCar.split(',')


    println("시도할 횟수는 몇 회인가요?")
    val inputCount = Console.readLine()
    val count = inputCount.toInt()

    println("실행 결과")

    val carsMovings = Array(cars.count()) { 0 }

    for (i in 0 until count){
        for(j in 0 until cars.count()){
            if(Randoms.pickNumberInRange(0,9) >= 4){
                //이동
                carsMovings[j] += 1
            }
            println("${cars[j]} : ${"-".repeat(carsMovings[j])}")
        }
        println()
    }

    val result = getWinnerIndex(carsMovings).map { cars[it] }
    println("최종 우승자 : ${result.joinToString(", ")}")
}
