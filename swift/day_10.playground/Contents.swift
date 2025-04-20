import Cocoa

var greeting = "Hello, playground"

struct Album {
    let title: String
    let artist: String
    let year: Int

    func printSummary() {
        print("\(title) (\(year)) by \(artist)")
    }
}

let red = Album(title: "TPAB", artist: "Kendrick", year: 2015)

print(red.title)
red.printSummary()

struct Employee {
    let name: String
    var vacationRemaining: Int
    
    mutating func takeVacation(days: Int) { //need mutation to change actual data instead of displaying it
        if vacationRemaining > days{
            vacationRemaining -= days
            print("I'm going on vacation!")
            print("Days remaining: \(vacationRemaining)")
        }
        else {
            print("Oops! There aren't enough days remaining")
        }
    }
}

var archer = Employee(name:"Warren", vacationRemaining: 14) //has to be a var if u use mutating function

archer.takeVacation(days: 5)

struct Employee_2 {
    let name: String
    var vacationAllocated = 14
    var vacationTaken = 3
    
    var vacationRemaining: Int {
        get {
            vacationAllocated-vacationTaken
        }
        
        set {
            vacationAllocated = vacationTaken + newValue
        }
    }
}

var archer_2 = Employee_2(name: "Warren", vacationAllocated: 14)

archer_2.vacationTaken += 2
print(archer_2.vacationRemaining,"nig")
print(archer_2.vacationAllocated,archer_2.vacationTaken)
archer_2.vacationRemaining = 6
print(archer_2.vacationAllocated,"nigg", archer_2.vacationTaken)
print(archer_2.vacationRemaining)


struct App {
    var contacts = [String]() {
        willSet {
            print("Current value is: \(contacts)")
            print("New value will be: \(newValue)")
        }

        didSet {
            print("There are now \(contacts.count) contacts.")
            print("Old value was \(oldValue)")
        }
    }
}

var app = App()
app.contacts.append("Adrian E")
app.contacts.append("Allen W")
app.contacts.append("Ish S")

struct Player {
    let name: String
    let number: Int
    init(name: String, number: Int){
        self.name = name
        self.number = number
    }
}
