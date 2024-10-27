package racingcar.view

import camp.nextstep.edu.missionutils.Console.close
import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.constans.Constants.MESSAGE_GUIDE_FOR_INPUT_COUNT
import racingcar.constans.Constants.MESSAGE_GUIDE_FOR_USER_NAME
import racingcar.intent.UserInputIntent.EnterPlayCountIntent
import racingcar.intent.UserInputIntent.EnterPlayerNameIntent
import racingcar.model.CarRacingState.PlayResultState
import racingcar.viewModel.RacingViewModel

class RacingView(private val viewModel: RacingViewModel) {

    init {
        startGame()
        val state = viewModel.playGame()
        closeGame(state)
    }

    private fun startGame() {
        inputPlayerNames()
        inputPlayCount()
    }

    private fun inputPlayerNames() {
        val userNames = getUserInput(MESSAGE_GUIDE_FOR_USER_NAME)
        val intent = EnterPlayerNameIntent(userNames)
        viewModel.onCompleteInput(intent)
    }

    private fun inputPlayCount() {
        val playCount = getUserInput(MESSAGE_GUIDE_FOR_INPUT_COUNT)
        val intent = EnterPlayCountIntent(playCount)
        viewModel.onCompleteInput(intent)
    }

    private fun getUserInput(msg: String): String {
        println(msg)
        return readLine().trim()
    }

    private fun closeGame(state: PlayResultState) {
        state.printWinner()
        close()
    }
}