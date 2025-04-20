import Cocoa

var greeting = "Hello, playground"


protocol Vehicle {
    var name: String { get }
    var currentPassengers: Int { get set }
    func estimateTime(for distance: Int) -> Int
    func travel(distance: Int)
}
struct Car: Vehicle {
    let name = "Car"
    var currentPassengers = 1
    func estimateTime(for distance: Int) -> Int {
        distance / 50
    }

    func travel(distance: Int) {
        print("I'm driving \(distance)km.")
    }

    func openSunroof() {
        print("It's a nice day!")
    }
}

func commute(distance: Int, using vehicle: Car) {
    if vehicle.estimateTime(for: distance) > 100 {
        print("That's too slow! I'll try a different vehicle.")
    } else {
        vehicle.travel(distance: distance)
    }
}

func getTravelEstimates(using vehicles: [Vehicle], distance: Int) {
    for vehicle in vehicles {
        let estimate = vehicle.estimateTime(for: distance)
        print("Estimated time for \(vehicle.name): \(estimate) hours")
    }
}
let car = Car()

commute(distance: 100, using: car)
commute(distance: 200, using: car)

getTravelEstimates(using: [car,car], distance: 100)

func getRandomNumber() -> some Equatable {
    Int.random(in: 1...6)
}

func getRandomBool() -> some Equatable {
    Bool.random()
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
var quote = "   The truth is rarely pure and never simple   "
let trimmed = quote.trimmed()
let lyrics = """
But I keep cruising
Can't stop, won't stop moving
It's like I got this music in my mind
Saying it's gonna be alright
"""

print(lyrics.lines.count)

struct Book {
    let title: String
    let pageCount: Int
    let readingHours: Int
    

    
}

extension Book {
    init(title: String, pageCount: Int) {
        self.title = title
        self.pageCount = pageCount
        self.readingHours = pageCount/50
    }
    
    
}

extension Array {
    var isNotEmpty: Bool {
        isEmpty == false
    }
}

let guests = ["Mario", "Luigi", "Peach"]
if guests.isNotEmpty {
    print("Guest count: \(guests.count)")
}

protocol Person {
    var name: String {get}
    
    func sayHello()
}

extension Person {
    func sayHello() {
        print("Hi, I'm \(name)")
    }
}

struct Employee: Person {
    let name: String
}

let taylor = Employee(name: "Kanye West")
taylor.sayHello()
//checkpoint 8

protocol Building {
    var rooms: Int {get}
    var cost: Int {get}
    var name: String {get}
    
    func summary()
}

struct House: Building {
    var rooms: Int
    var cost: Int
    var name: String
    
    func summary(){
        print("The agent's name is \(name), he offers \(rooms) rooms for $\(cost) ")
    }
}

let newHouse = House(rooms: 3, cost: 1_000_000, name: "Nig")
newHouse.summary()
