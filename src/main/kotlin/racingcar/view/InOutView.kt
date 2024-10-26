package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Repository

class InOutView(private val repo: Repository) {
    fun input() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        repo.userInput = Console.readLine()

        println("시도할 횟수는 몇 회인가요?")
        repo.execCnt = Console.readLine().toInt()
    }

    fun printExecResultText() {
        println("\n실행 결과")
    }

    fun printAllCarsMoveCnt() {
        for (carIdx in repo.racingCars.indices) {
            printCarMoveCnt(carIdx)
        }

        println("")
    }

    private fun printCarMoveCnt(index: Int) {
        val carName = repo.racingCars[index].carName
        val position = "-".repeat(repo.racingCars[index].moveCnt)
        println("$carName : $position")
    }

    fun printWinner() {
        val winners = repo.winner.joinToString(", ")

        println("최종 우승자 : $winners")
    }
}