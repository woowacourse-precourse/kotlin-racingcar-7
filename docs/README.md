# 🔨 과제 진행 요구 사항
- [x] `gitignore`에 클래스 파일 `*.class`와 vim 백업 파일 `*~`를 추가
- [x] 기능 구현하기 전 기능 목록 정리
- [x] 기능 목록 단위로 커밋


# 🔗 기능 목록
## Model (비즈니스 로직 및 데이터 처리)
### StringNamesParser.kt (model/StringNamesParser.kt)
- [x] `,`를 기준으로 문자열을 분리하여 레이싱 상황 리스트에 넣는다.
- [x] 분리한 이름이 5글자를 넘는다면 예외를 발생시킨다.
- [x] 그 외 일반적인 이름 형식에 맞지 않는다면 예외를 발생시킨다.
    - 예: 정수, 특수문자 등 알파벳이 아닌 이름.

### CarMovement.kt (model/CarMovement.kt)
- [x] 무작위 값을 생성하고, 값이 4 이상일 경우 `true`를 반환한다.
- [x] `true`를 반환받은 경우, 자동차를 한 칸 전진시킨 값을 레이싱 상황 리스트에 저장한다.

### WinnerCheck.kt (model/WinnerCheck.kt)
- [x] 레이싱 상황 리스트를 통해 우승자를 선정하여, 우승자 리스트를 반환한다.

## View (결과 출력 및 사용자 입력)
### InputView.kt (view/InputView.kt)
- [x] 사용자로부터 **문자열**로 된 자동차 이름들을 입력받는다.
- [x] 사용자로부터 **정수**로 된 시도 횟수를 입력받는다.
- [x] 빈 문자열, 정수 미입력, 정수 외 입력, 오버플로우시 **예외**를 발생시킨다.

### OutputView.kt (view/OutputView.kt)
- [x] 각 자동차의 **이름**과 **전진 상태**를 출력한다.
- [x] 최종 우승자를 쉼표로 구분하여 출력한다.

## Controller (연산 및 흐름 제어)
### RacingGame.kt (controller/RacingGame.kt)
- [x] `InputView`를 통해 사용자 입력을 받는다.
- [x] `StringNamesParser`를 사용해 자동차 이름을 파싱한다.
- [x] 시도 횟수만큼 `CarMovement`을 반복 실행한다.
- [x] 각 라운드 결과를 `OutputView`를 통해 레이싱 상황을 출력한다.
- [x] 모든 라운드가 종료된 후, `WinnerCheck`를 통해 최종 우승자를 선정한다.
- [x] 최종 우승자를 `OutputView`를 통해 출력한다.

## Main Application (프로그램 진입점)
### Application.kt
- [x] 프로그램의 **진입점** 역할을 한다.

# 🔧 프로그래밍 요구 사항
- [x] Kotlin 1.9.24에서 실행 가능해야 한다.
- [x]  Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- [x]  프로그램 실행의 시작점은 Application의 main()이다.
- [x]  build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x]  프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x]  코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
- [x]  기본적으로 Kotlin Style Guide를 원칙으로 한다.

---

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [x] 공백 및 공백라인을 의미 있게 사용한다.
---