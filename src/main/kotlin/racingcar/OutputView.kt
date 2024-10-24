package racingcar

class OutputView {

    fun printNotice(message: String) {
        println(message)
    }

    fun printErrorMessage(message: String) {
        throw IllegalArgumentException(message)
    }
}