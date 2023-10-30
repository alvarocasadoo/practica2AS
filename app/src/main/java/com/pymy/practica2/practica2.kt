package com.pmym.practica2

import SampleData
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pymy.practica2.R
import com.pymy.practica2.ui.theme.Practica2Theme

//import android.os.Message




//Al importar un nuevo módulo para la práctica 2 tendremos que cambiar el contenido de nuestro Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}
data class Message(val author: String, val body:String)

@Composable
fun MessageCard(msg: Message){
    if (msg.author=="Lexi"){

    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .padding(start = 2.dp, top = 1.dp, end = 2.dp, bottom = 1.dp)
        .defaultMinSize(100.dp)
        //.background(color = CustomYellow)
    ){
        Row (modifier = Modifier.padding(all = 8.dp)){
            Image(
                painter = painterResource(R.drawable.quevedo),
                contentDescription = "Imagen de contacto",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(4.dp))
                Surface (shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp)
                {
                    Text(text = msg.body,
                        style = MaterialTheme.typography.titleMedium)
                }
            }
        }

    }
    }else{
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                //.fillMaxWidth()
                //.height(70.dp)
                .padding(all = 6.dp)
        ){
            Spacer(modifier = Modifier.weight(2f)) //De esta forma puedo dejar un espacio mínimo para que el mensaje salga a la derecha
            Box(modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .padding(start = 2.dp, top = 1.dp, end = 2.dp, bottom = 1.dp)
                .defaultMinSize(100.dp)
                .background(MaterialTheme.colorScheme.tertiary)
            ){
                Text(text = msg.body,
                    modifier = Modifier
                        .wrapContentHeight(Alignment.Bottom)
                        .padding(all = 2.dp)
                    ,
                    textAlign = TextAlign.Right
                )
            }

        }
    }
}

@Composable
fun Conversation(messages: List<Message>){ //
    LazyColumn{
        items(messages){
                message ->
            MessageCard(message)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewConversation(){
    Practica2Theme{
        Conversation(SampleData.conversationSample)
    }
}


@Composable
fun InversedMessageCard(msg: Message){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            //.fillMaxWidth()
            //.height(70.dp)
            .padding(all = 6.dp)
    ){
        Spacer(modifier = Modifier.weight(2f)) //De esta forma puedo dejar un espacio mínimo para que el mensaje salga a la derecha
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(start = 2.dp, top = 1.dp, end = 2.dp, bottom = 1.dp)
            .defaultMinSize(100.dp)
            .background(color = Color.LightGray)
        ){
            Text(text = msg.body,
                modifier = Modifier
                    .wrapContentHeight(Alignment.Bottom)
                    .padding(all = 2.dp)
                ,
                textAlign = TextAlign.Right
            )
        }

    }
}
/*
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun PreviewMessageCard(){
    Practica2Theme {
        Surface {
            MessageCard(msg = Message(
                "Spiderman",
                "El crimen últimamente está que no para," +
                        " a ver si los villanos se relajan un poquito."))
        }
    }

}
*/

/*

@Preview(showBackground = true)
@Composable
fun InversedPreviewMessageCard(){
    InversedMessageCard(msg = Message(
        "Spiderman",
        "El crimen últimamente está que no para," +
                " a ver si los villanos se relajan un poquito."))
}

 */

@Composable
fun Chat(msg: Message, msg2: Message){
    Row {
        Column {
            MessageCard(msg)
            InversedMessageCard(msg2)
            MessageCard(msg)
            InversedMessageCard(msg2)
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun ChatPreview(){
    Chat(msg = Message("Quevedo","Mensaje de tu amigo y vecino Spideman"),
        msg2 = Message("Yo", "Respuesta de mi mismo")
    )
}
 */