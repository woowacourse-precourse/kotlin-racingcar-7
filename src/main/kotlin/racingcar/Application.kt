package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


class InputView{
    fun inputCars(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun inputCount(){
        println("시도할 횟수는 몇 회인가요?")
    }
}

class OutputView {
    fun outputPrint(){
        println("실행 결과")
    }
    fun gameResult(carName:String, movingCount: Int){
        println("$carName : ${"-".repeat(movingCount)}")
    }

    fun winnerPrint(winners : List<String>){
        println("최종 우승자 : ${winners.joinToString(", ")}")

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


fun checkCarNameLength(cars : List<String>) {
    if (!(cars.all { it -> it.count() <= 5 })){
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능하다")
    }
}

fun main() {
    val outputView = OutputView()
    val inputView = InputView()

    inputView.inputCars()
    val inputCar = Console.readLine()
    val cars : List<String> = inputCar.split(',')
    checkCarNameLength(cars)

    inputView.inputCount()
    val inputCount = Console.readLine()
    val count = inputCount.toInt()

    val carsMovingArray = Array(cars.count()) { 0 }

    outputView.outputPrint()
    game(cars, carsMovingArray, outputView, count)

    val winners = getWinnerIndex(carsMovingArray).map { cars[it] }
    outputView.winnerPrint(winners)
}
