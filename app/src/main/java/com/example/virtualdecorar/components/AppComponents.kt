package com.example.virtualdecorar.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtualdecorar.ui.theme.Black
import com.example.virtualdecorar.ui.theme.GraySHADE
import com.example.virtualdecorar.ui.theme.LightBlack1
import com.example.virtualdecorar.ui.theme.LightGreen1
import com.example.virtualdecorar.ui.theme.LightGreen2
import com.example.virtualdecorar.ui.theme.White
import com.example.virtualdecorar.ui.theme.WhiteSHADE1

@Composable
fun NormalTextSmallHeading(value: String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal
        ),
        color = LightBlack1,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextBoldHeading(value: String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        ),
        color = Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun InputField(label: String, painterResource: Painter, textValue: MutableState<String>) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        value = textValue.value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = LightGreen1,
            unfocusedContainerColor = WhiteSHADE1,
            focusedContainerColor = WhiteSHADE1,
            unfocusedBorderColor = WhiteSHADE1
        ),
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = label)
        }
    )
}

@Composable
fun InputPasswordField(label: String, painterResource: Painter, password: MutableState<String>) {

    val localFocusManager = LocalFocusManager.current

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        value = password.value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = LightGreen1,
            unfocusedContainerColor = WhiteSHADE1,
            focusedContainerColor = WhiteSHADE1,
            unfocusedBorderColor = WhiteSHADE1
        ),
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions{
                                         localFocusManager.clearFocus()
        },
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = label)
        },
        trailingIcon = {
            val eyeIcon = if (passwordVisible.value){
                Icons.Filled.Visibility
            }
            else {
                Icons.Filled.VisibilityOff
            }

            var desc = if (passwordVisible.value){
                "Hide password"
            }
            else{
                "Show Password"
            }
            
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = eyeIcon, contentDescription = desc)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value,
            onCheckedChange ={
                checkedState.value = !checkedState.value
            } )
        
        ClickableTextComponent(value = value, onTextSelected)
    }


    
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing, you are accepting our"
    val privacyText = " Privacy Policy"
    val andText = " and"
    val termsOfUse = " Terms of Use."

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = privacyText, annotation = privacyText)
            append(privacyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = termsOfUse, annotation = termsOfUse)
            append(termsOfUse)
        }
    }
    
    ClickableText(text = annotatedString, onClick = {
        offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also {
                Log.d("ClickableTextComponent", "ClickableTextComponent: {$it}")

                if(it.item == termsOfUse || it.item == privacyText){
                    onTextSelected(it.item)
                }
            }
    })
}

@Composable
fun ButtonComponent(value: String, onLogin: () -> Unit) {
    Button(onClick = onLogin,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(LightGreen1, LightGreen2)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
            ){
            Text(text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth().background(White).padding(top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            color = LightBlack1,
            thickness = 1.dp)
        
        Text(text = "or", fontSize = 14.sp, color = LightBlack1,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp))
        
        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            color = LightBlack1,
            thickness = 1.dp)
    }
}

@Composable
fun ClickableLoginComponent(initial: String, annString: String, onTextSelected: (String) -> Unit) {

    val annotatedString = buildAnnotatedString {
        append(initial)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = annString, annotation = annString)
            append(annString)
        }
    }

    ClickableText(text = annotatedString, modifier = Modifier
        .fillMaxWidth()
        .background(White)
        .heightIn(min = 24.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        onClick = {
            offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also {
                Log.d("ClickableTextComponent", "ClickableTextComponent: {$it}")

                if (it.item == annString) {
                    onTextSelected(it.item)
                }
            }
    })
}

@Composable
fun UnderlinedTextComponent(value: String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .heightIn(min = 40.dp)
            .padding(top = 4.dp),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = GraySHADE
        ),
            textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}