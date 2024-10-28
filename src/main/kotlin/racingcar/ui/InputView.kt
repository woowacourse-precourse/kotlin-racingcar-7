package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import racingcar.data.Cars
import racingcar.data.Round

object InputView {
    fun parseCars() = Cars(Console.readLine())

    fun parseRound() = Round(Console.readLine())
}