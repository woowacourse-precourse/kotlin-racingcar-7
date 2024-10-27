# kotlin-racingcar-precourse

# 🏁 자동차 경주 게임

자동차 경주 게임은 여러 대의 자동차가 전진 조건을 만족시키며 경주하는 콘솔 기반 게임입니다. <br>
주어진 횟수 동안 가장 멀리 이동한 자동차가 우승하게 되며, 여러 대가 공동 우승할 수도 있습니다.

## 📋 기능 목록

### 1. 자동차 이름 입력 및 검증

쉼표로 구분된 자동차 이름을 입력받으며, 각 이름은 5자 이하이어야 합니다. <br>
잘못된 이름 형식이 입력되면 IllegalArgumentException이 발생하고 종료됩니다.

### 2. 시도 횟수 입력 및 검증

사용자가 시도 횟수를 입력하며,
숫자가 아니거나 유효하지 않은 입력일 경우 IllegalArgumentException을 발생시킵니다.

### 3. 자동차 이동 로직

각 자동차는 0에서 9 사이의 무작위 숫자에 따라 전진 여부가 결정됩니다.
무작위 숫자가 4 이상일 경우 자동차가 전진합니다.

### 4. 라운드별 진행 상황 표시

각 라운드마다 자동차의 진행 상황을 출력합니다. <br>
출력할 때 자동차 이름과 진행도를 표시합니다. (예: `pobi : ----`)

### 5. 최종 우승자 결정

모든 라운드가 끝난 후 가장 멀리 간 자동차가 우승자로 결정됩니다. <br>
공동 우승자가 있을 경우, 우승자 이름을 쉼표로 구분하여 출력합니다.

## 💭 입력 처리 케이스

### 1. 빈 문자열이 입력된 경우

자동차 이름 입력 시 입력값이 빈 문자열 `""`이면, `IllegalArgumentException`을 발생시킵니다. <br>
예: `""` → `IllegalArgumentException`

### 2. 잘못된 입력 형식이 포함된 경우

입력값에 쉼표 이외의 특수문자가 포함되어 있으면 `IllegalArgumentException`을 발생시킵니다. <br>
예: `"**po,!java"`, `"$5ab,^bana"`, `"#zxc,(ab)"` → `IllegalArgumentException`

### 3. 음수 값이 포함된 경우

시도 횟수로 0 이하의 숫자를 입력하면 `IllegalArgumentException`을 발생시킵니다. <br>
예: `"0"`, `"-1"`, `"-10"` → `IllegalArgumentException`

### 4. 자동차 이름이 6자 이상인 경우

자동차 이름이 6자 이상이면 `IllegalArgumentException`을 발생시킵니다. <br>
예: `"apple,banana"`, `pineapple,elephant` → `IllegalArgumentException`

