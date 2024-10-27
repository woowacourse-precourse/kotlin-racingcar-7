# kotlin-racingcar-precourse
# **자동차 경주**

## **기능 요구 사항**

1. 자동차 경주 게임의 목표
    1. 사용자가 입력한 수만큼 턴이 진행되고, 각 턴 마다 n대의 자동차는 각각 전진하거나 멈춘다.
    2. 우승 조건 → 가장 멀리 이동한 자동차 (공동 우승 허용)
    3. 게임이 끝났을 때, 우승한 자동차의 이름을 출력해야 한다.


2. 자동차의 이동 조건
    1. 턴마다 각각의 자동차들은 0에서 9사이의 무작위값을 얻는다.
        1. 값이 0에서 3 사이의 수일 경우 → 정지
        2. 값이 4 이상일 경우 → 1칸 전진


3. 사용자의 입력값
    1. 게임을 시작하기 전에 사용자는 경주할 자동차의 이름들을 입력해야 한다.
        1. 사용자가 입력한 자동차들의 수가 n값이 된다.
        2. 입력된 자동차들의 이름은 쉼표(,)를 기준으로 구분된다. 쉼표를 기준으로 공백 문자는 제거한다.
        3. 자동차의 이름은 5자 이하만 가능하다.
        4. 자동차의 이름은 중복을 허용한다.
    2. 자동차의 이름을 입력한 이후에는 시도할 횟수(턴 수)를 입력해야 한다.
        1. 숫자만 입력
    3. 사용자가 잘못된 값을 입력할 경우에는 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.


4. 프로그램의 출력값
    1. 각 턴이 끝난 후에는 현재 자동차들이 얼마나 전진했는지 콘솔 출력을 통해 사용자에게 알려주어야 한다.
        1. 이때 자동차의 이름을 같이 출력해야 한다.
        2. 1칸 전진을 dash(-)로 표현한다.
        3. 이름과 전진 현황은 콜론(:)으로 구분한다.
        4. 하나의 자동차 현황을 출력하고, 줄바꿈 문자를 출력해야 한다.

        ```json
        // 출력 예시
        pobi : --
        woni : ----
        jun : ---
        ```

    2. 사용자가 입력한 턴 수만큼 게임을 진행하고, 게임이 끝나면 우승자를 출력한다.
        1. 공동 우승자가 존재할 경우, 입력받은 순서대로 정렬하고, 쉼표와 공백으로 구분한다.

        ```json
        // 출력 예시
        최종 우승자 : pobi, jun
        ```


## **입출력 요구 사항**

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

### **실행 결과 예시**

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

## **프로그래밍 요구 사항**

- **코드 구현**:
    - **Kotlin**을 사용하여 작성하고, **Kotlin 1.9.24**에서 실행 가능해야 합니다.
    - 시작점은 `Application`의 `main()` 함수입니다.
    - `build.gradle.kts`는 수정하지 않으며 외부 라이브러리 사용이 금지됩니다.
- **코딩 스타일**:
    - **Indent depth**는 최대 **2**까지만 허용됩니다.
    - 함수는 최대한 작게 만들어 **한 가지 역할**만 하도록 합니다.
- **테스트 코드**:
    - **JUnit 5**와 **AssertJ**를 이용해 테스트 코드를 작성합니다.
    - 필요한 경우 관련 문서를 참고하여 학습 후 구현합니다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### **라이브러리**

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### **사용 예시**

- 0에서 9까지의 정수 중 한 개의 정수 반환

```kotlin
Randoms.pickNumberInRange(0, 9)
```