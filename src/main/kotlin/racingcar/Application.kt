package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine().split(",")
    for (i in cars.indices) {
        if (cars[i].count() > 5) {
            throw IllegalArgumentException("잘못된 입력입니다. (자동차의 이름은 5자 이하여야 합니다.)")
        }
    }

    println("시도할 횟수는 몇 회인가요?")
    val count: Int
    try {
        count = Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력입니다. (횟수는 정수로만 입력되어야 합니다.)")
    }

    println()

    var race = ArrayList<String>()
    for (i in cars.indices) {
        race.add("")
    }

    println("실행 결과")
    for (i in 0 until count) {
        for (j in cars.indices) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                race[i] += "-"
            }
            println(cars[i] + " : " + race[i])
        }
        println()
    }

    val gameResult = race.max()
    val winners = ArrayList<String>()
    for (i in race.indices) {
        if (race[i] == gameResult) {
            winners.add(cars[i])
        }
    }
    println("최종 우승자 : " + winners.joinToString(", "))
}