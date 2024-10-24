package racingcar

class Cars(val validator: Validator) {

    fun validation(names: String, iters: String) {
        val nameList = validator.splitNames(names)
        validator.nameCheck(nameList)
        validator.iterCountCheck(iters)
    }
}