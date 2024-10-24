package racingcar

import camp.nextstep.edu.missionutils.*

fun main() {
    val check = CheckException()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine()
    check.firstInput(cars)

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine()
    check.secondInput(tryCount)

    val raceGame = RaceGame()
    raceGame.play(cars, tryCount.toFloat().toInt())
}

class RaceGame {

    fun play(cars: String, tryCount: Int) {
        var carMap = splitCars(cars)

        println("실행 결과")
        for (i in 0 until tryCount) {
            carMap = goForward(carMap)
            result(carMap)
        }
        winner(carMap)
    }
    private fun splitCars(cars: String): MutableMap<String, Int> {
        val carMap: MutableMap<String, Int> = mutableMapOf()
        val carList = cars.split(",").map { it.trim() }
        carList.forEach {
            carMap[it] = 0
        }
        return carMap
    }
    private fun goForward(carMap: MutableMap<String, Int>): MutableMap<String, Int> {
        carMap.forEach { (name, score) ->
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMap[name] = score + 1
            }
        }
        return carMap
    }
    private fun result(gameScore: MutableMap<String, Int>) {
        gameScore.forEach {
            println("${it.key} : ${"-".repeat(it.value)}")
        }
        println()
    }
    private fun winner(gameScore: MutableMap<String, Int>) {
        val check = CheckException()
        check.result(gameScore)

        val maxScore = gameScore.values.max()
        val winnerList: MutableList<String> = mutableListOf()
        gameScore.forEach { (name, score) ->
            if (score == maxScore) {
                winnerList.add(name)
            }
        }
        println("최종 우승자 : ${winnerList.joinToString(", ")}")
    }
}

class CheckException {

    fun firstInput(car: String) {
        if (car == "" || !car.contains(",")) {
            throw IllegalArgumentException()
        }
        val carList = car.split(",").map { it.trim() }
        if (carList.size != carList.distinct().size) {
            throw IllegalArgumentException()
        }
        carList.forEach {
            if (it.isBlank() || it.length > 5) {
                throw IllegalArgumentException()
            }
        }
    }
    fun secondInput(count: String) {
        val num = count.toFloatOrNull()
        if (num == null || num <= 0 || num % 1 != 0f) throw IllegalArgumentException()
    }
    fun result(scores: MutableMap<String, Int>) {
        var check = 0
        for (score in scores) {
            if (score.value != 0)
                check += 1
        }
        if (check == 0) throw IllegalArgumentException()
    }
}