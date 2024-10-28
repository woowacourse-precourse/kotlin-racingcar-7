package racingcar.model

class Car (val name:String){
    private var status = 0
    fun getStatus():Int{
        return status
    }
    fun go(){
        if (Random().randomGenerator())
            status++
    }
}