package racingcar

class Car(name: String) {
    val name: String
    var drivingDistance: Int = 0
        private set

    init {
        validateName(name)
        this.name = name
    }

    private fun validateName(name: String) {
        checkNameNotEmpty(name)
        checkNameLength(name)
    }

    private fun checkNameNotEmpty(name: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("이름이 입력되지 않았습니다.")
        }
    }

    private fun checkNameLength(name: String) {
        if (name.length > NAME_MAX_LENGTH) {
            throw IllegalArgumentException("이름이 너무 길게 입력되었습니다.")
        }
    }

    fun plusDrivingDistance() {
        checkDrivingDistanceOverflow()
        drivingDistance++
    }

    private fun checkDrivingDistanceOverflow() {
        if (drivingDistance + 1 < drivingDistance) {
            throw IllegalArgumentException("너무 큰 수가 입력되었습니다.")
        }
    }

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}