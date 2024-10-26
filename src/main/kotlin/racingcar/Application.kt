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