//
//  ContentView.swift
//  Tempurature Converter
//
//  Created by warren su on 4/17/25.
//

import SwiftUI

struct ContentView: View {
    let allUnits = ["Fahrenheit", "Celsius", "Kelvin"]
    @State private var inputUnit = "Fahrenheit"
    @State private var outputUnit = "Celsius"
    @State private var initialValue: Double = 0.0
    var convertedValue: Double {
        if (inputUnit == "Fahrenheit") {
            if outputUnit == "Celsius" {
                return (initialValue*5/9) - 32
                
            }
            else if (inputUnit == "Kelvin"){
                return (5/9 * (initialValue-32)) + 273.15
            }
        
        }
        
        else if (inputUnit == "Celsius") {
            if outputUnit == "Fahrenheit" {
                return (initialValue*9/5) + 32
                
            }
            else if (inputUnit == "Kelvin"){
                return initialValue + 273.15
            }
        
        }
        else {
            if outputUnit == "Fahrenheit" {
                return (initialValue-273.15) * 9/5 + 32
            }
            else if outputUnit == "Celsius" {
                return initialValue - 273.15
            }
        }
        
        return initialValue
        
        
        
    }
    var body: some View {
        NavigationStack{
            Form{
                Section{
                    Picker("What is your input unit?", selection: $inputUnit) {
                        ForEach(allUnits, id: \.self) {
                            Text("\($0)")
                        }
                    }
                }
                
                Section{
                    Picker("What is your output unit?", selection: $outputUnit) {
                        ForEach(allUnits, id: \.self) {
                            Text("\($0)")
                        }
                    }
                }
                
                Section("Enter the tempurate"){
                    TextField("Tempurature", value: $initialValue, format: .number).keyboardType(.decimalPad)
                }
                
                Section("Converted tempurature") {
                    Text("\(initialValue, specifier: "%.2f") degrees \(inputUnit) in \(outputUnit) is \(convertedValue, specifier: "%.2f")")
                }
                
            }.navigationTitle("Tempurature Converter")
            
        }
    }
}

#Preview {
    ContentView()
}
