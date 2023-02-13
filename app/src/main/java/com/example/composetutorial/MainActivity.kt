package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(
                Message("Android", "Jetpack Compose")
            )
        }
    }

    data class Message(
        val author: String,
        val body: String
        )

    @Composable
    fun MessageCard(message: Message) {
        // Add padding around our message
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ai_girl),
                contentDescription = "AI generated girl",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )
            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = message.author)
                // Add a horizontal space between the image and the column
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = message.body)
            }
        }
    }
    
    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(
            message = Message("Colleague", "Take a look on Jetpack Compose, it`s great!")
        )
    }
}
