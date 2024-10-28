package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import racingcar.data.Cars

object InputView {
    fun parseCars() = Cars(Console.readLine())
}