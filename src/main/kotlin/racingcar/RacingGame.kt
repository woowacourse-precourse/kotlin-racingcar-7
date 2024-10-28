package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun limitNameLength(name: String): String {
    if (name.length > 5) {
        throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
    }
    return name
}

fun isNameCheck(name: String): String {
    if (name.trim().isBlank()) {
        throw IllegalArgumentException("이름은 공백이 아니어야 합니다.")
    }
    return name.trim()
}

fun isDuplicateNames(names: List<String>) {
    if (names.size != names.toSet().size) {
        throw IllegalArgumentException("중복된 이름이 존재합니다.")
    }
}

fun divideNames(names: String): List<String> {
    val delimiter = ","

    val finalCarNames = names.split(delimiter.toRegex()).map { name ->
        isNameCheck(name)
        limitNameLength(name)
    }

    isDuplicateNames(finalCarNames)

    return finalCarNames
}

fun randomMoveForward(name: String, position: MutableMap<String, Int>) {
    val randomValue = Randoms.pickNumberInRange(0, 9)
    if (randomValue >= 4) {
        position[name] = position[name]!! + 1
    }
}

fun currentPosition(finalParticipants: List<String>, position: Map<String, Int>) {
    finalParticipants.forEach { name ->
        val currentPosition = "-".repeat(position[name]!!)
        println("$name : $currentPosition")
    }
}

fun race(finalParticipants: List<String>, tryNumber: Int): Map<String, Int> {
    val position = finalParticipants.associateWith { 0 }.toMutableMap()
    for (trying in 1..tryNumber) {
        finalParticipants.forEach { name ->
            randomMoveForward(name, position)
        }
        currentPosition(finalParticipants, position)
        println()
    }
    return position
}

fun findWinners(position: Map<String, Int>): List<String> {
    val maxPosition = position.values.maxOrNull()
    return position.filter { it.value == maxPosition }.keys.toList()
}
