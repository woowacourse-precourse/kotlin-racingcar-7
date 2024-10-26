package racingcar

fun main() {
    // TODO: 프로그램 구현
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputCar = readLine()
    val cars = inputCar?.split(',')


    println("시도할 횟수는 몇 회인가요?")
    val inputCount = readLine()
    val count = inputCount

}
