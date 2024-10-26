package racingcar

fun main() {

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