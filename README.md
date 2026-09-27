# 🧮 Calculator App

A simple Android Calculator application built using **Kotlin** and **Jetpack Compose**.

This is one of my beginner Android development projects. I built the calculator UI and functionality in a single Kotlin file to understand how Kotlin, Jetpack Compose, state management, button clicks, and basic calculation logic work together.

## 📱 Features

* Addition `+`
* Subtraction `-`
* Multiplication `×`
* Division `÷`
* Decimal numbers `.`
* Clear `C`
* Backspace `⌫`
* Number buttons `0–9`
* Displays calculation results
* Handles division by zero with an `Error` message
* Removes unnecessary `.0` from whole-number results

## 🛠️ Technologies Used

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Material 3**
* **Android SDK**

## 📂 Project Structure

The main calculator implementation is written in:

```text
app/
└── src/
    └── main/
        └── java/
            └── com/
                └── CalculatorApp/
                    └── MainActivity.kt
```

The calculator functionality is currently implemented in a **single Kotlin file: `MainActivity.kt`**.

## ⚙️ How It Works

The application uses Jetpack Compose state to keep track of the calculator.

The main states are:

```kotlin
display
firstNumber
operator
waitingForSecondNumber
```

### Number Input

When a number button is clicked, the number is added to the display.

For example:

```text
2 → 25
```

### Selecting an Operator

When an operator is selected, the first number and operator are stored.

Example:

```text
25 + 
```

The calculator then waits for the second number.

### Calculation

When `=` is pressed, the calculator performs the selected operation.

Example:

```text
25 + 10 = 35
```

Another example:

```text
20 × 5 = 100
```

### Division by Zero

The calculator prevents division by zero:

```text
10 ÷ 0 = Error
```

## 🎯 Learning Goals

This project was created to practice:

* Kotlin basics
* Kotlin functions
* Variables and state
* Nullable types
* `when` expressions
* Jetpack Compose
* `@Composable` functions
* `remember`
* `mutableStateOf`
* Button click events
* Layouts using `Column` and `Row`
* Basic calculator logic

## 🚀 Future Improvements

Possible improvements for future versions:

* Dark calculator UI
* Better button styling
* Calculation history
* Percentage `%`
* Plus/minus `±`
* More advanced mathematical operations
* Landscape layout
* Improved error handling
* Separate UI and calculator logic
* Multiple Kotlin files for better project organization

## 📸 Project

This project was built as part of my Android development learning journey using Kotlin and Jetpack Compose.

---

**Built with Kotlin 💙 and Jetpack Compose**

