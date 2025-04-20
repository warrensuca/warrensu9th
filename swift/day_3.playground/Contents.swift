import UIKit

var hokage = ["Hashirma", "Tobirama", "Hiruzen", "Minato"]
hokage.append("Tsunade")
hokage.append("Kakashi")
hokage.append("Naruto")
print(hokage)

//hokage.append(25)
//arrays can only store one type of value
var scores = [Int]() //initialize like this
var temp = Array<String>()

print(hokage.count)
print(hokage.contains("shikimaru"), hokage.contains("Naruto"))




hokage.reverse()
print(hokage)
hokage.sort()
print(hokage)

hokage.removeAll()
print(hokage.count)
//dictionaries

let employee = [
    "name": "Taylor Swift",
    "job": "Singer",
    "location": "Nashville"
]

print(employee["name"]) //optional

print(employee["name", default: "Unknown"]) //always get a string back. if it does not exist, return a default value

var heights = [String: Int]()

heights["Yao Ming"] = 229
heights["Lebron James"] = 206
print(heights)
//sets
var actors = Set(["Denzel Washington", "Tom Cruise", "Nicolas Cage", "Samuel L Jackson"])
actors.insert("Micheal B. Jordan")

var players = Set<String>()
players.insert("Lebron")
players.insert("Lebron")

print(players)

//enums
enum Weekday {
    case monday, tuesday, wednesday, thursday, friday
}

var day = Weekday.monday
day = .tuesday
day = .friday
print(day)
