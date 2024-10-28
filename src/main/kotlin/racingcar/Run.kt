package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class Run {
    fun inputData(){
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        Process.generateCars(Console.readLine())
        println("시도할 횟수는 몇 회인가요?")
        Process.setAttemptTimes(Console.readLine())
        Process.getRound()
    }

    fun play() {
        Process.playRound()
    }

    fun printWinners() {
        val winners = Process.getWinners().joinToString(separator = ",")
        println("최종 우승자 : ")
    }
}