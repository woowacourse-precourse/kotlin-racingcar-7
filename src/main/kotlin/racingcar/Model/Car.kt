package racingcar.Model

private const val CANT_BE_LONGER_THAN_5 = " -> 자동차 이름은 5자 이하이어야 합니다."

class Car(val name: String) {
    init {
        require(name.length <= 5) { name + CANT_BE_LONGER_THAN_5 }
    }
}