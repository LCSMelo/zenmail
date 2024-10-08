package br.com.fiap.locawebchallenge.shared.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locawebchallenge.R
import br.com.fiap.locawebchallenge.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(isLogged: Boolean, screenIndex: Int = 0, navController: NavController? = null, id: Int = 0) {
    Box {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if(isLogged){
                    Surface(
                        onClick = {
                            navController!!.navigate("home")
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Locamail Logo",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                } else {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Locamail Logo",
                    modifier = Modifier.size(48.dp)
                )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    if (isLogged) {
<<<<<<< HEAD
                        TextButton(
                            onClick = { navController!!.navigate("mails?id=$id") },
                            Modifier.height(32.dp)
                        ) {
                            Text(
                                text = "Entrada",
                                style = Typography.bodyLarge,
                                color = colorResource(id = if (screenIndex == 1) R.color.secondary else R.color.primary)
=======
//                        TextButton(
//                            onClick = { navController!!.navigate("mails?id=$id") },
//                            Modifier.height(32.dp)
//                        ) {
//                            Text(
//                                text = "Entrada",
//                                style = Typography.bodyLarge,
//                                color = colorResource(id = if (screenIndex == 1) R.color.secondary else R.color.primary)
//                            )
//                        }
                        Surface(
                            onClick = {
                                navController!!.navigate("mail")
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.entrada),
                                contentDescription = "Locamail Logo",
                                modifier = Modifier.size(48.dp)
>>>>>>> 35b2989 (mudanças no header)
                            )
                        }
                        TextButton(
                            onClick = { navController!!.navigate("sent?id=$id") },
                            Modifier.height(32.dp)
                        ) {
                            Text(
                                text = "Enviados",
                                style = Typography.bodyLarge,
                                color = colorResource(id = if (screenIndex == 2) R.color.secondary else R.color.primary)
                            )
                        }
                        TextButton(
                            onClick = { navController!!.navigate("spam?id=$id") },
                            Modifier.height(32.dp)
                        ) {
                            Text(
                                text = "Spam",
                                style = Typography.bodyLarge,
                                color = colorResource(id = if (screenIndex == 3) R.color.secondary else R.color.primary)
                            )
                        }
                        TextButton(
                            onClick = { navController!!.navigate("deleted?id=$id") },
                            Modifier.height(32.dp)
                        ) {
                            Text(
                                text = "Excluídos",
                                style = Typography.bodyLarge,
                                color = colorResource(id = if (screenIndex == 4) R.color.secondary else R.color.primary)
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = colorResource(R.color.gray))
            )
        }
    }
}