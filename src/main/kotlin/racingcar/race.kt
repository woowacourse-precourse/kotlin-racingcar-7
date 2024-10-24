package racingcar

import camp.nextstep.edu.missionutils.Console

class race {
    private val nameGuide = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private val iterGuide = "시도할 횟수는 몇 번인가요?"

    fun start() {
        println(nameGuide)
        val names = Console.readLine()
        println(iterGuide)
        val iters = Console.readLine()
    }
}