package racingcar

import camp.nextstep.edu.missionutils.Console


fun main() {

    CarsNameInput()
    CarsNameChecker().carsNameChecker()


}

class CarsNameInput {

    fun carsNameInput(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine()
    }
}


class CarsNameChecker {

    private val carsNameInput = CarsNameInput().carsNameInput()

    fun carsNameChecker() {

        if (carsNameInput.isBlank()) {
            throw IllegalArgumentException("이름을 입력하지 않았습니다.")
        }

        val carName = carsNameInput.split(",")

        for (i in carName) {
            if (i.count() > 5) {
                throw IllegalArgumentException("이름이 다섯 글자를 초과했습니다.")
            }
        }
    }
}