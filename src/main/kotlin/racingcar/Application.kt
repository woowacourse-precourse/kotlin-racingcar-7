package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()

    // List형태로 spilt 한 값 받아오기
    splitCarNames(input)

    println("시도할 횟수는 몇 회인가요?")
    val num = Console.readLine()

    checkNum(num)
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

// num에 대한 예외처리
fun checkNum(num: String) {
    checkIfNotNumeric(num)
    checkIfPositive(num)
}

// num이 비어있거나 숫자가 아닌 값이 포함된 경우 검사
fun checkIfNotNumeric(num: String) {
    if (num.isBlank() || num.any { !it.isDigit() }) {
        throw IllegalArgumentException("시도 횟수는 숫자로만 이루어져야 합니다.")
    }
}

// num이 0 이하인 경우 검사
fun checkIfPositive(num: String) {
    val numValue = num.toInt()
    if (numValue <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.")
    }
}