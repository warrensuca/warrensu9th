
import Cocoa
//functions
func showWelcome() {
    print("Welcome to my app!")
    print("By default This prints out a conversion")
    print("chart from centimeters to inches, but you")
    print("can also set a custom range if you want.")
}

func printTimesTable(number: Int, upper: Int){
    for i in 1...upper{
        print("\(i) * \(number) is \(i*number)")
    }
}
printTimesTable(number: 12, upper: 12)

let root = sqrt(169)

func rollDice() -> Int{
    return Int.random(in:1...6)
}
let num = rollDice()
print(num)
func containsSameLetters(s1: String, s2: String) -> Bool{
    let temp_s1 = s1.sorted()
    let temp_s2 = s2.sorted()
    print(temp_s1,temp_s2)
    return temp_s1 == temp_s2
}
print(containsSameLetters(s1: "123", s2: "321"))

func pythagoras(a: Double, b: Double) -> Double {
    sqrt(a * a + b * b)
}

func getUser() -> (firstName: String, lastName: String) {
    (firstName: "Taylor", lastName: "Swift")
}

let user = getUser()
print("Name: \(user.firstName) \(user.lastName)")
let (firstName, lastName) = getUser()
print("Name: \(firstName) \(lastName)")


//customize parameter labels
func isUppercase(_ string: String) -> Bool {
    string == string.uppercased()
}

let string = "HELLO, WORLD"
let result = isUppercase(string)
