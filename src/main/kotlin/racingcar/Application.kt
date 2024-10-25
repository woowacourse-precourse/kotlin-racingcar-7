package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val cars = carNameInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carList = splitCarName(cars)
    val tryCount = tryCountInput("시도할 횟수는 몇 회인가요?").toInt()
    var carRacingResult = initTryCountList(carList.size)

    println("실행 결과")
    for(i in 0..<tryCount){
        carRacingResult = randomCountToCar(carList, carRacingResult)
        printCarRacing(carList, carRacingResult)
        println()
    }

    printFinalWinner("최종 우승자 : ", findFinalWinner(carList, carRacingResult))
}

fun carNameInput(prompt: String): String{
    println(prompt)
    return readLine()
}

fun tryCountInput(promt: String): String{
    println(promt)
    return readLine()
}

fun splitCarName(carNames: String): List<String>{
    val splitedCarNames = carNames.split(",")
    return splitedCarNames
}

fun initTryCountList(carListSize: Int): MutableList<String>{
    val tryCountList = MutableList(carListSize) { "" }
    return tryCountList
}

fun randomCount(): Int{
    val randomNumber = (0..9).random()
    return randomNumber
}

fun numberIsOverFour(randomNumber: Int): Boolean{
    val bool: Boolean = (if(randomNumber >= 4){
        true
    } else false)
    return bool
}

fun randomCountToCar(carList: List<String>, carRacingResult: MutableList<String>): MutableList<String>{
    for(i in carList.indices){
        val randomNumber = randomCount()
        if(numberIsOverFour(randomNumber)){
            carRacingResult[i] += "-"
        }
    }
    return carRacingResult
}

fun printCarRacing(carList: List<String>, carRacingResult: MutableList<String>) {
    for(i in carList.indices){
        println(carList[i]+" : "+carRacingResult[i])
    }
}

fun findFinalWinner(carList: List<String>, carRacingResult: MutableList<String>): MutableList<String>{
    val winnerMove = carRacingResult.maxOf { it.length }
    val winnerIndex = mutableListOf<Int>()
    val winners = mutableListOf<String>()
    for(i in carList.indices){
        if(carRacingResult[i].length == winnerMove){
            winnerIndex.add(i)
        }
    }
    for(i in winnerIndex){
        winners.add(carList[i])
    }
    return winners
}

fun printFinalWinner(promt: String, finalWinners: MutableList<String>) {
    println(promt+finalWinners.joinToString(", "))
}