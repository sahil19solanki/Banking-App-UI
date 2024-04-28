package com.android.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.bankingappui.data.Card
import com.android.bankingappui.ui.theme.BlueEnd
import com.android.bankingappui.ui.theme.BlueStart
import com.android.bankingappui.ui.theme.GreenEnd
import com.android.bankingappui.ui.theme.GreenStart
import com.android.bankingappui.ui.theme.OrangeEnd
import com.android.bankingappui.ui.theme.OrangeStart
import com.android.bankingappui.ui.theme.PurpleEnd
import com.android.bankingappui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        "VISA",
        "4561 8965 7892 4621",
        "Business",
        46.457,
        getGradient(
            PurpleStart,
            PurpleEnd
        )
    ),
    Card(
        "MASTER CARD",
        "9387 8365 7369 4621",
        "Savings",
        67.464,
        getGradient(
            BlueStart,
            BlueEnd
        )
    ),
    Card(
        "VISA",
        "4821 2713 0947 4621",
        "Business",
        4.457,
        getGradient(
            OrangeStart,
            OrangeEnd
        )
    ),
    Card(
        "MASTER CARD",
        "8537 3543 2267 8762",
        "Business",
        26.357,
        getGradient(
            GreenStart,
            GreenEnd
        )
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) {
            CardItem(it)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItempaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItempaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItempaddingEnd)
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .height(160.dp)
                .width(250.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}