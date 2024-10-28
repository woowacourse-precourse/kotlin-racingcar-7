package racingcar

import camp.nextstep.edu.missionutils.*;

fun main() {
    val cars = inputCars()

}

fun inputCars(): List<String>{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine().split(",").map{it.trim()}
    if (cars.any { it.isBlank() || it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해주세요.")
    }
    return cars
}


