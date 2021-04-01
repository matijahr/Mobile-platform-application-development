//import java.lang.NumberFormatException
import kotlin.random.Random
//eachCount

fun main(args: Array<String>) {


    val ListOfdices = mutableListOf<Die>(Die(),Die(),Die(),Die(),Die())
    val DiceInHands =  Hand(ListOfdices)

    DiceInHands.rollHand()
    DiceInHands.printHand()
    DiceInHands.ResaultCheck()

    var answer:String
    var numberOfDiceToRoll: Int
    val DicesToRoll = mutableListOf<Int>()

    do {
        println("Do you want to roll again (Enter 'yes' or 'no')")
        answer = readLine() ?: ""

        if (answer=="yes"){

            println("How many dice do you want to roll again? ")
            numberOfDiceToRoll = readLine()!!.toInt()

            if (numberOfDiceToRoll>5 || numberOfDiceToRoll==0){
                numberOfDiceToRoll=0;
                println("Wrong input")
            }

            if(numberOfDiceToRoll==5){
                DiceInHands.rollHand()
            }else if (numberOfDiceToRoll!=0){
                for (i in 1..numberOfDiceToRoll) {
                    println("Enter dice number you want to roll again")
                    DicesToRoll.add(readLine()!!.toInt())
                }
                DiceInHands.rollSpecificDice(DicesToRoll)
            }
            DiceInHands.printHand()
            DiceInHands.ResaultCheck()


        }
    }while (answer!="no")

    println("Your final hand")
    DiceInHands.printHand()
    DiceInHands.ResaultCheck()

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

    fun isYahtzee():Boolean{
        return true
    }

    fun isLargeStraight():Boolean{
        return true
    }

    fun isPoker():Boolean{
        return true
    }

    fun isThreeOfAKind():Boolean{
        return true
    }

    fun isFourOfAKind():Boolean{
        return true
    }

    fun checkNumberInHand(){}

}

class Hand(var DieInHands: List<Die>) : IResultCheck{

    val numbersMap = mutableMapOf("NoOfOnes" to 0, "NoOfTwos" to 0,"NoOfThrees" to 0,"NoOfFours" to 0,"NoOfFives" to 0,"NoOfSixes" to 0)

    fun printHand(){
        for (dice in DieInHands) {
            println(dice)
        }
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
    }

    override fun isYahtzee():Boolean {
        if (numbersMap.containsValue(5)){
            return true
        }
        else {
            return false
        }
    }

    override fun isPoker(): Boolean {
        if (numbersMap.containsValue(2) && numbersMap.containsValue(3)){
            return true
        }
        else {
            return false
        }
    }

    override fun isLargeStraight():Boolean{
        if(numbersMap.get("NoOfOnes")==1
            && numbersMap.get("NoOfTwos")==1
            && numbersMap.get("NoOfThrees")==1
            && numbersMap.get("NoOfFours")==1
            && numbersMap.get("NoOfFives")==1){
            return true
        }else if (numbersMap.get("NoOfSixes")==1
            && numbersMap.get("NoOfTwos")==1
            && numbersMap.get("NoOfThrees")==1
            && numbersMap.get("NoOfFours")==1
            && numbersMap.get("NoOfFives")==1){
            return true
        }else{
            return false
        }
    }

    override fun isThreeOfAKind(): Boolean {
        if(numbersMap.containsValue(3)) {
            return true
        }else{
            return false
        }
    }

    override fun isFourOfAKind(): Boolean {
        if(numbersMap.containsValue(4)){
            return true
        }else{
            return false
        }
    }

    override fun checkNumberInHand(){

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
    }

    fun ResaultCheck(){
        checkNumberInHand()
        val resaultYahtzee:Boolean=isYahtzee()
        val resaultStraight:Boolean=isLargeStraight()
        val resaultPoker:Boolean=isPoker()
        val resault4OfAKind:Boolean=isFourOfAKind()
        val resault3OfAKind:Boolean=isThreeOfAKind()

        if (resaultYahtzee){
            //5 istih brojeva
            println("YAHTZEE!!")
        }else if (resaultStraight){
            //skala 1-2-3-4-5 ili 2-3-4-5-6
            println("You got large scale !!!")
        }else if (resaultPoker){
            //2 + 3 iste kockice
            println("Poker!!!")
        }else if (resault4OfAKind){
            //četiri ista broja
            println("You got four of a kind !!!")
        }else if (resault3OfAKind){
            //tri ista broja
            println("You got three of a kind !!!")
        }
        numbersMap.clear()
    }
}


