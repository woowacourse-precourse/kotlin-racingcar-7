# 🔖 우아한테크코스 7기 2주차 프리코스 - 자동차 경주 프로그램

***

## 📃 Info
- 초간단 자동차 경주 게임을 구현하기.

***

## 🛠️ Funtion
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 💥 Test
- 1. **ApplicationTest.kt**
  - 기능 테스트: 특정 입력값으로 게임을 실행했을 때 예상되는 출력과 올바른 우승자가 나오는지 확인.
  - 예외 테스트: 자동차 이름이 5자를 초과할 경우 예외가 발생하는지 확인.
- 2. **CarTest.kt**
  - 자동차 생성 테스트: 5자 이하의 이름으로 자동차가 올바르게 생성되고 초기 위치가 0인지 확인.
  - 이름 길이 검증: 자동차 이름이 5자를 초과할 경우 예외가 발생하는지 확인.
  - 이동 테스트 - canMove가 True일 때: canMove가 true일 때 move 메서드를 호출하면 위치가 1 증가하는지 확인.
  - 이동 테스트 - canMove가 False일 때: canMove가 false일 때 move 메서드를 호출하면 위치가 증가하지 않는지 확인.
- 3. **CarsFactoryTest.kt**
  - 정상적인 자동차 생성 테스트: 유효한 자동차 이름 리스트로 자동차가 올바르게 생성되는지 확인.
  - 이름 중 5자 초과 테스트: 자동차 이름 중에 5자를 초과하는 경우 예외가 발생하는지 확인.
  - 같은 이름의 자동차 테스트: 같은 이름의 자동차가 입력된 경우 예외가 발생하는지 확인.
  - 자동차가 한 대만 입력된 경우 테스트: 자동차가 한 대만 입력된 경우 예외가 발생하는지 확인.
- 4. **MoveStrategyTest.kt**
  - isMovable 메서드 테스트: isMovable 메서드가 0과 9 사이에서 난수를 생성하여 4 이상일 때 true를 반환하는지 10번 반복해서 확인.
- 5. **StartRaceTest.kt**
   - 주어진 라운드 수만큼 자동차 이동 테스트: 주어진 라운드 수에 따라 각 자동차가 제대로 움직이는지 확인.
   - 라운드 수가 음수일 경우 예외 발생: 라운드 수가 음수일 경우 예외가 발생하는지확인
- 6. **FindWinnerTest.kt**
   - 가장 멀리 이동한 자동차가 우승자 테스트: 가장 멀리 이동한 자동차가 올바르게 우승자로 선택되는지 확인.
   - 동일한 거리 이동한 자동차 공동 우승자 테스트: 동일한 거리를 이동한 경우 공동 우승자가 올바르게 선택되는지 확인.
- 7. **InputViewTest.kt**
   - 이동 횟수가 0일 경우 예외 테스트: 이동 횟수가 0일 경우 예외가 발생하는지 확인.
   - 이동 횟수가 음수일 경우 예외 테스트: 이동 횟수가 음수일 경우 예외가 발생하는지 확인.
   - 이동 횟수에 숫자가 아닌 문자를 입력한 경우 예외 테스트: 이동 횟수에 숫자가 아닌 문자를 입력한 경우 예외가 발생하는지 확인.

***

## 📺 View
- Input
  > 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
  >
  > pobi,woni,jun
  > 
  > 시도할 횟수는 몇 회인가요?
  > 
  > 5

- OutPut
  >실행 결과
  > 
  > pobi : -
    woni :
    jun : -
  > 
  > pobi : --
    woni : -
    jun : --
  >
  > pobi : ---
    woni : --
    jun : ---
  > 
  > pobi : ----
    woni : ---
    jun : ----
  >  
  > pobi : -----
    woni : ----
    jun : -----
  >
  > 최종 우승자 : pobi, jun

- 실제 코드 구현
  - 정상입력
  
  > ![](https://velog.velcdn.com/images/seoyoun8694/post/6baabe2e-6c78-4e13-b130-b0668a23d987/image.jpg)

  - 횟수가 음수일때 / 숫자가 아닌 값을 입력했을때 예외처리
  
  >![](https://velog.velcdn.com/images/seoyoun8694/post/d6a958be-d72e-4d2b-92c2-59088c4da33a/image.jpg)
  >
  > ![](https://velog.velcdn.com/images/seoyoun8694/post/d24800b4-095a-493c-81d9-e84f6f0d139b/image.jpg)

  - 자동차 이름이 5자 이상일 경우 예외처리
  
  > ![](https://velog.velcdn.com/images/seoyoun8694/post/ec85aff3-ccfa-4a93-8fbf-3e2722e4dbad/image.jpg)

  - 자동차 이름이 빈 공백문일때 예외처리
  
  > ![](https://velog.velcdn.com/images/seoyoun8694/post/76b04411-dec8-44df-a1cc-9a80b32544f6/image.jpg)

  - 자동차가 1개일때 예외처리(자동차는 최소 2개 이상이어야 경주 가능)

  > ![](https://velog.velcdn.com/images/seoyoun8694/post/de7f72a9-9b60-4ca2-b80a-6faa443f1ec9/image.jpg)

***

## ⚙️ Requirements
- Kotlin 1.9.24에서 실행 가능해야 한다. 
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다. 
- 프로그램 실행의 시작점은 `Application`의 `main()`이다. 
- `build.gradle.kts` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다. 
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다. 
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라. 
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


***

## 📘 Library
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

***

## 🔗 Velog
- https://velog.io/@seoyoun8694/%EC%9A%B0%ED%85%8C%EC%BD%94-7%EA%B8%B0-2%EC%A3%BC%EC%B0%A8-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-%ED%9A%8C%EA%B3%A0