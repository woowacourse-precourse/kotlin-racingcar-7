package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine().split(",")
    }

    fun readTryCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine()

    }

    fun validateCarNames(names: List<String>) {
        require(names.isNotEmpty()) { "자동차 이름 입력은 비어있을 수 없습니다." }
        names.forEach { name ->
            require(name.length <= 5) { "자동차 이름은 5자 이내로 작성되어야 합니다." }
            require(name.isNotBlank()) { "자동차 이름이 빈칸입니다." }
        }
        require(names.size == names.toSet().size) { "자동차 이름이 중복되었습니다." }
    }

    fun validateTryCount(count: Int) {
        require(count > 0) { "시도할 횟수는 0이 될 수 없습니다." }
    }
}