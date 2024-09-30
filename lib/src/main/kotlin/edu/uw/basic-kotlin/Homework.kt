package edu.uw.basickotlin

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when(arg) {
        "Hello" -> return "world"
        "Howdy", "Bonjour" -> return "Say what?"
        is String -> return "I don't understand"
        0 -> return "zero"
        1 -> return "one"
        in 2..10 -> return "low number"
        is Int -> return "a number"
    }
    return "I don't understand"
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(lhs: Int, rhs: Int) = lhs + rhs

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(lhs: Int, rhs: Int) = lhs - rhs

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(lhs: Int, rhs: Int, op: (Int, Int) -> Int): Int {
    return op(lhs, rhs)
}

// write a class "Person" with first name, last name and age
class Person (val firstName : String, val lastName : String, val age : Int, val debugString : String = "[Person firstName:$firstName lastName:$lastName age:$age]"){}

// write a class "Money"

class Money(val amount: Int, val currency: String) {
    init {
        if(amount < 0) {
            throw IllegalArgumentException("amount was less than zero...")
        }
        if(currency != "USD" && currency != "EUR" && currency != "CAN" && currency != "GBP") {
            throw IllegalArgumentException("illegal currency...")
        }
    }
    fun convert(currency: String): Money {
        var usdConver = 0
        when(this.currency) {
            "USD" -> usdConver = this.amount
            "EUR" -> usdConver = (this.amount / 1.5).toInt()
            "CAN" -> usdConver = (this.amount * 0.8).toInt()
            "GBP" -> usdConver = this.amount * 2
        }
        if(currency == "USD") {
            return Money(usdConver, currency)
        } else if(currency == "EUR") {
            return Money((usdConver * 1.5).toInt(), currency)
        } else if (currency == "CAN") {
            return Money((usdConver / 0.8).toInt(), currency)
        } else {
            return Money(usdConver / 2, currency)
        }
    }
    operator fun plus(other: Money): Money {
        val convertedOther = other.convert(this.currency)
        return Money(this.amount + convertedOther.amount, this.currency)
    }
}