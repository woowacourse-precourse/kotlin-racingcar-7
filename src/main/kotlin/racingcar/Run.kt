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

    fun getAttemptTimes():Int {
        val attemptTimes = Console.readLine().toInt()
        return attemptTimes
    }

    fun isValidCarNames(carNames:String ):Boolean {
        if(carNames.isBlank()) throw IllegalArgumentException ("이름을 입력해 주세요.")
        if(carNames.isEmpty()) throw IllegalArgumentException ("이름을 입력해 주세요.")
        if( carNames.length < 1 && carNames.length > 5) throw IllegalArgumentException ("이름은 1자 이상 5자 이하로 입력해 주세요.")
        return true
    }
}