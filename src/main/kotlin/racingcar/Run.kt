package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class Run {
    fun inputData(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    }
    fun generateCars(): List<String> {
        val carNames = Console.readLine().split(",").map { it.trim() }
        return carNames
    }
}