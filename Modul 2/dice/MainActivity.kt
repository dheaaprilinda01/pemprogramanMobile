package com.example.dice

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dice.ui.theme.DiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceTheme {
                DiceRollerApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DiceRollerApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Dice Rolls")
                }
            )
        },
        content = {
            DiceWithButtonAndImage(modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center))
        }
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var hasildadu1 by remember { mutableStateOf(0) }
    var hasildadu2 by remember { mutableStateOf(0) }
    val context = LocalContext.current
    val dadu1 = when (hasildadu1) {
        0 -> R.drawable.empty_dice
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val dadu2 = when (hasildadu2) {
        0 -> R.drawable.empty_dice
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Image(
                modifier = Modifier.size(170.dp),
                painter = painterResource(dadu1),
                contentDescription = hasildadu1.toString()
            )
            Image(
                modifier = Modifier.size(170.dp),
                painter = painterResource(dadu2),
                contentDescription = hasildadu2.toString()
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(width = 170.dp, height = 50.dp),
            onClick = {
                hasildadu1 = (1..6).random()
                hasildadu2 = (1..6).random()
                if (hasildadu1 == hasildadu2) {
                    Toast.makeText(context, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}
