package com.example.travelapp.ui.features

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelapp.ui.theme.OverPassFontFamily
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding


@Composable
fun SplashScreen(navController: NavController) {


    var splashUrl =
        "https://images.unsplash.com/photo-1512100356356-de1b84283e18?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=709&q=80"

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        // 이미지를 전체 화면으로 URL로 가져옴

        Image(
            painter = rememberCoilPainter(request = splashUrl),  //url로 이미지 가져옴
            contentDescription = "",
            contentScale = ContentScale.Crop, //일부 자라내다
            modifier = Modifier.fillMaxSize()  //작은 이미지도 전체 화면으로 크게 늘림
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()  //BOTTOM의 공간을 네비게이션바 만큼 띄움
                .padding(16.dp)  //좌측우측아래 공간을 띄움
                .background(  // 바탕을 흰색으로...
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                )
                .padding(16.dp)  // 안쪽의 공간을 띄움
        ) {

            Text(
                text = "Explore\nNew Places",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                letterSpacing = (-1).sp
            )

            Text(
                text = "Exploria will help you to find new hotels, book cheap flights and lot more.",
                fontFamily = OverPassFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.1).sp
            )

            Button(
                onClick = {
                    navController.navigate("home")  //메인페이지 호출함
                },
                modifier = Modifier
                    .padding( 8.dp, 24.dp) //바깥에 가로, 세로
                    .fillMaxWidth()
            ) {

                Text(text = "Get Started")

                Spacer(modifier = Modifier.width(8.dp)) //사이에 띄움

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = ""
                )

            }

        }


    }


}


@Preview
@Composable
fun SplashPreview() {


}