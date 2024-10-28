package racingcar.domain.validator

import java.math.BigInteger

fun validateTryNumber(tryNumber: BigInteger) = require(tryNumber > BigInteger.ZERO)
