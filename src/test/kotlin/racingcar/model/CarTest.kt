package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `자동차 이름 생성 테스트`() {
        val car = Car("pobi")

        assertThat(car.name).isEqualTo("pobi")
    }


    @Test
    fun `자동차 이름이 5글자를 초과하면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("javaji")
        }
    }

    @Test
    fun `자동차 이름이 빈 문자열이면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `move 메서드를 호출하면 위치가 1 증가한다`() {
        val car = Car("pobi")
        car.move() // move 호출
        assertThat(car.position).isEqualTo(1) // 위치가 1 증가했는지 확인
    }
}