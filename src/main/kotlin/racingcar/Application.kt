package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.max

/*
    - 요구사항 정리
    [] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
    [] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인

    - 기댓값 테스트 케이스
    [] 자동차 이름으로 조건에 맞는 값이 들어오는 경우 -> pobi,jun
    [] 자동차 이름이 쉼표로 구분되나, 공백이 있을 경우 -> pobi,  jun
    [] 자동차 이름은 5자 이하 -> pobi
    [] 시도할 횟수가 정수가 아닌 경우
    [] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우, 그렇지 않으면 전진 X

    - 예외 테스트 케이스
    [] 자동차 이름이 5자 이상
    [] 시도할 횟수가 정수인 경우
 */
fun main() {

}

//자동차 클래스 정의
data class Car(
    val name: String,
    var count: Int = 0
)

//레이싱 게임의 프로퍼티, 메소드를 포함한 클래스
class RacingCar {
    private lateinit var carList: List<Car>
    private lateinit var winnerList: ArrayList<String>

    /입력 함수
    fun inputValue() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = Console.readLine()
        blankOrNullCheck(carNameList, "")

        println("시도할 횟수는 몇 회인가요?")
        val testCount = Console.readLine()
        blankOrNullCheck("", testCount)
    }

    //입력값이 Null, Blank 검증 함수
    private fun blankOrNullCheck(carNameList: String, testCount: String) {
        if (carNameList.isNotBlank() || testCount.isNotBlank()) {
            inputCarName(carNameList)

        } else {
            throw IllegalArgumentException()
        }
    }

    //자동차 이름 검증 함수
    private fun inputCarName(carNameList: String) {
        return when {
            carNameList.length >= 5 -> throw IllegalArgumentException()
            else -> this.carList = carNameList.trim().split(",").map { Car(it) }
        }
    }

}