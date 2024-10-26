package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.InputView


object RacingController {
    fun run(): List<String> {
        InputView.carNames()
        val namesInput = Console.readLine()
        val names = namesInput.split(",").map { it.trim() }.filter { it.isNotEmpty() }

        require(names.isNotEmpty()) { "자동차 이름이 비어있습니다." }

        require(names.all { it.length <= 5 }) { "자동차 이름은 5자 이하이어야 합니다." }

        require(names.size >= 2) { "자동차는 최소 두 대 이상이어야 합니다." }

        return names
    }
}