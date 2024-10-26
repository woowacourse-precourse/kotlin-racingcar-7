package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


class OutputView {
    fun gameResult(carName:String, movingCount: Int){
        println("$carName : ${"-".repeat(movingCount)}")
    }
}



fun isCanMove(): Boolean {
    return Randoms.pickNumberInRange(0,9) >= 4
}

fun gameOfOneCar(carsMoving : Array<Int>, index : Int) {
    if(isCanMove()){
        carsMoving[index] += 1
    }
}

fun gameOfTurn(cars : List<String>, carsMovingArray : Array<Int>, outputView : OutputView){
    for(i in 0 until cars.count()){
        gameOfOneCar(carsMovingArray, i)
        outputView.gameResult(cars[i], carsMovingArray[i])
    }
    println()
}

fun game(cars : List<String>, carsMovingArray: Array<Int>, outputView: OutputView, count : Int){
    for (i in 0 until count){
        gameOfTurn(cars, carsMovingArray, outputView)
    }
}

fun getWinnerIndex(carsMoving : Array<Int>): MutableList<Int> {
    val winners  = mutableListOf<Int>()
    var maxNumber = 0

    carsMoving.forEachIndexed { idx, it ->
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
    val outputView = OutputView()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputCar = Console.readLine()
    val cars = inputCar.split(',')


    println("시도할 횟수는 몇 회인가요?")
    val inputCount = Console.readLine()
    val count = inputCount.toInt()

    println("실행 결과")

    val carsMovingArray = Array(cars.count()) { 0 }

    game(cars, carsMovingArray, outputView, count)

    val result = getWinnerIndex(carsMovingArray).map { cars[it] }
    println("최종 우승자 : ${result.joinToString(", ")}")
}
