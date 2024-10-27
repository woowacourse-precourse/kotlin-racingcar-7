package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun validateName(name: String): String {
    if (name.length > 5) {
        throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
    }
    return name
}

fun divideNames(names: String): List<String> {
    val delimiter = ","

    return names.split(delimiter.toRegex()).map { name ->
        validateName(name)
    }
}

fun randomMoveForward(name: String, position: MutableMap<String, Int>) {
    val randomValue = Randoms.pickNumberInRange(0, 9)
    if (randomValue >= 4) {
        position[name] = position[name]!! + 1
    }
}

fun currentPosition(names: String, position: Map<String, Int>) {
    val finalParticipants = divideNames(names)

    finalParticipants.forEach { name ->
        val currentPosition = "-".repeat(position[name]!!)
        println("$name: $currentPosition")
    }
}

fun race(names: String, tryNumber: Int): Map<String, Int> {
    val finalParticipants = divideNames(names)
    val position = finalParticipants.associateWith { 0 }.toMutableMap()

    for (trying in 1..tryNumber) {
        finalParticipants.forEach { name ->
            randomMoveForward(name, position)
        }
        currentPosition(names, position)
        print("\n")
    }
    return position
}

fun winner(names: String, tryNumber: Int) {
    val position = race(names, tryNumber)
    val maxPosition = position.values.maxOrNull()
    val winners = position.filter {it.value == maxPosition}.keys

    println("최종 우승자 : ${winners.joinToString(", ")}")
}
