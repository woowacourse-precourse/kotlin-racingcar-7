# kotlin-racingcar-precourse

***

# 구현할 기능 목록

- [x] 자동차들의 이름 입력 기능
    - 쉼표(,)를 기준으로 구분하며, 1~5글자 만 가능하다
- [x] 라운드 횟수 입력 기능
    - 1 이상의 양의 정수로만 입력이 가능하다.
- [x] 라운드 별 자동차 이름과 거리 출력 기능
- [x] 자동차 전진 기능
    - 무작위 값이 4 이상일 경우
- [x] 레이스 참가 자동차 이름 중복 검사 기능
- [x] 레이스 참가 자동차 2대 이상인지 확인하는 기능
- [x] 0 ~ 9 사이의 랜덤 숫자 선택 기능
- [ ] 단독 우승자 판별 기능
- [ ] 공동 우승자 판별 기능
- [ ] 우승자 출력 기능
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 예외

- [x] 자동차의 이름이 1 ~ 5 글자가 아닌 경우
- [x] 자동차의 이름이 공백을 포함하였을 경우
- [x] 자동차의 이름이 줄바꿈을 포함하였을 경우
- [x] 자동차의 이름이 중복 되었을 경우
- [x] 레이싱의 참여하는 자동차가 2대 이상이 아닐 경우
- [x] 레이스의 참여하는 자동차의 정보를 입력하지 않았을 경우
- [x] 라운드 횟수 정보를 입력하지 않았을 경우
- [x] 라운드 횟수가 1이상의 양의 정수가 아닐 경우
- [x] 자동차 전진 조건 비교 값이 0~9 사이의 값이 아닐 경우

### 테스트

- [ ] 입출력을 제외한 구현 기능 별 1개 이상의 테스트가 완료되어야 한다.
    - [x] 자동차 이름 길이 확인 테스트 구현
    - [x] 자동차 이름 공백 여부 확인 테스트 구현
    - [x] 자동차 이름 줄바꿈 여부 확인 테스트 구현
    - [x] 레이스에 참가하는 자동차의 이름 중복 여부 확인 테스트 구현
    - [x] 레이스에 참가하는 자동차의 수 확인 테스트 구현
    - [x] 레이스에 참여하는 자동차 정보 입력 여부 확인 테스트 구현
    - [x] 라운드 정보 입력 여부 확인 테스트 구현
    - [x] 입력 받은 라운드 정보 1 이상의 정수 여부 확인 테스트 구현
    - [x] 자동차가 전달받은 랜덤 값이 4 이상일 경우 전진 여부 확인 테스트 구현
    - [x] 자동차가 전달받은 랜덤 값이 4 미안일 경우 스탑 여부 확인 테스트 구현
    - [x] 자동차가 전달받은 랜덤 값 범위 확인 테스트 구현
    - [x] 랜덤으로 선택한 값이 0 ~ 9 범위 확인 테스트 구현
    - [ ] 우승자가 1명일 경우 우승자 이름 확인 테스트 구현
    - [ ] 우승자가 2명 이상일 경우 우승자 이름 확인 테스트 구현

# 과제 제출 전 체크 리스트

***

- 요구 사항에 명시된 출력 형식을 따라야 한다.
- 기능 구현을 완료한 후 `.\gradlew.bat clean test`을 터미널에서 실행 시켰을 때 모든 테스트가 성공적으로 실행 되는지 확인하여야 한다.
    - 결과 화면 예시
      ```
       BUILD SUCCESSFUL in 0s
      ```

# 과제 진행 요구 사항

***

- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
    - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.

***

# 기능 요구 사항

***

### 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 입출력 요구 사항

***

### **입력**

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
```

### **출력**

- 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

### 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

# 프로그래밍 요구 사항1

***

- Kotlin 1.9.24에서 실행 가능해야 한다.
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle.kts` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Kotlin Style Guide를 원칙으로 한다.

# 프로그래밍 요구 사항1

***

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - JUnit 5 User Guide
        - AssertJ User Guide
        - AssertJ Exception Assertions
        - Guide to JUnit 5 Parameterized Tests

## 라이브러리

- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```
Randoms.pickNumberInRange(0, 9)
```