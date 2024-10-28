package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    // 운전자 이름 리스트와 시도 횟수를 입력받을 변수 선언
    val inputName: List<String>
    val movingNumber: Int
    // 운전자 이름 리스트 입력받기
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    try {
        inputName = readLine().split(",").map { it.trim() }
        require(inputName.all { it.length <= 5 }) { "자동차 이름은 5자 이하여야 합니다." }
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }

    // 시도 횟수 입력받기
    println("시도할 횟수는 몇 회인가요?")
    try {
        movingNumber = readLine().toInt()
        require(movingNumber > 0) { "시도 횟수는 1 이상이어야 합니다." }
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }

    // 자동차 대수 세기
    val carCount = inputName.count()
    // 현재 자동차의 위치를 저장
    val location: MutableList<String?> = MutableList(carCount) {""}

    // 실행 부분
    println("실행 결과")
    // 각 자동차의 위치를 move를 통해 저장하고 출력
    for (i in 0 until movingNumber) {
        move(inputName, location)
        for (j in 0 until carCount) {
            println("${inputName[j]} : ${location[j]}")
        }
        println()
    }
    // 최종 우승자를 출력
    val winners = win(inputName, location)
    println("최종 우승자 : ${winners.joinToString(", ")}")
}

// 랜덤 뽑기로 자동차의 전진과 멈춤을 저장하고 반환
fun move(inputName: List<String>, location: MutableList<String?>): MutableList<String?> {
    val carCount = inputName.count()
    for (i in 0 until carCount) {
        val randomNumber = MutableList(carCount) { Randoms.pickNumberInRange(0, 9) }
        if (randomNumber[i] >= 4) {
            location[i] += "-"
        }
    }

    return location
}

// 최종 우승자를 리스트의 max 값으로 비교하여 반환
fun win(inputName: List<String>, location: MutableList<String?>): List<String> {
    val carCount = inputName.count()
    val winners = mutableListOf<String>()
    val result = location.filterNotNull().maxOrNull()
    for (i in 0 until carCount) {
        if (location[i] == result) {

            winners += inputName[i]
        }
    }
    return winners
}