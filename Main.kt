package machine

fun main() {
    fun make() = println("""Starting to make a coffee
Grinding coffee beans
Boiling water
Mixing boiled water with crushed coffee beans
Pouring coffee into the cup
Pouring some milk into the cup
Coffee is ready!""")
    fun ingredients(cups:Int){
        println("""For $cups of coffee you will need:
            |${cups*200} ml of water
            |${cups*50} ml of milk
            |${cups*15} g of coffee beans
        """.trimMargin())
    }
    //println("Write how many cups of coffee you will need:")
    //ingredients(readln().toInt())

    fun cupsavaliable() {
        println("Write how many ml of water the coffee machine has:")
        val water = readln().toInt()
        println("Write how many ml of milk the coffee machine has:")
        val milk = readln().toInt()
        println("Write how many grams of coffee beans the coffee machine has:")
        val coffee = readln().toInt()
        println("Write how many cups of coffee you will need:")
        val wantcups = readln().toInt()
        val a = arrayOf(water / 200, milk / 50, coffee / 15)
        a.sort()
        if (wantcups == a.first()) println("Yes, I can make that amount of coffee")
        else if (wantcups<a.first()) println("Yes, I can make that amount of coffee (and even ${a.first()-wantcups} more than that)")
        else if (wantcups>a.first()) println("No, I can make only ${a.first()} cups of coffee")

    }
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9
    var money = 550


    fun currentFill(){
        println("""The coffee machine has:
$water ml of water
$milk ml of milk
$coffee g of coffee beans
$cups disposable cups
$$money of money""")
    }


    fun writeAction():String{
        println("Write action (buy, fill, take):")
        return readln()
    }




    var needwater = 0
    var needcoffee = 0
    var needmilk = 0
    var earnmoney = 0

    fun buyCoffee(){
        if (water-needwater>=0 && coffee-needcoffee>=0 && milk-needmilk>=0 && cups>1) {
            println("I have enough resources, making you a coffee!")
            water-=needwater
            coffee-=needcoffee
            milk-=needmilk
            cups-=1
            money+=earnmoney

        }
        else if (water<needwater) println("Sorry, not enough water")
        else if (milk<needmilk) println("Sorry, not enough milk")
        else if (coffee<needcoffee) println("Sorry, not enough coffee beans")
        else if (cups==0) println("Sorry, not enough disposable cups")
    }



    fun buy(){
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when(readln()){
            "1"-> {
                needwater=250
                needcoffee=16
                earnmoney=4
                needmilk = 0
                buyCoffee()
            }
            "2"->{
                needwater=350
                needcoffee=20
                needmilk=75
                earnmoney=7
                buyCoffee()
            }
            "3"->{
                needwater=200
                needcoffee=12
                needmilk=100
                earnmoney=6
                buyCoffee()

            }
            "back" -> {
            }

        }

    }

    fun fill(){
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }


    fun take(){
        println("I gave you $$money")
        money = 0
    }

    fun chooseAction(write:String){
        when (write){
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining"-> currentFill()
            else -> println("Invalid input")
        }
    }



    println("Write action (buy, fill, take, remaining, exit):")
    var move = readln()
    while(true){
        if (move == "exit") break
        else chooseAction(move)
        println("Write action (buy, fill, take, remaining, exit):")
        move = readln()
    }



}
