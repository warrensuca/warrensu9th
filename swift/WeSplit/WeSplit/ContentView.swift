//
//  ContentView.swift
//  WeSplit
//
//  Created by warren su on 4/16/25.
//

import SwiftUI

struct ContentView: View {
    @State private var checkAmount = 0.0
    @State private var numberOfPeople = 1
    @State private var tipPercentage = 20
    @FocusState private var amountIsFocused: Bool
    var totalAmount: Double {
        let tipSelection = Double(tipPercentage)
        return (checkAmount + checkAmount * (tipSelection/100))
    }
    
    var finalAmount: Double {
        let peopleCount = Double(numberOfPeople+1)
        let tipSelection = Double(tipPercentage)
        
        return (checkAmount + checkAmount * (tipSelection/100)) / peopleCount
    }
    let tipPercentages = [0, 10, 15, 20, 25]

    
    
    var body: some View {
        NavigationStack{
            Form {
                Section {
                    TextField("Amount", value: $checkAmount, format: .currency(code: Locale.current.currency?.identifier ?? "USD"))
                        .keyboardType(.decimalPad)
                        .focused($amountIsFocused)
                    
                    Picker("Number of people", selection: $numberOfPeople) {
                        ForEach(1..<100) {
                            Text("\($0) people")
                        }
                    }.pickerStyle(.navigationLink)
                }
                
                Section("How much do you want to tip?") {
                    Picker("Tip percentage", selection: $tipPercentage) {
                        ForEach(tipPercentages, id: \.self) {
                            Text("\($0)%")
                        }
                    }.pickerStyle(.segmented)
                    Picker("More percentages", selection: $tipPercentage){
                        ForEach(0..<101){
                            Text("\($0)%")
                        }
                    }.pickerStyle(.navigationLink)
                    
                }
                
                Section("Total Amount") {
                    Text(totalAmount, format: .currency(code: Locale.current.currency?.identifier ?? "USD"))
                }
                Section("Amount per person"){


                    Text(finalAmount, format: .currency(code: Locale.current.currency?.identifier ?? "USD"))
                }
            }.navigationTitle("WeSplit: Tip Calculator")
                .toolbar {
                    if amountIsFocused {
                        Button("Done") {
                            amountIsFocused = !amountIsFocused
                        }
                    }
                }
            
            
        }
    }
}

        

        
        

#Preview {
    ContentView()
}
