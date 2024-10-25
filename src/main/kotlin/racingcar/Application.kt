package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()

    // List형태로 spilt 한 값 받아오기
    splitCarNames(input)

    println("시도할 횟수는 몇 회인가요?")
    val num = Console.readLine()
}

fun splitCarNames(input: String) {
    if (!input.contains(",")) {
        throw IllegalArgumentException("쉼표가 아닌 다른 구분자를 사용했습니다.")
    }

    val carNames = input.split(",").map { it.trim() } // 공백 제거

    // carNames에 대한 예외처리
    checkEmptyNames(carNames)
    checkDuplicateNames(carNames)
    checkNameLength(carNames)
    checkNameNumber(carNames)

    makeCarKey(carNames)
}

// 각 자동차 이름을 Pair<String, Int>로 변환, Int는 0으로 설정
fun makeCarKey(carNames: List<String>): List<Pair<String, Int>> {
    return carNames.map { name -> Pair(name, 0) }
}

// 자동차 이름이 비어있는지 확인
fun checkEmptyNames(carNames: List<String>) {
    if (carNames.any { it.isEmpty() }) {
        throw IllegalArgumentException("자동차 이름이 공백일 수 없습니다.")
    }
}

// 중복된 이름이 있는지 확인
fun checkDuplicateNames(carNames: List<String>) {
    if (carNames.size != carNames.distinct().size) {
        throw IllegalArgumentException("중복된 이름이 포함되어 있습니다.")
    }
}

// 자동차 이름의 길이가 5자를 넘는지 확인
fun checkNameLength(carNames: List<String>) {
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }
}

// 자동차 이름이 숫자로만 이루어졌는지 확인
fun checkNameNumber(carNames: List<String>) {
    if (carNames.any { it.all { char -> char.isDigit() } }) {
        throw IllegalArgumentException("자동차 이름은 숫자로만 이루어질 수 없습니다.")
    }
}
