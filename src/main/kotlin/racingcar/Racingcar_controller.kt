package racingcar

import camp.nextstep.edu.missionutils.Randoms

//점수 뽑는 함수
fun pickScore(): Int {
    var randomNum : Int = Randoms.pickNumberInRange(0,9)
    if(randomNum>=4){
        return 1
    }
    return 0
}

//점수 출력용 함수
fun printScore(name : String,score : Int){
    print(name+" : ")
    for (i in 1..score){
        print("-")
    }
    print("\n")
}