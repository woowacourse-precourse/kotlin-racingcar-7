# kotlin-racingcar-precourse

## 요구사항
1. kotlin에서 제공하는 api를 적극 활용한다.
2. 배열 대신 컬렉션을 사용한다.
3. 축약하지 않는다.

- [x] 기능 구현 전 기능 목룍을 만든다.
- [x] 기능 단위로 커밋한다.

## 과제 기능 요구사항
### 자동차 경주 게임
- [ ] 전진할 때는 자동차 이름을 같이 출력한다.
- [ ] 전진 조건은 무작위 값이 4 이상일 경우
- [ ] 마지막에 우승자를 알려준다.
  - [ ] 우승자는 여러명일 수 있고 ,로 구분한다.
- [ ] 잘못된 값을 입력 할 경우 IllegalArgumentException를 발생한다.
- [ ] indent, depth를 3이 넘지 않도록 한다.
- [ ] 함수는 한 가지 일만 하도록 한다.

# 프로그램 진행
## 시작 전
- [x] 시작 문구를 출력한다.
- [x] 시도할 횟수 문구를 출력한다.
## 입력
- [x] 이름을 입력한다.
- [x] 시도할 횟수를 입력한다.
##  player
- [ ] 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분한다)결정한다.
- [ ] 시도할 횟수 결정하기
## Car
- [ ] 자동차에 이름이 있다.
- [ ] 차를 랜덤수에 맞게 전진시킨다. (move)
## Racing
- [ ] 시도할 횟수 결정하기

## Winner
- [ ] 우승한 차들을 담은 List(cars)

## 유효성 검증
해당 문자열이 유효한지 검증하는 객체
- [ ] 무작위 값이 4 이상인지 검증.
- [ ] ,로 구분된 문자열의 길이가 공백인지 검증.
- [ ] 이름이 5자 이하인지 판별한다.
- [ ] 0~9 사이의 랜던값을 뽑는다.

