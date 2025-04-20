//for loops
let platforms = ["ios", "macos", "tvOS", "watchOS"]

for os in platforms {
    print("swift works great on \(os)")
}
for word in ["amazing", "great", "well"]{
    for i in 0...platforms.count-1{
        print("swift works \(word) on \(platforms[i])")
    }
}

for i in 1...12 {
    print("5 x \(i) is \(5 * i)")
}
//while
var countdown = 10

while countdown > 0 {
    print("\(countdown)…")
    countdown -= 1
}

print("Blast off!")

//break and continue

let filenames = ["me.jpg", "work.txt", "sophie.jpg"]

for filename in filenames {
    if !filename.hasSuffix(".jpg"){
        continue
    }
    print("Found image \(filename)")
}
let number1 = 4
let number2 = 14
var multiples = [Int]()

for i in 1...100_000 {
    if i.isMultiple(of: number1) && i.isMultiple(of: number2) {
        multiples.append(i)

        if multiples.count == 10 {
            break
        }
    }
}

print(multiples)

//checkpoint
for num in 1...100{
    var s = ""
    if num.isMultiple(of: 3){
        s += "Fizz"
    }
    if num.isMultiple(of: 5){
        s += "Buzz"
    }
    if s == ""{
        s += String(num)
    }
    print(s)
}
            
