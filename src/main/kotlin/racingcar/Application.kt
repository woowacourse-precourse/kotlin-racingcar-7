package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val carMap = mutableMapOf<String, Int>()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    // TODO : trim() ? 으로 공백 제거? // 커밋 body에 올렸다 PR 설명에 적기
    for (i in readLine().split(",")) {
        carMap.put(i, 0)
    }
}
