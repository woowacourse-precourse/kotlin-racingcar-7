package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val cars = carNameInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carList = splitCarName(cars)
    val tryCount = tryCountInput("시도할 횟수는 몇 회인가요?").toInt()
    val tryCountList = initTryCountList(carList.size)

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

fun initTryCountList(carListSize: Int): MutableList<Int>{
    val tryCountList = MutableList(carListSize) { 0 }
    return tryCountList
}

fun randomCount(): Int{
    val randomNumber = (0..9).random()
    return randomNumber
}

fun randomCountToCar(carList: List<String>, tryCountList: MutableList<Int>): List<Int>{
    for(i in 0..carList.size-1){
        val randomNumber = randomCount()
        if(numberIsOverFour(randomNumber)){
            tryCountList[i]++
        }
    }
    return tryCountList
}

fun numberIsOverFour(randomNumber: Int): Boolean{
    val bool: Boolean
    bool = (if(randomNumber >= 4){
        true
    } else false)
    return bool
}