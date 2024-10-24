package racingcar

fun main() {

}

class RaceGame(){

}

class CheckException(){

    fun firstInput(car : String){
        if(car=="") throw IllegalArgumentException()
    }
    fun racer(racers : List<String>){
        //중복된 자동차 이름이 있는 경우
        if(racers.size != racers.distinct().size){
            throw IllegalArgumentException()
        }
        //빈 문자열(또는 공백)이거나 자동차 이름의 길이가 5자가 넘는 경우
        for(racer in racers){
            if(racer.isBlank()){
                throw IllegalArgumentException()
            }
            else if(racer.length>5){
                throw IllegalArgumentException()
            }
        }
    }
    fun secondInput(count : String){
        val num = count.toIntOrNull()
        if(num==null || num <= 0 ) throw IllegalArgumentException()
    }
    fun result(scores : MutableMap<String,Int>){
        var check = 0
        for (score in scores){
            if(score.value!=0)
                check+=1
        }
        if(check==0) throw IllegalArgumentException()
    }
}