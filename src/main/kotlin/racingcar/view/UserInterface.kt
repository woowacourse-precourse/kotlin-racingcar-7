package racingcar.view
import camp.nextstep.edu.missionutils.Console

class UserInterface {
    fun getCarName(): String? {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = readLine()
        return input
    }


}