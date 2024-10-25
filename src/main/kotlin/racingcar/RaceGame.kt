package racingcar

import camp.nextstep.edu.missionutils.Randoms

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