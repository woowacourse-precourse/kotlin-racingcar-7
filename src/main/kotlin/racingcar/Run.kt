package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class Run {
    fun inputData(){

    }

    fun generateCars():List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine().split(",").map { it.trim() }
        return carNames
    }


    fun moveForward():Int {
        var position: Int = 0
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            position++
        }
        return position
    }

    fun race() {
        val roundTimes = getAttemptTimes()
        repeat(roundTimes) { playRound() }
    }

    fun playRound(cars: List<generateCars>) {
        cars.forEach {
            moveForward()
        }
    }
}