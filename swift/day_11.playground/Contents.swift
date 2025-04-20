import Cocoa

var greeting = "Hello, playground"
struct School {
    static let studentCount = 0 //belongs to type not an instance
    
    static func add(student:String) {
        print("\(student) joined the school")

    }
}

School.add(student: "Warren Su")
print(School.studentCount)



struct Car {
    let model: String
    let seat_num: Int
    var curr_gear: Int {
        willSet {
            print("Changing gear from \(curr_gear) to \(newValue)")
        }
        
        didSet{
            print("Current gear is now \(curr_gear)")
        }
    }
    
    
    mutating func changeGears(direction: String) {
        if curr_gear == 10 || curr_gear == 1 {
            return
        }
        if direction.lowercased() == "up"{
            curr_gear += 1
        }
        else if direction.lowercased() == "down" {
            curr_gear -= 1
        }
        
    }
}

var car = Car(model: "Model Z", seat_num: 4, curr_gear: 5)
print(car)
car.changeGears(direction: "up")
