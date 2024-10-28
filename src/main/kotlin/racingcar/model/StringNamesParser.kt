package racingcar.model

import racingcar.view.ExceptionString

class StringNamesParser() {
    private val _currentStatus: MutableList<Pair<String, Int>> = mutableListOf()
    val currentStatus: MutableList<Pair<String, Int>> get() = _currentStatus

    fun parser(names: String) {
        _currentStatus.addAll(names.split(",").map { Pair(it.trim(), 0) })
        checkException(*_currentStatus.map { it.first }.toTypedArray())
    }

    private fun checkException(vararg name: String) {
        name.forEach {
            require(it.length <= 5) { ExceptionString.LENGTH }
            require(it.all { char -> char.isLetter() }) { ExceptionString.NOT_NAME }
        }
    }
}