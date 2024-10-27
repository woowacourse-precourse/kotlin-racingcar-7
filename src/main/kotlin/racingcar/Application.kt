package racingcar

import camp.nextstep.edu.missionutils.Console as con




fun main() {

    var repeatNum: Int=0;
    var cars: List<String>
    val score: Array<Int>

    var maxScore:Int=0
    var winner:String=""

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    cars= con.readLine().split(",")

    if(cars[0]==""){throw IllegalArgumentException()}

    //자동차 이름이 5글자가 넘어가는 경우 오류 출력
    for (i: String in cars){
        if(i.length>5){
            throw IllegalArgumentException()
        }
    }

    println("시도할 횟수는 몇 회인가요?")
    repeatNum = con.readLine().toInt()

    //횟수가 1 미만일 경우 오류 출력
    if(repeatNum<1){
        throw IllegalArgumentException()
    }

    score = Array<Int>(cars.size) {0}

    println("실행 결과")

    //반복 횟수 만큼 차들의 난수를 뽑고, 이동 정도를 출력
    for (i in 1..repeatNum){
        for (j in 0..cars.size-1){
            score[j]+= pickScore()
            printScore(cars[j], score[j])
        }
        print("\n")
    }



    //전체 점수를 순회하며 승자를 판단
    for (i in 0..cars.size-1){
        if(score[i]>maxScore){
            winner=cars[i]
        }
        else if(score[i]==maxScore){
            winner=winner+", "+cars[i]
        }
    }

    println("최종 우승자 : "+winner)

}




