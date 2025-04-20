import Cocoa

var greeting = "Hello, playground"
//assign default value. end: Int = 12
func printTimesTables(for number: Int, end: Int = 12) {
    for i in 1...end {
        print("\(i) x \(number) is \(i * number)")
    }
}

printTimesTables(for: 5, end: 20)
printTimesTables(for: 5) //dont need to specify end


enum PasswordError: Error {
    case short, obvious
}

func checkPassword(_ password: String) throws -> String {
    if password.count < 5 {
        throw PasswordError.short
    }

    if password == "12345" {
        throw PasswordError.obvious
    }

    if password.count < 8 {
        return "OK"
    } else if password.count < 10 {
        return "Good"
    } else {
        return "Excellent"
    }
}
let string = "12345"
do {
    let result = try checkPassword(string)
    print("Password Rating: \(result)")
}
catch PasswordError.short{
    print("Please use a longer password ")
}
catch PasswordError.obvious{
    print("There was an error ")
}

enum sqrtErrors: Error {
    case out
    case noRoot
}

func checkpoint(_ num: Int) throws -> Int{
    if (num < 1 || num > 10000){
        throw sqrtErrors.out
    }
    var ans = 0
    for i in 1...num/2 {
        if i * i == num{
            ans = i
            break
            
        }
    }
    if ans == 0{
        throw sqrtErrors.noRoot
    }
    return ans
}
do {
    let num = try checkpoint(63)
    print(num)
}
catch sqrtErrors.out{
    print("out of bounds")
}

catch sqrtErrors.noRoot{
    print("no roots")
}
