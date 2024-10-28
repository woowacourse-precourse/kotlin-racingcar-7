package racingcar

fun main() {
    val carNames = InputValidator().readCarNames() // carName 입력 및 유효성 검사
    carNames.forEach { name ->
        Racetrack.addCar(Car(name)) // Racetrack에 Car 인스턴스 리스트 저장
    }

    val attemptCount = InputValidator().readAttemptCount() // attemptCount 입력 및 유효성 검사
    Racetrack.setAttemptCount(attemptCount) // Racetrack의 attemptCount 지정

    Racetrack.startRace() // 경주 시작
}


