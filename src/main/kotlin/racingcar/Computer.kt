package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Computer {

    fun inputCarName(): String = Console.readLine()

    fun inputRoundCount(): String = Console.readLine()

    fun generate() = Randoms.pickNumberInRange(1, 9)
}