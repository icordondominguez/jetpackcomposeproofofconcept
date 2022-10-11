package com.example.jetpackcomposeproofofconcept.presentation.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcomposeproofofconcept.R
import com.example.jetpackcomposeproofofconcept.presentation.CharacterDetailViewModel
import com.example.jetpackcomposeproofofconcept.presentation.theme.colorPrimary

@Composable
fun CharacterScreen(id: Int?) {
    val viewModel = hiltViewModel<CharacterDetailViewModel>()
    val state by viewModel.mState.collectAsState()

    state.character?.let {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.End) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_no_favorite),
                        contentDescription = "Character image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(4.dp)
                    )
                }

            }
            Row {
                Image(
                    painter = rememberAsyncImagePainter(it.image),
                    contentDescription = "Character image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .border(1.dp, colorPrimary, CircleShape)
                )
            }

            Row {
                Text(
                    text = it.name,
                    color = colorPrimary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.fillMaxWidth().height(2.dp))

            Row {
                Text(
                    text = if (it.description == "") "No description found" else it.description,
                    color = colorPrimary,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview
fun CharacterScreenPreview() {
    CharacterScreen(id = 1)
}
