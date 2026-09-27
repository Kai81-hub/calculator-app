package com.CalculatorApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.CalculatorApp.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                CalculatorScreen()
            }
        }
    }
}

@Composable
fun CalculatorScreen() {

    var waitingForSecondNumber by remember {
        mutableStateOf(false)
    }

    var display by remember {
        mutableStateOf("0")
    }
    var firstNumber by remember {
        mutableStateOf<Double?>(null)
    }

    var operator by remember {
        mutableStateOf<String?>(null)
    }

    fun numberClicked(number: String) {
        if (waitingForSecondNumber) {
            display = number
            waitingForSecondNumber = false
        } else if (display == "0") {
            display = number
        } else {
            display = display + number
        }
    }

    fun decimalClicked() {
        if (waitingForSecondNumber) {
            display = "0."
            waitingForSecondNumber = false
        } else if (!display.contains(".")) {
            display = "$display."
        }
    }

    fun backspaceClicked() {
        if (display.length > 1) {
            display = display.dropLast(1)
        } else {
            display = "0"
        }
    }

    fun operatorClicked(selectedOperator: String) {
        firstNumber = display.toDoubleOrNull()
        operator = selectedOperator
        waitingForSecondNumber = true
    }

    fun calculate() {
        // Capture into local vals so Kotlin can smart-cast them below
        // (removes the need for !! and clears the "unnecessary assertion" warnings)
        val fn = firstNumber
        val sn = display.toDoubleOrNull()
        val op = operator

        if (fn != null && sn != null && op != null) {

            val result: Double? = when (op) {
                "+" -> fn + sn
                "-" -> fn - sn
                "×" -> fn * sn
                "÷" -> if (sn != 0.0) fn / sn else null
                else -> null
            }

            display = if (result == null) {
                "Error"
            } else if (result == result.toLong().toDouble()) {
                // Drop trailing ".0" for whole numbers, e.g. 98.0 -> 98
                result.toLong().toString()
            } else {
                result.toString()
            }

            firstNumber = null
            operator = null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = display,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { display = "0" },
                modifier = Modifier.weight(1f)
            ) {
                Text("C")
            }

            Button(
                onClick = { backspaceClicked() },
                modifier = Modifier.weight(1f)
            ) {
                Text("⌫")
            }

            Button(
                onClick = { operatorClicked("÷") },
                modifier = Modifier.weight(1f)
            ) {
                Text("÷")
            }

            Button(
                onClick = { operatorClicked("×") },
                modifier = Modifier.weight(1f)
            ) {
                Text("×")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { numberClicked("7") },
                modifier = Modifier.weight(1f)
            ) {
                Text("7")
            }

            Button(
                onClick = { numberClicked("8") },
                modifier = Modifier.weight(1f)
            ) {
                Text("8")
            }

            Button(
                onClick = { numberClicked("9") },
                modifier = Modifier.weight(1f)
            ) {
                Text("9")
            }

            Button(
                onClick = { operatorClicked("-") },
                modifier = Modifier.weight(1f)
            ) {
                Text("-")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { numberClicked("4") },
                modifier = Modifier.weight(1f)
            ) {
                Text("4")
            }

            Button(
                onClick = { numberClicked("5") },
                modifier = Modifier.weight(1f)
            ) {
                Text("5")
            }

            Button(
                onClick = { numberClicked("6") },
                modifier = Modifier.weight(1f)
            ) {
                Text("6")
            }

            Button(
                onClick = { operatorClicked("+") },
                modifier = Modifier.weight(1f)
            ) {
                Text("+")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { numberClicked("1") },
                modifier = Modifier.weight(1f)
            ) {
                Text("1")
            }

            Button(
                onClick = { numberClicked("2") },
                modifier = Modifier.weight(1f)
            ) {
                Text("2")
            }

            Button(
                onClick = { numberClicked("3") },
                modifier = Modifier.weight(1f)
            ) {
                Text("3")
            }

            Button(
                onClick = { calculate() },
                modifier = Modifier.weight(1f)
            ) {
                Text("=")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { numberClicked("0") },
                modifier = Modifier.weight(1f)
            ) {
                Text("0")
            }

            Button(
                onClick = { decimalClicked() },
                modifier = Modifier.weight(1f)
            ) {
                Text(".")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    MyApplicationTheme {
        CalculatorScreen()
    }
}