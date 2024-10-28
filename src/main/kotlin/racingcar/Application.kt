package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
fun Run.execute(): Run {
    inputData()
    play()
    printWinners()
    return this
}

fun main() {
    Run().execute()
}
