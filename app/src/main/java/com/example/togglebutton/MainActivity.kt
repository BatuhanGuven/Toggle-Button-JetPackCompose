package com.example.togglebutton

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToggleButton()
        }
    }
}

@Composable
fun ToggleButton() {
    var isChecked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Row(
        modifier = Modifier.padding(16.dp).shadow(16.dp).clip(RoundedCornerShape(16.dp)).background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Toggle Button:",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                Toast.makeText(
                    context,
                    "Checked: $isChecked",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.size(40.dp)
        )
    }
}
