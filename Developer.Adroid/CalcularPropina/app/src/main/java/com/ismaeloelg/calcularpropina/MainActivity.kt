@file:OptIn(ExperimentalMaterial3Api::class)

package com.ismaeloelg.calcularpropina

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ismaeloelg.calcularpropina.ui.theme.CalcularPropinaTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcularPropinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TipTimeLayout() {


    var checkOnInput by remember { mutableStateOf(false) }
    var porcentajeInput by remember { mutableStateOf("") }
    var amountInput by remember { mutableStateOf("") }

    val porcentaje = porcentajeInput.toDoubleOrNull() ?: 0.0
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, porcentaje, checkOnInput)


    Column(
        modifier = Modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = stringResource(R.string.calculo_Prop),
            modifier = Modifier
                .padding(top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = R.string.cuentatf,
            value = amountInput,
            onValueChange = { amountInput = it },
            modifier = Modifier
                .padding((27.dp))
                .fillMaxWidth()
        )
        EditNumberField(
            label = R.string.porcentaje,
            value = porcentajeInput,
            onValueChange = { porcentajeInput = it },
            modifier = Modifier
                .padding((27.dp))
                .fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.cuenta, tip),
            style = MaterialTheme.typography.displaySmall
        )


        roundsTips(roundUp = checkOnInput, onRoundUpChanged = { checkOnInput = it })

        Spacer(modifier = Modifier.height(150.dp))


    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun EditNumberField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier

) {


    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = stringResource(label)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
        ),
        modifier = modifier,
    )
}


@Composable
fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {

    var tip = (amount * tipPercent) / 100;
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
        return NumberFormat.getCurrencyInstance().format(tip)
    } else {
        return NumberFormat.getCurrencyInstance().format(tip)
    }
}

@Composable
fun roundsTips(
    modifier: Modifier = Modifier, roundUp: Boolean, onRoundUpChanged: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "¿Redondeamos hacia arriba?")
        Switch(

            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier.wrapContentWidth(Alignment.End).fillMaxWidth(),
        )
    }

}