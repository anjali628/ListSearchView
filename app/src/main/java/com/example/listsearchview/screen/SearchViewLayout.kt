package com.example.listsearchview.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun SearchView() {

    var search by remember { mutableStateOf("") }
    val lists = listOf(
        "Lion",
        "Tiger",
        "Apple",
        "Orange",
        "Apricot",
        "Monkey",
        "Cheetah",
        "Beer",
        "Mango",
        "Money",
        "Banana",
        "Strawberry"
    )

    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ){

        val filterList:List<String> = if(search.isEmpty()){
            lists
        } else {
            val result = arrayListOf<String>()
            for (temp in lists){
                if (temp.lowercase(Locale.getDefault()).contains(
                        search.lowercase(Locale.getDefault())
                )){
                    result.add(temp)
                }
            }
            result
        }

        item {
            CustomSearchView(text = search, onValueChange = {
                search = it
            } )
        }
        
        items(filterList){data->
            Text(text = data, modifier = Modifier.padding(top=10.dp) )
        }

    }

}

@Composable
fun CustomSearchView(
    text: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = text, onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Search") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "", tint = Color.Black) },
        colors = TextFieldDefaults.textFieldColors(
            //backgroundColor = Color.Transparent
        )
    )

}