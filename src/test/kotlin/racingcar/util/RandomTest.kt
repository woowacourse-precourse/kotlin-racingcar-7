package racingcar.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import racingcar.utils.Random

@DisplayName("랜덤값 테스트 케이스")
class RandomTest {
    @DisplayName("랜덤 값 1,000번 추출 중 0 ~ 9 범위를 벗어난 경우")
    @RepeatedTest(1_000)
    fun randomInRange() {
        Assertions.assertTrue { Random.pick() in 0..9 }
    }
}