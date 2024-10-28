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
        for (i in 1..number) {//1. number 만큼 반복
            // 아래 for 문을 number 만큼 반복한다
            for (racingCar in racingCars.keys) {//2. racingCars 의 키 갯수 만큼 반복
                // 아래 코드를 자동차 수만큼 반복한다
                val condition = Randoms.pickNumberInRange(0, 9)//3-1. 전진 조건에 따라 racingCar 의 value +1
                if (condition >= 4) {
                    racingCars[racingCar] = racingCars.getOrDefault(racingCar, 0) + 1
                }

                var racingLog = "$racingCar : "//3-2. 전진 횟수 만큼 "-" 추가
                val movements = racingCars[racingCar] ?: 0
                for (j in 1..movements) {
                    racingLog += "-"
                }
                finalLog = finalLog + racingLog + "\n"
            }
            finalLog += "\n"
        }
        println(finalLog)
    }
}