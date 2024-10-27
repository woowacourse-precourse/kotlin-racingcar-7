package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val names: String? = Console.readLine()

    println("시도할 횟수는 몇 회인가요?")
    val roundStr: String? = Console.readLine()

    val nameListAndRound: Pair<List<String>, Int> = validate(names, roundStr)
    val carList: List<Car> = nameListAndRound.first.map {
        Car(it)
    }
    val maxRound = nameListAndRound.second
    val dice = Dice()

    println("\n실행 결과")

    listOf(1, 2, 3).sum()

    repeat(maxRound) {
        playRound(carList, dice)
    }

    val winners = findWinners(carList)

    println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
}

private fun findWinners(cars: List<Car>): List<Car> {
    var maxMove = 0
    val winnerList = arrayListOf<Car>()

    for (car in cars) {
        if (car.movedCount > maxMove) {
            maxMove = car.movedCount
            winnerList.clear()
            winnerList.add(car)

        } else if (car.movedCount == maxMove) {
            winnerList.add(car)
        }
    }

    return winnerList
}

private fun playRound(cars: List<Car>, dice: Dice) {
    for (car in cars) {
        val rollResult = dice.roll()

        if (rollResult >= 4) {
            car.move()
        }

        println(car.roundResult)
    }

    println()
}

@Throws(IllegalArgumentException::class)
private fun validate(names: String?, roundStr: String?): Pair<List<String>, Int> {
    if (names.isNullOrBlank() || roundStr.isNullOrBlank()) {
        throw IllegalArgumentException("유효하지 않은 입력값입니다. (입력값 null)")
    }

    val nameList: List<String> = names.split(",")
    val round: Int

    try {
        round = roundStr.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("유효하지 않은 입력값입니다. (라운드 정보가 숫자 형태가 아닙니다.)")
    }

    if (round < 0) {
        throw IllegalArgumentException("유효하지 않은 입력값입니다. (라운드 정보가 음수로 주어졌습니다.)")
    }

    nameList.forEach { name ->
        if (name.isEmpty()) {
            throw IllegalArgumentException("유효하지 않은 입력값입니다. (이름 길이가 0입니다.)")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("유효하지 않은 입력값입니다. (이름 길이가 5글자 초과입니다.)")
        }
    }

    return Pair(nameList, round)
}