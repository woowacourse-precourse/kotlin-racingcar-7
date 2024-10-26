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
}