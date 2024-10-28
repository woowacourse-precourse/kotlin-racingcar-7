package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
//    randomValue(3)
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val player = Console.readLine()
    println("시도할 횟수는 몇 회인가요?")
    val playNum = Console.readLine()
    val carList = Car(player)
//    validateData(carList.carRun())

}

private fun showGameProgress(playerName: String, randomNum: Int) {
    //todo : 랜덤 수 만큼 전진하여야 한다.
    println("showGameProgress : ${playerName} ${randomNum}")

}
