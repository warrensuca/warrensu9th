//type annotations
let surname = "Lasso" //infers surname is a string
var score = 0 //infers score is an int

let surname_2: String = "Lasso"
let score_2: Double = 0 //without Double, swift would infer it is an int

var albums: [String] = ["Red", "Fearless"]
var user: [String: String] = ["id": "easymoneysniper"]
var books: Set<String> = Set(["Percy Jackson 1", "Percy Jackson 2"])

//most commomly used with constants without preassigned value
let username: String

username = "the_king"

//checkpoint 2

var arr: [String] = ["Hello", "Greetings", "How are you", "Hello"]
print(arr.count)
print(Set(arr).count)
