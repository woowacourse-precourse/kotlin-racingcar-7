package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")

    val names = try {
        Console.readLine()
    } catch (e: Exception) {
        ""
    }

    println("시도할 횟수는 몇 회인가요?")

    val tryNumber = try {
        Console.readLine()
    } catch (e: Exception) {
        ""
    }

    println("실행 결과")
}

fun race(names: String, tryNumber: Int) {
    val delimiter = ","

    val finalParticipants = names.split(delimiter.toRegex()).map { name ->
        try {
            if (name.length > 5) {
                throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
            }
            name
        } catch (e: IllegalArgumentException) {
            println("잘못된 값이 입력되었습니다: ")
        }
    }
}
