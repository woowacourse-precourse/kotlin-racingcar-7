package racingcar

import kotlin.random.Random

fun main() {
    racingGame()
}

/* 자동차 경주 게임을 시작하는 함수 */
fun racingGame() {
    val carList = mutableListOf<Car>() //자동차 리스트
    inputName(carList)

    val gameTimes = inputTimes() //시도할 횟수

    println("\n실행 결과")
    repeat(gameTimes) {
        startRacing(carList)
        showStatus(carList)
    }

    showWinner(carList)
}

/* 자동차 데이터 클래스 */
data class Car(
    val name: String,   //이름
    var status: String  //전진 상황
)

/* 자동차 객체를 생성하는 함수 */
fun makeCar(name: String): Car {
    return Car(name, "")
}

/* 자동차 이름을 입력 받는 함수 */
fun inputName(carList: MutableList<Car>) {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val names = readLine().toString().split(",")

    for (name in names) {
        if (name.length <= 5) { //이름이 5자 이하면 자동차 객체 생성
            carList.add(makeCar(name))
        }
        else { //5자 초과이면 IllegalArgumentException 발생, 애플리케이션 종료
            throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
        }
    }
}

/* 시도할 횟수를 입력 받는 함수 */
fun inputTimes(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()?.toInt() ?: throw IllegalArgumentException("숫자를 입력해야 합니다.")
}

/* 전진을 결정하는 함수 */
fun isMoving(): Boolean {
    val randomNum = Random.nextInt(10) //0에서 9 사이의 랜덤 값 생성

    if (randomNum >= 4) { //랜덤 값이 4 이상이면 전진
        return true
    }
    else { //아니면 멈춤
        return false
    }
}

/* 경주를 1회 실행하는 함수 */
fun startRacing(carList: MutableList<Car>) {
    for (car in carList) { //자동차 리스트에 있는 모든 자동차 객체들에 대해 전진 결정
        if (isMoving()) { //전진하면 전진 상황에 '-' 추가
            car.status += "-"
        }
    }
}

/* 현재 진행 상황을 출력하는 함수 */
fun showStatus(carList: MutableList<Car>) {
    for (car in carList) {
        println("${car.name} : ${car.status}")
    }
    println()
}

/* 우승자 안내 문구를 출력하는 함수 */
fun showWinner(carList: MutableList<Car>) {
    val maxStatusLength = carList.maxOfOrNull { it.status.length } //가장 큰 전진 횟수 찾기
    val winnerCars = carList.filter { it.status.length == maxStatusLength } //우승자 찾기

    print("최종 우승자 : ")
    winnerCars.forEach { car ->
        print("${car.name} ")
    }
}