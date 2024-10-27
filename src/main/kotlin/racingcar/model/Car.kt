package racingcar.model

// 자동차의 이동 로직 구현 함수, 4 이상일시 1칸 이동
data class Car(val name: String, var position: Int = 0) {
    companion object {
        private const val MOVE_THRESHOLD = 4
    }

    fun move(randomNumber: Int) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++
        }
    }
}