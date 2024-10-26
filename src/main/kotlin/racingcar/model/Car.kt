package racingcar.model

class Car (val name:String){
    private var status = 0

    fun go(){
        status++
    }
}