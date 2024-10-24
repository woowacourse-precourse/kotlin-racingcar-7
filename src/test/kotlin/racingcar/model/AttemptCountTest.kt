package racingcar.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AttemptCountTest {

    @Test
    fun `1이상의 정수가 아니면 에러를 발생하는지 확인하는 테스트`() {
        assertThrows<IllegalArgumentException> {
            AttemptCount(0)
            AttemptCount(-5)
        }
    }
}