package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(val inputNumber: String) {
    var number = 0
    fun NumericCheck() {
        if (inputNumber.all { it.isDigit() }) {
            number = inputNumber.toInt()
        } else throw IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
    }

    fun MinCheck() {
        if (number < 1) {
            throw IllegalArgumentException("[ERROR] 최소 1 이상의 숫자를 입력하세요.")
        }
    }

    fun validateNumber() {
        NumericCheck()
        MinCheck()
    }

    fun gameStart(racingCars: MutableMap<String, Int>, number: Int) {
        var finalLog = ""
        // depth 가 3이므로 분리 필요
        for (i in 1..number) {
            for (racingCar in racingCars.keys) {
                moveCar(racingCars, racingCar)
                val movements = racingCars[racingCar] ?: 0
                val racingLog = getRacingLog(racingCar, movements)
                finalLog = finalLog + racingLog + "\n"
            }
            finalLog += "\n"
        }
        print(finalLog)
        printWinner(racingCars)
    }

    fun moveCar(racingCars: MutableMap<String, Int>, racingCar: String) {
        val condition = Randoms.pickNumberInRange(0, 9)
        if (condition >= 4) {
            racingCars[racingCar] = racingCars.getOrDefault(racingCar, 0) + 1
        }
    }

    fun getRacingLog(racingCar: String, movements: Int): String {
        var racingLog = "$racingCar : "
        for (i in 1..movements) {
            racingLog += "-"
        }
        return racingLog
    }

    fun printWinner(racingCars: MutableMap<String, Int>) {
        val maxValue = racingCars.values.max()
        val maxKeys = racingCars.filter { it.value == maxValue }.keys
        println("최종 우승자 : ${maxKeys.joinToString(",")}")
    }
}