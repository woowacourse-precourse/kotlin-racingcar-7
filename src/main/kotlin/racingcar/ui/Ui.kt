package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.CarName
import racingcar.domain.CarName.Companion.asCarName

class Ui {
    fun requestCarNames(): List<CarName> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        val userInput = Console.readLine()
        return userInput.split(CAR_NAME_DELIMITER).map { it.asCarName() }
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ','
    }
}