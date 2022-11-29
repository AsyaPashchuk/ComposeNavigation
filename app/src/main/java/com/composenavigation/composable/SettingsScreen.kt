package com.composenavigation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composenavigation.navigation.model.ListItem

@Composable
fun SettingsScreen() {
    var items by remember {
        mutableStateOf((1..20).map {
                ListItem(
                    title = "Item $it",
                    isSelected = false
                )
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Settings Screen",
            modifier = Modifier.padding(vertical = 8.dp))
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(items.size) { i ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        items = items.mapIndexed{j, item ->
                            if (i == j) {
                                item.copy(isSelected = !item.isSelected)
                            } else item
                        }
                    },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = items[i].title)
                    if (items[i].isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected",
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}