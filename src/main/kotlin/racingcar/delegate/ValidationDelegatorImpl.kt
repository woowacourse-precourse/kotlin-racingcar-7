package racingcar.delegate

import racingcar.constans.Constants.SEPARATOR
import racingcar.delegate.playCount.PlayCountErrorDelegator
import racingcar.delegate.name.NameErrorDelegator

class ValidationDelegatorImpl(
    private val nameErrorDelegator: NameErrorDelegator,
    private val playCountErrorDelegator: PlayCountErrorDelegator
) : ValidationDelegator {

    override fun handleUserNameInput(userNames: String) {
        val separatedNames = userNames.split(SEPARATOR)
        nameErrorDelegator.checkInputIsEmpty(userNames)
        nameErrorDelegator.checkForInvalidSeparator(separatedNames)
        nameErrorDelegator.checkForInvalidNameFormat(separatedNames)
        nameErrorDelegator.checkForEmptyName(separatedNames)
        nameErrorDelegator.checkForInvalidPlayerCount(separatedNames)
        checkForPlayerNameIsDuplicated(separatedNames)
    }

    override fun checkForPlayerNameIsDuplicated(userNames: List<String>) {
        val groupedNames = userNames.groupingBy { it }.eachCount()
        nameErrorDelegator.checkForDuplicateName(groupedNames)
    }

    override fun checkPlayCountIsValidNumeric(playCount: String) {
        playCountErrorDelegator.checkPlayCountIsEmpty(playCount)
        playCountErrorDelegator.checkForChangeableToLong(playCount)
        playCountErrorDelegator.checkForExceededMaxInt(playCount.toLong())
        playCountErrorDelegator.checkInvalidPlayCountFormat(playCount)
        playCountErrorDelegator.checkInvalidPlayCountRange(playCount)
    }

    override fun handlePlayCountInput(playCount: Int) {
        playCountErrorDelegator.checkInvalidPlayCountByZero(playCount)
        playCountErrorDelegator.checkExceededMaxPlayCount(playCount)
    }
}