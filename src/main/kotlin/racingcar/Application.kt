package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
   try {
       val carList = getCarNames()
       val attemptCount = getAttemptCount()

       println("\n실행 결과")

       repeat(attemptCount) {
           updateCarsPosition(carList)
           printCarsPosition(carList)
       }

       printWinner(carList)
   }catch (e : Exception){
       throw IllegalArgumentException()
   }
}

fun getCarNames(): MutableList<Pair<String,Int>> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine() ?: throw IllegalArgumentException()
    val carNames = input.split(",").map { it.trim() }

   checkDuplicateNames(carNames)

    carNames.forEach { name ->
       checkInputLength(name)
    }
    return carNames.map { Pair(it,0) }.toMutableList()
}

fun getAttemptCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val attemptInput = Console.readLine() ?: throw IllegalArgumentException("입력이 비어있습니다.")

    val attemptCount = attemptInput.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요")

    if (attemptCount <= 0) {
        throw IllegalArgumentException("음수는 입력이 불가능합니다")
    }

    return attemptCount
}

fun updateCarsPosition(cars : MutableList<Pair<String,Int>>){
    cars.forEachIndexed { index, car ->
        if(Randoms.pickNumberInRange(0,9) >= 4){
            cars[index] = car.copy(second = car.second + 1)
        }
    }
}

fun printCarsPosition(cars : MutableList<Pair<String, Int>>){
    cars.forEach { (name, position) ->
        println("$name : ${"-".repeat(position)}")
    }
    println()
}

fun printWinner(cars: MutableList<Pair<String, Int>>){
    val maxSecond = cars.maxOf { it.second }
    val winner = cars.filter { it.second == maxSecond }.joinToString(", ") {it.first}
    println("최종 우승자 : $winner")
}

fun checkInputLength(carName : String){
    if(carName.length > 5){
        throw IllegalArgumentException("이름이 5글자를 넘습니다")
    }
}

fun checkDuplicateNames(carNames: List<String>) {
    if (carNames.distinct().size != carNames.size) {
        throw IllegalArgumentException("자동차 이름이 중복되었습니다.")
    }
}


