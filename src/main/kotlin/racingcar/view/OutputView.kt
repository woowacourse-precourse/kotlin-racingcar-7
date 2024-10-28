package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Racing

class OutputView {
    fun printWinner(winner: List<Car>){
        val winners = winner.joinToString(", "){it.name}
        println("최종 우승자 : $winners")
    }
}