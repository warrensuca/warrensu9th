//
//  ContentView.swift
//  WeSplit
//
//  Created by warren su on 4/16/25.
//

import SwiftUI

struct Starter: View {
    let students = ["Harry", "Hermione", "Ron"]
    @State var tapCount = 0
    @State private var name = ""
    @State private var selectedStudent = "Harry"
    var body: some View {
        NavigationStack{
            Form {
                Picker("Select your student", selection: $selectedStudent){
                    ForEach(students, id: \.self) {
                        Text($0)}
                }
            }
            Form {
                Text("Hello World")
                
                Section{
                    Text("Hello World")
                    Text("Hello World")
                    Text("Hello World")
                    
                
                }
                Button("Tap Count: \(tapCount)") {
                    tapCount += 1
                    
                    
                }
                TextField("Enter your name", text: $name)
                Text("Your name is \(name)")
            }
            .navigationTitle("SwiftUI")
            
            
        }
        
        
        
        
    
        

        
        
    }
}

#Preview {
    Starter()
}
