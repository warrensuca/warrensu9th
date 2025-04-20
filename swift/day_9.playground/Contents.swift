import Cocoa

var greeting = "Hello, playground"
//closures
let sayHello = {
    print("Hello there!")
}

func hey() {
    print("Hello there!")
}

print(hey())

let sayHello_2 = {(name: String) -> String in
    "Hello! + \(name)"
}
var team = ["Gloria", "Suzanne", "Piper", "Tiffany"]
let captainFirstTeam = team.sorted {a,b in
    if a == "Suzanne" {
        return true
    } else if b == "Suzanne" {
        return false
    }

    return a < b
}

let betterCaptainFirstTeam = team.sorted {$0 == "Suzanne" && $1 != "Suzanne"}
let uppercaseTeam = team.map { $0.uppercased() }

print(uppercaseTeam)
//pass function in as parameters

func makeArray(size: Int, using generator: () -> Int) -> [Int] {
    var numbers = [Int]()

    for _ in 0..<size {
        let newNumber = generator()
        numbers.append(newNumber)
    }

    return numbers
}
let rolls = makeArray(size:50) {
    Int.random(in: 1...20)
}
func doImportantWork(first: () -> Void, second: () -> Void, third: () -> Void) {
    print("About to start first work")
    first()
    print("About to start second work")
    second()
    print("About to start third work")
    third()
    print("Done!")
}

doImportantWork {
    print("This is the first work")
} second: {
    print("This is the second work")
} third: {
    print("This is the third work")
}



//checkpoint 5

let luckyNumbers = [7,4,38,21,16,15,12,33,31,49]

let filterEvens = luckyNumbers.filter{$0 % 2 == 0}

let sort_asc = filterEvens.sorted{$0 < $1}

let format = sort_asc.map{"\($0) is a lucky number"}


for i in 0...format.count-1 {
    print(format[i])
}

