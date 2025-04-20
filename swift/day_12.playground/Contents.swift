import Cocoa

var greeting = "Hello, playground"
class Game {
    var score = 0 {
        
        didSet {
            print("Score is now \(score)")
        }
    }
}

var newGame = Game()
newGame.score += 10
class Employee {
    let hours: Int
    init(hours: Int) {
        self.hours = hours
    }
    
    func printSummary(){
        print("I work \(hours) hours a day. ")
    }
}

class Developer: Employee {
    func work() {
        print("I'm writing code for \(hours) hours.")
    }
    override func printSummary() {
        print("I'm a developer who will sometimes work \(hours) hours a day, but other times spend hours arguing about whether code should be indented using tabs or spaces.")
    }
}

class Manager: Employee {
    func work() {
        print("I'm going to meetings for \(hours) hours.")
    }
}

let robert = Developer(hours: 8)
let joseph = Manager(hours: 10)
robert.work()
joseph.work()
joseph.printSummary()

class Vehicle {
    var isElectric: Bool

    init(isElectric: Bool) {
        self.isElectric = isElectric
    }
}

class Car: Vehicle {
    var isConvertible: Bool
    
    init(isConvertible: Bool, hasBatteries: Bool){
        self.isConvertible = isConvertible
        super.init(isElectric: hasBatteries)
    }
}

var teslaX = Car(isConvertible: false, hasBatteries: true)

print(teslaX.isElectric)

var car2 = teslaX
car2.isElectric = false
print(teslaX.isElectric)
print(car2.isElectric)

//deinitializer

class User {
    let id: Int

    init(id: Int) {
        self.id = id
        print("User \(id): I'm alive!")
    }

    deinit {
        print("User \(id): I'm dead!")
    }
}
var users = [User]()
for i in 1...3 {
    let user = User(id: i)
    print("User \(user.id): I'm in control!")
    users.append(user)
}

print("Loop is finished")
users.removeAll()
print("Array is clear!")
//checkpoint 7

class Animal{
    let legs: Int;
    init(legs: Int) {
        self.legs = legs
    }
}

class Dog: Animal {

    
    func speak() {
        print("Bark")
    }
}
                
class Corgi: Dog{
    
    override func speak() {
        print("Woof")
    }
}

class Cat: Animal {
    var isTame: Bool
    init(legs: Int, isTame: Bool){
        self.isTame = isTame
        super.init(legs: legs )
        
    }
    func speak(){
        print("Meow")
    }
    
}
class Persian: Cat {
    override func speak(){
        print("Hey")
    }
}

class Lion: Cat{
    override func speak(){
        print("Roar")
    }
}
