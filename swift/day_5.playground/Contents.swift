import UIKit

var greeting = "Hello, playground"
//if statements

var score = 85

if score > 80 {
    print("Great Job!")
}
let speed = 88
let percentage = 85
let age = 18

if speed >= 88 {
    print("Where we're going, we don't need roads")
}

if percentage < 85 {
    print("Sorry, you failed the test.")
}

if age >= 18 {
    print("You're eligible to vote")
}

let ourName = "Dave Listner"
let friendName = "Arnold Rimmer"

if ourName < friendName {
    print("It's \(ourName) vs \(friendName)")
}

if ourName > friendName {
    print("It's \(friendName) vs \(ourName)")
}


var numbers = [1,2,3]
numbers.append(4)
if numbers.count > 3 {
    numbers.remove(at: 0)
}

print(numbers)

//else if and else
let temp = 25

if temp > 30{
    print("It's a hot day today")
}
else if temp < 15 {
    print("It's a nice day today")
}

else {
    print("It's cold today")
}
//or operator
let userAge = 17
let parentsPermission = true

if age >= 18 || parentsPermission{
    print("You can buy the game")
}

//and operator
let smart = true
let hardworking = false

if smart && hardworking {
    print("You are destined for greatness")
}
//mixture of enum and if. all of the cases are elif. if it reaches one statement, then it will immediatly break
enum Weather {
    case sun, rain, wind, snow, unknown
}

let forecast = Weather.sun
switch forecast {
case .sun:
    print("It should be a nice day.")
case .rain:
    print("Pack an umbrella")
case .wind:
    print("Wear something warm")
case .snow:
    print("School is cancelled")
case .unknown:
    print("Our forecast generator is broken")
}

//how to make a switch all if statements?
let day = 5
print("My true love gave to me...")

switch day {
case 5:
    print("5 golden rings")
    fallthrough
case 4:
    print("4 calling birds")
    fallthrough
case 3:
    print("3 French hens")
    fallthrough
case 2:
    print("2 turtle doves")
    fallthrough
default:
    print("A partridge in a pear tree")
}

//ternary operator
let curr_age = 18
let canVote = curr_age >= 18 ? "Yes" : "No" //condensed if else statement
print(canVote)

let hour = 23
print(hour < 12 ? "It's before noon" : "It's after noon")
