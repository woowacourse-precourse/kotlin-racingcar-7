package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Computer {

    fun inputCarName(): String = Console.readLine()

    fun inputRoundCount(): String = Console.readLine()

    fun generate() = Randoms.pickNumberInRange(0, 9)

    fun printCarPosition(car: Car) {
        println(car.getStatus())
    }

    fun printWinner(cars: List<Car>) {
        var winnerFrontMessage = "최종 우승자 : "
        cars.forEach {
            winnerFrontMessage += it.name
        }
        println(winnerFrontMessage)
    }
}