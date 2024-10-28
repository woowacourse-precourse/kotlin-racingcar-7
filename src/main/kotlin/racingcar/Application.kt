package racingcar

import camp.nextstep.edu.missionutils.Console

private const val INPUT_NAMES_PREFIX = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val INPUT_TURNS_PREFIX = "시도할 횟수는 몇 회인가요?"
private const val WINNER_FORMAT = "최종 우승자 : %s"

fun main() {
    val reader = MyReader()
    val writer = MyWriter()
    val parser = MyParser()

    writer.println(INPUT_NAMES_PREFIX)
    val cars = parser.parseNames(reader.readLine()).map(::Car)

    writer.println(INPUT_TURNS_PREFIX)
    val turns = parser.parseTurns(Console.readLine())

    val game = Game(cars, turns)

    game.play().forEach { results ->
        results.forEach(::println)
        println()
    }

    writer.printf(WINNER_FORMAT, game.getWinners().joinToString(transform = Car::name))

    reader.close()
    writer.close()
}






