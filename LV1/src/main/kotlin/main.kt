//import java.lang.NumberFormatException
import kotlin.random.Random

fun main(args: Array<String>) {
    /*
    val matija = Die()
    println("Defaultni kontruktor: ($matija.DieNumber)")
    println(matija)
    matija.roll()
    println(matija.DieNumber)
    */

    val ListOfdices = mutableListOf<Die>(Die(),Die(),Die(),Die(),Die())

    val PokerDices=mutableListOf<Die>(Die(2),Die(2),Die(3),Die(3),Die(3))
    val YahtzeeDices = mutableListOf<Die>(Die(6),Die(6),Die(6),Die(6),Die(6))
    val FourOfAKind = mutableListOf<Die>(Die(2),Die(2),Die(2),Die(2),Die(1))
    val ThreeOfAKind = mutableListOf<Die>(Die(2),Die(2),Die(2),Die(5),Die(1))

    //Ne radi!!!!
    val LargeStraight = mutableListOf<Die>(Die(1),Die(2),Die(3),Die(4),Die(5))

    val DiceInHands = Hand(ListOfdices)


    //DiceInHands.printHand()
    DiceInHands.rollHand()
    DiceInHands.printHand()


    //DiceInHands.isLargeStraight()
    //DiceInHands.isSameNumber()

    var answer:String?
    var DiceToRoll: Int?
    var numberOfDiceToRoll: Int?
    val DicesToRoll = mutableListOf<Int>()

    do {
        println("Do you want to roll again (Enter 'yes' or 'no')")
        answer = readLine()!!.toString()

        if (answer=="yes"){

            println("How many dice do you want to roll again? ")
            numberOfDiceToRoll = readLine()!!.toInt()

            if(numberOfDiceToRoll==5){
                DiceInHands.rollHand()
                DiceInHands.printHand()
            }else {
                for (i in 1..numberOfDiceToRoll) {
                    println("Enter dice number you want to roll again")
                    DicesToRoll.add(readLine()!!.toInt())
                }
                DiceInHands.rollSpecificDice(DicesToRoll)
            }
        }
        /*
        if (answer=="yes"){
            println("Enter dice number you want to roll again")
            DiceToRoll = readLine()!!.toInt()
            if(DiceToRoll !is Int) {
            } else {
                println(DiceInHands.rollSpecificDice(DiceToRoll))
            }
        }*/
    }while (answer!="no")

    println("Your final hand")
    DiceInHands.printHand()

    /*
    println("Enter dice you want to roll again")
    var DiceToRoll: Int?
    DiceToRoll = readLine()!!.toInt()

    if(DiceToRoll !is Int) {
        //DiceInHands.printHand()
    } else {
        println(DiceInHands.rollSpecificDice(DiceToRoll))
    }*/



}

class Die(var DieNumber:Int){

    //Defaultni constructor
    constructor():this(0)

    fun roll(){
        //until ne uključuje gornju granicu dakle ako želimo 6 mora biti 7
        DieNumber=Random.nextInt(1,7)
    }

    override fun toString(): String {
        return "Die number: $DieNumber"
    }


}

interface IResultCheck{
    //može li se nekako napraviti da pri definiranju ne vraća nikakv tip. Da se makne "return true"

    /*fun isYahtzee():Boolean{
        return true
    }*/

    /*fun isLargeStraight(){}*/

    fun isSameNumber(){}

}

class Hand(var DieInHands: List<Die>) : IResultCheck{
    fun printHand(){
        for (dice in DieInHands) {
            println(dice)
        }
        //isLargeStraight()
        isSameNumber()
    }

    fun rollHand(){
        for (dice in DieInHands) {
            dice.roll()
        }
    }

    fun rollSpecificDice(diceToRoll:List<Int>){

        for (i in 0 until diceToRoll.size) {
            DieInHands[diceToRoll[i] - 1].roll()
        }
        printHand()
    }
/*
    fun rollSpecificDice(diceToRoll:Int){
        DieInHands[diceToRoll-1].roll()
        printHand()
    }*/

    /*
    override fun isYahtzee():Boolean {
        //val YahtzeeHand = listOf<Int>(1,2,3,4,5)
        for (number in 1..6) {

            //Može li na drugačiji/bolji način
            if(DieInHands.containsAll(listOf(number,number,number,number,number))){
              return true
          }
        }
        return false
    }*/

    //Skala 1-2-3-4-5 ili 2-3-4-5-6
    /*override fun isLargeStraight(){
        val LargeStraightHand1 = listOf<Die>(Die(1),Die(2),Die(3),Die(4),Die(5))
        val LargeStraightHand2 = listOf<Int>(2,3,4,5,6)


        if(DieInHands.containsAll(LargeStraightHand1)) {
            println("You got a large straight!!!")
        }else if (LargeStraightHand2.containsAll(DieInHands)){
            println("You got a large straight!!!")
        }else{
            println("You haven't got a large straight")
        }
    }*/


    override fun isSameNumber(){

        /*
        var NoOfOnes=0
        var NoOfTwos=0
        var NoOfThrees=0
        var NoOfFours=0
        var NoOfFives=0
        var NoOfSixes=0*/

        val numbersMap = mutableMapOf("NoOfOnes" to 0, "NoOfTwos" to 0,"NoOfThrees" to 0,"NoOfFours" to 0,"NoOfFives" to 0,"NoOfSixes" to 0)



        for(number in DieInHands){
            when(number.DieNumber) {
                1 -> numbersMap.merge("NoOfOnes",1, Int::plus)
                2 -> numbersMap.merge("NoOfTwos",1, Int::plus)
                3 -> numbersMap.merge("NoOfThrees",1, Int::plus)
                4 -> numbersMap.merge("NoOfFours",1, Int::plus)
                5 -> numbersMap.merge("NoOfFives",1, Int::plus)
                6 -> numbersMap.merge("NoOfSixes",1, Int::plus)
                else -> println("Not a number!!")
            }
        }

        val LargeScale: Boolean=numbersMap.containsValue(1) && numbersMap.containsValue(1) && numbersMap.containsValue(1) && numbersMap.containsValue(1) && numbersMap.containsValue(1)

        if (numbersMap.containsValue(5)){
            //5 istih brojeva
            println("YAHTZEE !!!")
        }else if(numbersMap.containsValue(2) && numbersMap.containsValue(3)){
            //2 + 3 ista broja
            println("Poker !!!")
        }else if(numbersMap.containsValue(4)){
            //četiri ista broja
            println("You got four of a kind !!!")
        }else if(numbersMap.containsValue(3)) {
            //tri ista broja
            println("You got three of a kind !!!")
        }else if(LargeScale){
            //može li nekako sa numbersMap.all {  }
            //skala 1-2-3-4-5 ili 2-3-4-5-6
            println("You got large scale !!!")
        }
    }
}




/*
val numbers = mutableListOf<Int>(6,5,4,3,2,1)
val dice= mutableListOf<Die>(Die(),Die(),Die(),Die(),Die(),Die())

for(die in dice){
   println(die)
   die.roll()
}
*/

