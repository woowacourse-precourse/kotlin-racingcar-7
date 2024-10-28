package racingcar

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class InputProcessorTest {

    private val inputProcessor = InputProcessor()

    private fun provideInput(input: String) {
        Console.close()  // 기존 Scanner 인스턴스를 초기화
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }

    @AfterEach
    fun tearDown() {
        Console.close()  // 테스트 후 Scanner 초기화
    }

    @Test
    fun `자동차 이름 입력 테스트 - 정상적인 입력`() {
        provideInput("selim,sbok,smun\n")
        val result = inputProcessor.inputCarNames()
        assertThat(result).containsExactly("selim", "sbok", "smun")
    }

    @Test
    fun `자동차 이름 입력 테스트 - 이름 길이 초과 예외`() {
        provideInput("pobi,longname\n")
        assertThrows<IllegalArgumentException> { inputProcessor.inputCarNames() }
    }

    @Test
    fun `시도 횟수 입력 테스트 - 정상적인 입력`() {
        provideInput("3\n")
        val result = inputProcessor.inputAttemptCount()
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `시도 횟수 입력 테스트 - 음수 입력 예외`() {
        provideInput("-1\n")
        assertThrows<IllegalArgumentException> { inputProcessor.inputAttemptCount() }
    }

    @Test
    fun `시도 횟수 입력 테스트 - 숫자 아님 예외`() {
        provideInput("abc\n")
        assertThrows<IllegalArgumentException> { inputProcessor.inputAttemptCount() }
    }
}
