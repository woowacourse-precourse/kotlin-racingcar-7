package racingcar.delegate

interface ValidationDelegator {
    fun handleUserNameInput(userNames: String)
    fun checkForPlayerNameIsDuplicated(userNames: List<String>)
    fun checkPlayCountIsValidNumeric(playCount: String)
    fun handlePlayCountInput(playCount: Int)
}