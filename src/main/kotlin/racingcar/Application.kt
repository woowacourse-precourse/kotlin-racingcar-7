package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import racingcar.Validation.Validation
import racingcar.View.InputView
import racingcar.View.OutputView


fun carsNameTrim(cars : List<String>): List<String> {
    return cars.map { it.trim() }
}

fun isCanGo(): Boolean {
    return Randoms.pickNumberInRange(0, 9) >= 4
}

fun gameOfOneCar(carsMoving: Array<Int>, index: Int) {
    if (isCanGo()) {
        carsMoving[index] += 1
    }
}

fun gameOfTurn(cars: List<String>, carsMovingArray: Array<Int>, outputView: OutputView) {
    for (i in 0 until cars.count()) {
        gameOfOneCar(carsMovingArray, i)
        outputView.gameResult(cars[i], carsMovingArray[i])
    }
    println()
}

fun game(cars: List<String>, carsMovingArray: Array<Int>, outputView: OutputView, count: Int) {
    for (i in 0 until count) {
        gameOfTurn(cars, carsMovingArray, outputView)
    }
}

fun getWinnerIndex(carsMoving: Array<Int>): MutableList<Int> {
    val winners = mutableListOf<Int>()
    var maxNumber = 0

    carsMoving.forEachIndexed { idx, it ->
        if (it == maxNumber) {
            winners.addLast(idx)
        }
        if (it > maxNumber) {
            maxNumber = it
            winners.clear()
            winners.addLast(idx)
        }
    }
    return winners
}

fun inputCars(inputView: InputView, validation: Validation): List<String> {
    inputView.inputCars()
    val inputCar = Console.readLine()
    validation.checkInputCarIsNotEmpty(inputCar)

    var cars: List<String> = inputCar.split(',')
    validation.checkCarNameDuplication(cars)
    cars = carsNameTrim(cars)
    validation.checkCarNameLength(cars)

    return cars
}

fun inputCount(inputView: InputView, validation: Validation): Int {
    inputView.inputCount()
    val inputCount = Console.readLine()
    validation.checkCountIsNumber(inputCount)
    val count = inputCount.toInt()

    return count
}

fun main() {
    val outputView = OutputView()
    val inputView = InputView()
    val validation = Validation()

    val cars = inputCars(inputView, validation)
    val count = inputCount(inputView, validation)

    val carsMovingArray = Array(cars.count()) { 0 }

    outputView.outputPrint()
    game(cars, carsMovingArray, outputView, count)

    val winners = getWinnerIndex(carsMovingArray).map { cars[it] }
    outputView.winnerPrint(winners)
}
