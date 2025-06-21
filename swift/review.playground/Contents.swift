import UIKit

var greeting = "Hello, playground"

var name = "Ted"

let actor = "Tom Cruise"


print("The actor in mission impossible is \(actor)")

print(actor.count)

var counter = 10
counter+=5

let rInt = Int.random(in: 1...1000)

print(rInt)

var colors = ["red", "green", "blue"]

var numbers = [4,8,15,16]


//type annotation, can make empty array
var doubles: [Double] = []
doubles.append(2.3)

var employee: [String:Bool] = [:]
employee["actor"] = true


var behavior: String

behavior = "terrible"

//conditionals

let age = 16

if age < 12 {
    print("you can not vote")
}

else if age < 18 {
    print("you are close to voting")
}

else {
    print("you can vote")
}

if age >= 16 && age < 21 {
    print("you can drive but not drink")
}

if age >= 16 || age > 21 {
    print("you have a bit of freedom")
}

enum Weather {
    case sun, rain, wind
}

let forecast = Weather.sun

switch forecast {
case .sun:
    print("A nice day.")
case .rain:
    print("A rainy day")
default:
    print("Should be okay")
}


let canVote = age >= 18 ? "yes":"no"

let platforms = ["IOS", "MacOS", "tvOS"]

for i in 0..<platforms.count {
    print("Swift works on \(platforms[i])")
}

func printTimesTable(number: Int) {
    for i in 1...12 {
        print(i*number)
    }
}

func Multiplcation(num1: Int, num2: Int) -> Int{
    return num1*num2
}

func getUser() -> (firstName: String, lastName: String) {
    (firstName: "Taylor", lastName: "Swift")
}

let (firstName, _) = getUser()
print("Name:  \(firstName)")

func Greeting(_ language: String) -> String{
    if language.lowercased() == "chinese" {
        return "Ni Hao"
    }
    
    else if language.lowercased() == "spanish" {
        return "Hola"
    }
    else {
        return "Hello"
    }
}
let hi = Greeting("Spanish")
print(hi)


enum PasswordError: Error {
    case short, obvious
}

func checkPasswod(_ password: String ) throws -> String {
    if password.count < 5 {
        throw PasswordError.short
    }
    if password == "12345"{
        throw PasswordError.obvious
    }
    else{
        return "Good"
    }
}

do {
    let result = try checkPasswod("12345")
    print("Rating: \(result)")
} catch PasswordError.obvious {
    print("too obvious little boy")
} catch {
    print("There was an error")
}

//closure

let sayHello = { (myself: String, otherPerson: String) -> String in
    "Hi there \(otherPerson) I am \(myself)"
}
sayHello("warren", "su")

let team = ["Gloria", "Suzanne", "Tiffany", "Tasha"]

let onlyT = team.filter({$0.hasPrefix("T")})

struct Album {
    let title: String
    let artist: String
    var isReleased = true
    
    
     
    func printSummary() {
        print("Album by \(artist) called \(title)")
    }
}
let red = Album(title: "Red", artist: "Taylor Swift")
print(red.title)
red.printSummary()

struct Employee {
    let name: String
    var vacationAllowed = 14
    var vacationTaken: Int
    var vacationRemaning: Int {
        get {
            vacationAllowed-vacationTaken
        }
        set {
            vacationAllowed = vacationTaken + newValue
        }
    }
}

var bob = Employee(name: "bob", vacationAllowed: 21, vacationTaken: 7)

print(bob.vacationRemaning)

bob.vacationRemaning = 43

print(bob.vacationAllowed)

print(bob.vacationRemaning)

struct Player {
    let name: String
    let number: Int
    
    init(name: String) {
        self.name = name
        number = Int.random(in: 1...99)
    }
}

class cAlbum {
    let title: String
    let artist: String
    var isReleased = true
    let year: Int
    let month: String
    let day:Int
    init(title: String, artist: String, isReleased: Bool, year: Int, month: String, day:Int) {
        self.title = title
        self.artist = artist
        self.isReleased = isReleased
        self.year = year
        self.month = month
        self.day = day
    }
     
    func printSummary() {
        print("Album by \(artist) called \(title)")
    }
    
    func getReleaseDate() {
        print("Released on \(month) \(day), \(year)")
    }
}

class Song : cAlbum{
    
    
    override func printSummary() {
        print("Song by \(artist) called \(title)")
    }
}

var album = cAlbum(title:"WLR", artist:"Carti", isReleased: true, year: 2025, month:"December", day:25)

album.printSummary()
album.getReleaseDate()
var vampAnthem = Song(title:"Vamp Anthem", artist:"Carti", isReleased: true, year: 2025, month:"December", day:25)

vampAnthem.printSummary()
vampAnthem.getReleaseDate()

protocol Vehicle {
    func estimateTime(distance: Int) -> Int
    func Travel(distance: Int)
}

struct Car: Vehicle{
    func estimateTime(distance: Int) -> Int {
        distance / 50
    }
    func Travel(distance: Int) {
        print("I'm driving \(distance)km")
    }
}


func commute(distance: Int, vehicle: Vehicle) {
    if vehicle.estimateTime(distance: distance) > 100 {
        print("Too slow")
    }
    else {
        vehicle.Travel(distance: distance)
    }
}

extension String {
    func trimmed() -> String {
        self.trimmingCharacters(in: .whitespacesAndNewlines)
    }
    mutating func trim() {
        self = self.trimmed()
    }
    
    var lines: [String] {
        self.components(separatedBy: .newlines)
    }
}

var quote = "  The truth is rarely pure and never simple"
print(quote)
quote.trim()
print(quote)

extension String {
    func isEmpty() -> Bool {
        self.count == 0
    }
}
print(quote.isEmpty)
var emptyString = ""
print(emptyString.isEmpty)

func printSquare(of number: Int?) {
    guard let number = number else {
        print("Missing input")
        return
    }
    
    print("\(number) * \(number) is \(number*number)")
}

printSquare(of: nil)
printSquare(of: 32)

var input = ""

let number = Int(input) ?? 0
print(number)

let names = ["Arya", "Bran", "Robb", "Sansa"]
let chosen = names.randomElement()?.uppercased()

print("next in line: \(chosen ?? "No one")")
