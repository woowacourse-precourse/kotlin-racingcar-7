package racingcar.Model

object Exception {
    fun errorComesUpWith(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }
}