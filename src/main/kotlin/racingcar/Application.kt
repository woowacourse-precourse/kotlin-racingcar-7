package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputName = Console.readLine()
    println("시도할 횟수는 몇 회인가요?")
    val inputNumber = Console.readLine()
    println("\n실행 결과")
    val racingCar = RacingCar(inputName)
    val racingGame = RacingGame(inputNumber)
    val result = racingGame.gameStart(racingCar.racingCarsWithNumber, racingGame.number)
}
