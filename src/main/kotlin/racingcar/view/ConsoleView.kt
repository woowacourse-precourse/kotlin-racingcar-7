package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.model.CarList

class ConsoleView {
    fun inputCarName(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = Console.readLine()
        return carNameList
    }

    fun inputRaceCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        val raceCount = Console.readLine()
        return raceCount
    }

    fun printRaceStart() {
        println()
        println("실행 결과")
    }

    fun printRaceProcess(carList: CarList, index: Int) {
        val car = carList.getCar(index)
        val moveCount = car.getMoveCount()
        println("${car.getName()} : ${"-".repeat(moveCount)}")
    }

    fun printTurnEnd() {
        println()
    }

    fun printWinner(winnerList: List<Car>) {
        print("최종 우승자 : ")
        for (index in winnerList.indices) {
            val winner = winnerList[index]
            if (index == winnerList.lastIndex) {
                print(winner.getName()) // 마지막 요소일 때는 쉼표 없이 출력
            } else {
                print("${winner.getName()}, ") // 마지막 요소가 아닐 때는 쉼표와 함께 출력
            }
        }
    }

}