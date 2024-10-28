package racingcar.util

import java.math.BigInteger

fun repeat(times: BigInteger, action: () -> Unit) {
    var remainingTimes = times

    while (remainingTimes > BigInteger.ZERO) {
        action()
        --remainingTimes
    }
}
