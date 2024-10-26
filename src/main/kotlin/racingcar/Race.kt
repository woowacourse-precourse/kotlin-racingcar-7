package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Race(var carList: List<Car>,var stageNumber : Int) {
    var winCarList : List<Car> = listOf()
    fun runRace(){
        println("실행 결과")
        for(i in 0..<stageNumber){
            stage()
            printNow()
        }
        winCarList = compareFinal()
        printFinal()
    }
    fun stage(){
        for(car in carList){
            runCar(car)
        }
    }
    fun runCar(car:Car){
        if(Randoms.pickNumberInRange(0,9)>=4){
            car.now++
        }
    }
    fun printNow(){
        for(car in carList){
            print(car.name+" : "+"-".repeat(car.now))
            println()
        }
        println()
    }
    fun compareFinal():List<Car>{
        var winCarList : List<Car> = listOf()
        for(car in carList){
            winCarList = compare(car, winCarList)
        }
        return winCarList
    }
    fun printFinal(){
        print("최종 우승자 :")
        for(number in winCarList.indices){
            print(" ${winCarList[number].name}")
            if(number!=winCarList.size-1){
                //중간에만 쉼표를 삽입하기 위해, 마지막 차가 아닌 경우에만 쉼표 출력
                print(",")
            }
        }
    }
    fun compare(car:Car, winCar:List<Car>):List<Car>{
        var list : MutableList<Car> = winCar.toMutableList()
        //비어있으면 우승자 리스트에 무조건 넣고
        if(winCar.isEmpty()){
            list.add(car)
        }
        //이겼으면 리스트 초기화 후 현제 차만 삽입
        else if(car.now>winCar[0].now){
            list=mutableListOf(car)
        }
        //비겼으면 리스트 뒤에 차 추가
        else if(car.now==winCar[0].now){
            list.add(car)
        }
        return list
    }
}