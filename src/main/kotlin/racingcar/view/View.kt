package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.car.Cars

fun carNamesView(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()
}

fun numberOfRoundView(): String {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine()
}

fun printResultComment() {
    println()
    println("실행 결과")
}

fun printRacingStatus(racingCars: Cars) {
    println(racingCars.toString())
}

fun raceWinnerView(racingCars: Cars) {
    println("최종 우승자 : ${racingCars.findWinners()}")
}

fun cleanUpResource() {
    Console.close()
}