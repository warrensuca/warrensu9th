import UIKit
import Cocoa

var greeting = "Hello, playground"


var name = "Ted"

name = "Rebecca"
name = "Keeley" //name can change, and you don't have to keep saying var

let character = "Daphne" //let is a constant. it cannot change


print(name)
print(character)

//strings
let actor = "Denzel Washington"
let goat = "Lebron"
let clipfarm = "Lebron \"James\" boom boom boom boom"
let linebreak = """
Hello, I'm Lebron
I'm Goated
"""
//string methods

print(actor.count)
print(clipfarm.uppercased())

print(clipfarm.hasPrefix("Lebron"))


//store whole numbers

let score = 10
let reallyBig = 100_000_000
let lowerScore = reallyBig-score
let higherScore = reallyBig+score

var count = 10
count += 5

print(count)

count *= 2
count /= 2
print(count)

//built in functions

let number = 120

print(number.isMultiple(of: 3))

//store decimal

let flo = 0.1+0.2
print(flo)

let a = 1
let b = 2.0
let c = Double(a) + b

let double1 = 3.1
let double2 = 3131.3131
let double3 = 3.0

let int1 = 3

