package racingcar.view

import racingcar.model.Car

class Output {
    fun infoGetCarNames() = println("경주할 자동차 이름을 입력하세요.")
    fun infoGetRound() = println("시도할 횟수는 몇 회인가요?")

    fun showRoundResult(cars: List<Car>) {
        println("실행 결과")
        cars.forEach {
            print("${it.name}: ")
            repeat(it.moving) {
                print("-")
            }
            println()
        }
        println()
    }

    fun showRaceResult(cars: List<Car>) = println("최종 우승자: ${cars.joinToString(", ") { it.name }}")
}