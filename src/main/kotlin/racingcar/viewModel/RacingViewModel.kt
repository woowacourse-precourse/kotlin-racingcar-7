package racingcar.viewModel

import racingcar.constans.Constants.SEPARATOR
import racingcar.delegate.ValidationDelegator
import racingcar.intent.UserInputIntent
import racingcar.PlayGround
import racingcar.intent.UserInputIntent.EnterPlayerNameState
import racingcar.intent.UserInputIntent.EnterPlayCountState
import racingcar.model.CarRacingState.PlayerState
import racingcar.model.CarRacingState.PlayResultState
import racingcar.sam.MoveCountFactory

class RacingViewModel(
    private val validationDelegator: ValidationDelegator,
    private val playGround: PlayGround,
    private val moveCountFactory: MoveCountFactory
) {
    private val state = mutableListOf<PlayerState>()
    private var playCount: Int = 0

    fun onCompleteInput(intent: UserInputIntent) {
        when (intent) {
            is EnterPlayerNameState -> onCompleteInputPlayerNames(intent)
            is EnterPlayCountState -> onCompleteInputPlayCount(intent)
        }
    }

    private fun onCompleteInputPlayerNames(intent: EnterPlayerNameState) {
        val userNames = intent.userNames
        validationDelegator.handleUserNameInput(userNames)
        val separatedNames = userNames
            .split(SEPARATOR)
            .map { it.trim() }
        readyForPlayers(separatedNames)
    }

    private fun onCompleteInputPlayCount(intent: EnterPlayCountState) {
        val playCount = intent.playCount
        validationDelegator.checkPlayCountIsValidNumeric(playCount)
        validationDelegator.handlePlayCountInput(playCount.toInt())
        readyForPlayCount(playCount.toInt())
    }

    fun onCompleteValidationCheck(): PlayResultState {
        return playGround.play(state, playCount)
    }

    private fun readyForPlayers(separatedNames: List<String>) {
        separatedNames.forEach { name ->
            state.add(PlayerState(playerName = name, position = 0))
        }
    }

    private fun readyForPlayCount(playCount: Int) {
        this.playCount = playCount
    }
}