package br.com.fiap.zenmail.modules.spam

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.zenmail.R
import br.com.fiap.zenmail.shared.composables.Header
import br.com.fiap.zenmail.shared.composables.MailCard
import br.com.fiap.zenmail.shared.composables.TitleBanner
import br.com.fiap.zenmail.shared.repository.MessageRepository
import br.com.fiap.zenmail.shared.repository.UserRepository
import br.com.fiap.zenmail.ui.theme.Typography

@Composable
fun SpamView(navController: NavController, viewModel: SpamViewModel, id: Int) {

    val context = LocalContext.current
    val userRepo = UserRepository(context)
    val user = userRepo.getUserById(id)
    val messages = viewModel.messages.observeAsState()

    val messagesRepo = MessageRepository(context)

    try {
        val receivedMessages = messagesRepo.getMessagesSpam(user.email)

        viewModel.setMessages(receivedMessages)
    } catch (e: Exception) {
        Log.e("Error", "Erro ao obter mensagens: ${e.message}")
    }

    Box {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header(isLogged = true, screenIndex = 3, navController, id)
            Spacer(modifier = Modifier.height(16.dp))
            TitleBanner(title = "Caixa de spam")
            if (messages.value != null && messages.value!!.isNotEmpty()) {
                messages.value!!.forEach {
                    MailCard(
                        sender = it.sender,
                        message = it.message,
                        date = it.date,
                        wasRead = it.wasRead,
                        id = it.id,
                        navController= navController,
                        user = user,
                        recipient = it.recipient
                    )
                }
            } else {
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    text = "Caixa de spam vazia",
                    style = Typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.secondary)
                )
            }
        }
        FloatingActionButton(
            onClick = {
                navController.navigate("creation?id=$id")
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = colorResource(id = R.color.primary)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pencil_icon),
                contentDescription = "Pencil icon",
                tint = colorResource(id = R.color.secondary)
            )
        }

    }
}