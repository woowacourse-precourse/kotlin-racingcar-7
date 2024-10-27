package racingcar.viewModel

import racingcar.constans.Constants.SEPARATOR
import racingcar.delegate.ValidationDelegator
import racingcar.intent.UserInputIntent
import racingcar.intent.UserInputIntent.EnterPlayerNameIntent
import racingcar.intent.UserInputIntent.EnterPlayCountIntent
import racingcar.PlayGround
import racingcar.model.CarRacingState.PlayerState
import racingcar.model.CarRacingState.PlayResultState

class RacingViewModel(
    private val validationDelegator: ValidationDelegator,
    private val playGround: PlayGround,
) {
    private val state = mutableListOf<PlayerState>()
    private var playCount: Int = 0

    fun onCompleteInput(intent: UserInputIntent) {
        when (intent) {
            is EnterPlayerNameIntent -> onCompleteInputPlayerNames(intent)
            is EnterPlayCountIntent -> onCompleteInputPlayCount(intent)
        }
    }

    private fun onCompleteInputPlayerNames(intent: EnterPlayerNameIntent) {
        val userNames = intent.userNames
        validationDelegator.handleUserNameInput(userNames)
        val separatedNames = userNames
            .split(SEPARATOR)
            .map { it.trim() }
        readyForPlayers(separatedNames)
    }

    private fun onCompleteInputPlayCount(intent: EnterPlayCountIntent) {
        val playCount = intent.playCount
        validationDelegator.checkPlayCountIsValidNumeric(playCount)
        validationDelegator.handlePlayCountInput(playCount.toInt())
        readyForPlayCount(playCount.toInt())
    }

    fun playGame(): PlayResultState {
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