package racingcar

import camp.nextstep.edu.missionutils.Console

class Game {
    fun inputData(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        GameManager.generateCars(Console.readLine())
        println("시도할 횟수는 몇 회인가요?")
        GameManager.setAttemptTimes(Console.readLine())
        GameManager.getRound()
    }

    fun play() {
        GameManager.playRound()
    }

    fun printWinners() {
        val winners = GameManager.getWinners().joinToString(separator = ",")
        println("최종 우승자 : $winners")
    }
}