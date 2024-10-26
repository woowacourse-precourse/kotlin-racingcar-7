package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarList

class ConsoleView {
    fun inputCarName(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = Console.readLine()
        return carNameList
    }

    fun inputRaceCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val raceCount = Console.readLine()
        return raceCount.toInt()
    }

    fun printRaceProcess(carList: CarList, index: Int) {
        val car = carList.getCar(index)
        val moveCount = car.getMoveCount()
        println("${car.getName()} : ${"-".repeat(moveCount)}")
    }

}