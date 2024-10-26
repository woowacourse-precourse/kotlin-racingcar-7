package racingcar

import camp.nextstep.edu.missionutils.Console

class View {
    fun getCars(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine()
    }

    fun getTryNumber(): String {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine()
    }

    fun showStatus(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.getPos())}") // pos만큼 -를 반복
        }
        println()
    }

    fun showWinners(cars: List<Car>) {
        val maxPos = cars.maxOf { it.getPos() }
        val winners = cars.filter { it.getPos() == maxPos }
        val result = winners.joinToString(", ")
        print("최종 우승자 : $result")
    }
}