package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
//    randomValue(3)
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val player = Console.readLine()
    println("시도할 횟수는 몇 회인가요?")
    val playNum = Console.readLine()
}



private fun validateData() {
    //검증 완료된 이름 값
    val name = ""
    showGameProgress(name, randomValue())
}


private fun showGameProgress(playerName: String, randomNum: Int) {
    //todo : 랜덤 수 만큼 전진하여야 한다.
    display(playerName, randomNum)

}

private fun display(name: String, distance: Int): String {
    val GO = "_"
    return "$name : ${GO.repeat(distance)}"
}


private fun randomValue(): Int {
    var validRandomNum = 0

    //만약 true 이면 나온 횟수만큼 전진, 아니면 전진하지 않는다.
    val randomNum = Randoms.pickNumberInRange(0, 9)
    if (isRandomNumberValid(randomNum)) {
        validRandomNum = randomNum
    }
    return validRandomNum
}

private fun isRandomNumberValid(randomNum: Int): Boolean {
// 뽑는 숫자가 4 이상인 경우에만 전진을 할 수 있다.
    return randomNum in 4..9
}

