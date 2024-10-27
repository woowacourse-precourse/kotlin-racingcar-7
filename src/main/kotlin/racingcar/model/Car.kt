package racingcar.model

// 자동차의 이동 로직 구현 함수, 4 이상일시 1칸 이동
data class Car(val name: String, var position: Int = 0) {
    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
    }
}