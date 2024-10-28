package racingcar

fun main() {
    val userCarName = getCarName()
    val userCarList = parseCar(userCarName!!)
}

fun getCarName(): String? {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readlnOrNull()
}

fun parseCar(input: String): List<String> {
    val userCarList: List<String> = input.split(",")
    return userCarList
}
