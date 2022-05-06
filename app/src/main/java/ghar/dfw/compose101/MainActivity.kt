package ghar.dfw.compose101

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ghar.dfw.compose101.ui.theme.Compose101Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Compose101Theme {
//        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Gray) {
          Greetings_Card(Message("Android", " working"))
          JetButton("Enjoy by clicking...")
        }
      }
    }
  }

  @Composable
  fun Greetings_Card(msg: Message) {
    Row {
      Column {
        Text(text = " ${msg.author}")
        Text(text = "is ${msg.body}")
      }
      Spacer(modifier = Modifier.width(8.dp))
      Column {
        Text(text = " J-Compose ${msg.author}")
        Text(text = " Yes, it is ${msg.body}")
      }
    }

  }

  @Composable
  fun JetButton(label: String) {
    Button(
      onClick = { Toast.makeText(this, "onClick() action:", Toast.LENGTH_LONG).show() },
      modifier = Modifier.padding(
        Dp(30.5F),
        Dp(330.25F)
      ),
      enabled = true,
      shape = CircleShape,
      // below line is use to
      // add border to our button.
      border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue))

      ) {
        Text(text = label)
    }
  }


  @Preview(showBackground = true)
  @Composable
  fun DefaultPreview() {
    Compose101Theme {
      Greetings_Card(Message("there", "Good"))
    }
  }

  data class Message(val author: String, val body: String)

}