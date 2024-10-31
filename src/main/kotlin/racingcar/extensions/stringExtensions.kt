package racingcar.extensions

fun String.isDuplicationName(): Boolean {
    val names = this.split(",")
    return names.size != names.toSet().size
}

fun String.isPlayerLimitExceeded(): Boolean = this.split(",").size > 5