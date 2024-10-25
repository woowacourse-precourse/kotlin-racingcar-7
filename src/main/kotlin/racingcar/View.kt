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

    fun showWinners(tryNum: Int, cars: List<Car>) {
        val winners = cars.filter { it.getPos() == tryNum }
        print("최종 우승자 : ")
        for (i in 0 until winners.size - 1) {
            print("${winners[i].name}, ")
        }
        print(winners.last().name)
    }
}