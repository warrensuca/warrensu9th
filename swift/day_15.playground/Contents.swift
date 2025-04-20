import Cocoa

var greeting = "Hello, playground"

var name = "Ted"
name = "Rebecca"

let user = "Daphne"
print(user)

print(user.count)
print(user.hasPrefix("Da"))

var number = 120
print(number.isMultiple(of: 3))

let id = Int.random(in: 1...1000)

var colors = [String]()

colors.append("Red")
print(colors[0])

let employee = [
    "name": "Taylor",
    "job": "Singer"
]

print(employee["job"])

enum Weekday {
    case monday, tuesday, wednesday, thursday, friday, saturday, sunday
}

var day = Weekday.monday
day = .friday

switch day {
case .monday:
    print("Start of the week")

case .sunday:
    print("End of the week")

default:
    print("Nothing specail")
}

enum PasswordError: Error{
    case short, obvious
}

func checkPassword(_ password : String) throws -> String {
    if password.count < 5{
        throw PasswordError.short
    }
    
    if password == "12345"{
        throw PasswordError.obvious
    }
    
    if password.count < 10 {
        return "Ok"
        

    }
    else {
        return "Good"
    }
}

do {
    let result = try checkPassword("12345")
    
}
catch PasswordError.obvious {
    print("I have the same combination on my luggage!")
}
catch {
    print("there was an error")
}

let sayHello = { (name: String) -> String in
    "Hello \(name)"
    
}

struct Album {
    let title: String
    var artist: String
    var isReleased = true
    
    func printSummary() {
        print("\(title) by \(artist)")
    }
    
    mutating func changeArtist(_ newArtist: String) {
        var artist = newArtist
    }
    

}
struct Employee {
    let name: String
    var vacationAllocated = 14
    var vacationTaken = 0

    var vacationRemaining: Int {
        get {
            vacationAllocated - vacationTaken
        }
        
        set {
            vacationAllocated = vacationTaken + newValue
        }
    }
}

struct Game {
    var score = 0 {
        didSet {
            print("new score is \(score)")
        }
        willSet {
            print("before score is \(score)")
        }
    }
}

var game = Game()

game.score += 10
game.score -= 3
struct BankAccount {
    private(set) var funds = 0

    mutating func deposit(amount: Int) {
        funds += amount
    }

    mutating func withdraw(amount: Int) -> Bool {
        if funds > amount {
            funds -= amount
            return true
        } else {
            return false
        }
    }
}
var acc = BankAccount()
acc.deposit(amount: 10)
print(acc.funds)


class Employee_2 {
    let hours: Int

    init(hours: Int) {
        self.hours = hours
    }

    func printSummary() {
        print("I work \(hours) hours a day.")
    }
}

class Developer: Employee_2 {
    func work() {
        print("I'm coding for \(hours) hours.")
    }
}

let novall = Developer(hours: 8)
novall.work()
novall.printSummary()


class Vehicle {
    let isElectric: Bool
    init(isElectric: Bool) {
        self.isElectric = isElectric
    }
}


class Car: Vehicle {
    let isConvertible: Bool
    
    init(isElectric: Bool, isConvertible: Bool) {
        self.isConvertible = isConvertible
        super.init(isElectric: isElectric)
    }
}


class Actor {
    var name = "Nicolas Cage"
}

var actor1 = Actor()
var actor2 = actor1

actor2.name = "Tom Cruise"
print(actor1.name)
print(actor2.name)

protocol vehicleProt {
    func estimateTime(for distance: Int) -> Int
    func travel(distance: Int)
}


struct Car_2: vehicleProt{
    func estimateTime(for distance: Int) -> Int {
        distance / 50
    }
    func travel(distance: Int){
        print("I'm driving \(distance)km")

    }
    
    func openSunroof() {
        print("It's a nice day")
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

var quote = "    Hi Hi Hi Hi lkjf "

quote.trim()
print(quote)

let opposites = [
    "Mario": "Wario",
    "Luigi": "Waluigi"
]

if let marioOpposite = opposites["Mario"] {
    print("Mario's opposite is \(marioOpposite)")
}

func printSquare(number: Int?) {
    guard let number = number else {
        print("Missing input")
        return
    }
    print("\(number) squared is \(number * number)")
}

let tvShows = ["archer", "naruto", "peak"]

let favorite = tvShows.randomElement() ?? "None"

let input = ""
number = Int(input) ?? 0

print(number)

let names: [String?] = ["Arya", "Bran", "Robb", "Sansa", nil]

let chosen = names.randomElement()??.uppercased()
print("Next in line: \(chosen ?? "No one")")

enum UserError: Error {
    case badID, networkFailed
}

func getUser(id: Int) throws -> String {
    throw UserError.networkFailed
}

if let user = try? getUser(id: 23) {
    print("User: \(user)")
}
