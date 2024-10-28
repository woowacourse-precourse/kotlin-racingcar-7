package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

data class Player(val name: String, var progress: Int = 0)

fun createPlayers(input: String): List<Player> {
    val names = input.split(",").map { it.trim() }
    validateCarNames(names)
    return names.map { name -> Player(name) }
}

fun validateCarNames(names: List<String>) {
    for (name in names) {
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("1자 이상 5자 이하 이름만 가능합니다.")
        }
    }
}