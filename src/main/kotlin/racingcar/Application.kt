package racingcar

fun main() {
    val (cars, n) = input()

}

fun input(): Pair<List<String>, Int> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = readLine()!!.trim().split(",")
    println("시도할 횟수는 몇 회인가요?")
    val n = readln().toInt()
    return Pair(cars, n)
}