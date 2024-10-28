package racingcar

class Car(val name: String) {

    private var _goState: String = ""
    val goState: String get() = _goState
}