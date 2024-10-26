package racingcar.view

import racingcar.model.Car
import racingcar.utils.Constants
import java.lang.StringBuilder

class Output {
    fun printResultMessage(){
        println(Constants().RESULT)
    }

    fun printEachRacingResult(car: Car){
        val status = StringBuilder()
        status.append(car.name)
        status.append(Constants().COLON)
        repeat(car.getStatus()){
            status.append(Constants().DASH)
        }
        println(status)
    }

    fun printWinner(winners:Map<String,Int>){
        val winner = StringBuilder()
        winner.append(Constants().WINNER)
        winner.append(winners.keys.joinToString { Constants().COMMA })
        println(winner)
    }
}