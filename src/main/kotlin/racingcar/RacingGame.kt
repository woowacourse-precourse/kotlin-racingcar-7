package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {


    fun initGame() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val cars = Console.readLine()

        println("시도할 횟수는 몇 회인가요?")
        val numOfGame = Console.readLine()
    }
}