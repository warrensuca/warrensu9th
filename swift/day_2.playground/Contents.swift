import UIKit


//booleans
let goodDogs = true

var gameOver = false
print(gameOver)
gameOver = !gameOver //not

print(gameOver)

//how to join strings
//+ and string interpolation

var firstPart = "Hello, "

let secondPart = "world!"
let greeting = firstPart + secondPart

print(greeting)
firstPart += "world!"
print(firstPart)
//more efficent

let name = "Taylor"
let age = 26

let message = "Hello, my name is \(name) and I'm \(age) years old."
//notice how age isn't an int

print(message)
//celsius to fahrenheit

let celsius = 32.0

print("\(celsius) celsius is \(celsius*9/5 + 32) fahrenheit")
