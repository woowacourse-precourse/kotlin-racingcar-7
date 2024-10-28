package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    try {
        val carNames = readLine()
        checkIsEmpty(carNames)
        println(carNames)
        var carList = carNames.split(",").map { Car(it.trim()) }
        checkNumberOfCarName(carList.map { it.name })

        println("시도할 횟수는 몇 회인가요?")
        val count = readLine().toInt()

        startGame(count, carList)
    } catch (e: Exception) {
        throw IllegalArgumentException(e.message)
    }

}
fun checkIsEmpty(s: String): Boolean {
    if (s.isBlank()) {
        throw IllegalArgumentException("자동차 이름을 입력해주세요.")
    }
    return true
}

fun checkNumberOfCarName(list: List<String>): Boolean {
    for (name in list) {
        if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.")
    }
    return true
}

fun startGame(count: Int, carList: List<Car>) {
    println("실행 결과")
    repeat(count) {
        increaseDistance(carList)
    }
}

fun getRandomNumber(min: Int, max: Int): Int =
    camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(min, max)

fun increaseDistance(list: List<Car>) =
    list.map { car ->
        val randomN = getRandomNumber(0, 9)
        if (randomN >= 4) car.increaseDistance(1)
        else car
    }