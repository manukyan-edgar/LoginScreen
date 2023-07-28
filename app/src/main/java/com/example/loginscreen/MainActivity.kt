package com.example.loginscreen

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.ui.elements.EmailTextField
import com.example.loginscreen.ui.elements.PasswordTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (isPortrait)
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.bg),
                contentDescription = stringResource(id = R.string.background_image_description),
                contentScale = ContentScale.FillBounds
            )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(250.dp)
                    .width(220.dp),
                painter = painterResource(id = R.drawable.ic_login_header),
                contentDescription = stringResource(id = R.string.login_icon_description)
            )
            Text(
                text = stringResource(id = R.string.login_header),
                fontSize = 40.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
            )

            EmailTextField(isPortrait = isPortrait)
            PasswordTextField(isPortrait = isPortrait)

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = if (isPortrait) 48.dp else 72.dp,
                        vertical = 16.dp
                    ),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.login_button_color)),
                onClick = {
                    Toast.makeText(context, "Login clicked!", Toast.LENGTH_SHORT)
                        .show()
                },
            ) {
                Text(text = stringResource(id = R.string.login_button_text))
            }

            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(bottom = 16.dp)
            ) {
                Image(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp),
                    painter = painterResource(id = R.drawable.ic_login_fb),
                    contentDescription = stringResource(id = R.string.login_fb_icon_description)
                )
                Image(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .height(48.dp)
                        .width(48.dp),
                    painter = painterResource(id = R.drawable.ic_login_google),
                    contentDescription = stringResource(id = R.string.login_google_icon_description)
                )
                Image(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp),
                    painter = painterResource(id = R.drawable.ic_login_ig),
                    contentDescription = stringResource(id = R.string.login_insta_icon_description)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginScreen()
}