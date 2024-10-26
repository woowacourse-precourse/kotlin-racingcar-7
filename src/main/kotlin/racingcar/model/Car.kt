package racingcar.model

class Car (val name:String){
    private var status = 0

    private fun go(){
        status++
    }
}