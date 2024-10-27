# kotlin-racingcar-precourse


# 기능 구현 목록

pobi,woni,jun

## View
- [ ] getCarName
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능  
  - 잘못된 값을 입력할 경우 에러 발생
  - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`

- [ ] getNumberOfAttempts
  - 몇 번의 이동을 할 것인지를 입력
  - 잘못된 값을 입력할 경우 에러 발생
  - `시도할 횟수는 몇 회인가요?`

- [ ] printRacingCar : 전진하는 자동차 출력
    - [ ] `자동차 이름`도 같이 출력

- [ ] showResult : 우승 차 출력 `최종 우승자 : ooo`
  - [ ] 여러 명일 경우 쉼표를 이용해 구분

## Controler

- [ ] run : input값을 받아서 아래의 함수들을 실행한 후 result를 view로 넘겨주는 역할

- [ ] generateCar
  - [ ] car 객체 리스트를 만들고 초기화
  
- [ ] simulateRace : 경주 시뮬레이션

- [ ] playRandom : 0에서 9 사이에서 무작위 값을 구하기

- [ ] driveCar : 전진, 멈춤
  - [ ] playRandom으로 구한 무작위 값이 4 이상일 경우

- [ ] compareMove
  - [ ] val winners: List<String>
  - [ ] 각 자동차가 얼마나 나갔는지 비교하기

## Model
- [x] data class car
  - [x] val name
  - [x] var distanceCovered