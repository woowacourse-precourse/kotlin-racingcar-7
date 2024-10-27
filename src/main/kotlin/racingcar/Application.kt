package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/*
    - 요구사항 정리
    [] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
    [] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인

    - 기댓값 테스트 케이스
    [x] 자동차 이름으로 조건에 맞는 값이 들어오는 경우 -> pobi,jun
    [x] 자동차 이름이 쉼표로 구분되나, 공백이 있을 경우 -> pobi,  jun
    [x] 자동차 이름은 5자 이하 -> pobi
    [x] 시도할 횟수가 정수가 아닌 경우
    [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우, 그렇지 않으면 전진 X

    - 예외 테스트 케이스
    [x] 자동차 이름이 5자 이상
    [x] 시도할 횟수가 정수인 경우
 */
fun main() {
    val racingCar = RacingCar()
    racingCar.inputValue()
}

//자동차 클래스 정의
data class Car(
    val name: String,
    var count: Int = 0
) {
    //현재 점수를 "-" 문자열로 치환해주는 함수
    fun translateCount(): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until count) {
            stringBuilder.append("-")
        }
        return stringBuilder.toString()
    }
}

//레이싱 게임의 프로퍼티, 메소드를 포함한 클래스
class RacingCar {
    lateinit var carList: List<Car>
    lateinit var winnerList: ArrayList<String>

    //입력 함수
    fun inputValue() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = Console.readLine()
        blankOrNullCheck(carNameList, "")

        println("시도할 횟수는 몇 회인가요?")
        val testCount = Console.readLine()
        blankOrNullCheck("", testCount)

        println("\n실행결과")
        run(testCount.toInt())
        printWinner()
    }

    //자동차 이름 검증 함수
    fun inputCarName(carNameList: String) {
        this.carList = carNameList.split(",").map { Car(it.trim()) }
        carList.forEach {
            if (it.name.length >= 5 || it.name.isBlank())
                throw IllegalArgumentException()
        }
    }

    //이동 횟수 검증 함수
    fun inputTestCount(testCount: String) {
        try {
            confirmInteger(testCount.toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }

    //횟수가 음수일 경우 검증
    fun confirmInteger(num: Int) {
        if (num < 0) {
            throw IllegalArgumentException()
        }
    }

    //입력값이 Null, Blank 검증 함수
    private fun blankOrNullCheck(carNameList: String, testCount: String) {
        if (carNameList.isNotBlank()) {
            inputCarName(carNameList)
        } else if (testCount.isNotBlank()) {
            inputTestCount(testCount)
        } else {
            throw IllegalArgumentException()
        }
    }

    //레이싱 시작 함수
    fun run(count: Int) {
        for (i in 0 until count) {
            moveAllCar()
        }
        resultWinner()
    }

    //모든 자동차들의 이동을 알려주는 함수
    private fun moveAllCar() {
        carList.map { move(it) }
        printMove()
    }

    //자동차 이동 함수
    private fun move(car: Car) {
        when (Randoms.pickNumberInRange(0, 9)) {
            in 0..3 -> return
            else -> car.count++
        }
    }

    //이동한 현황을 알려주는 함수
    private fun printMove() {
        carList.forEach {
            println("${it.name} : ${it.translateCount()}")
        }
        println()
    }


    //우승자 검증 함수
    fun resultWinner() {
        val sortList = carList.sortedByDescending { it.count }
        val winnerScore = sortList[0].count
        winnerList = arrayListOf()
        sortList.forEach {
            if (it.count == winnerScore)
                winnerList.add(it.name)
        }
    }

    //우승자를 출력해주는 함수
    fun printWinner(): String {
        val result = winnerList.joinToString(", ")
        println("최종 우승자 : $result")
        return result
    }

}