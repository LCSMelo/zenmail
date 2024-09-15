package br.com.fiap.zenmail


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.zenmail.View.calendar.CalendarView
import br.com.fiap.zenmail.View.creation.CreationView
import br.com.fiap.zenmail.View.home.HomeView
import br.com.fiap.zenmail.View.login.LoginView
import br.com.fiap.zenmail.View.mail.MailView
import br.com.fiap.zenmail.modules.calendar.CalendarViewModel
import br.com.fiap.zenmail.modules.creation.CreationViewModel
import br.com.fiap.zenmail.modules.deleted.DeletedView
import br.com.fiap.zenmail.modules.deleted.DeletedViewModel
import br.com.fiap.zenmail.modules.login.LoginViewModel
import br.com.fiap.zenmail.modules.mail.MailViewModel
import br.com.fiap.zenmail.modules.mails.MailsView
import br.com.fiap.zenmail.modules.mails.MailsViewModel
import br.com.fiap.zenmail.modules.register.RegisterView
import br.com.fiap.zenmail.modules.register.RegisterViewModel
import br.com.fiap.zenmail.modules.sent.SentView
import br.com.fiap.zenmail.modules.sent.SentViewModel
import br.com.fiap.zenmail.modules.spam.SpamView
import br.com.fiap.zenmail.modules.spam.SpamViewModel
import br.com.fiap.zenmail.ui.theme.LocawebChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocawebChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home", builder = {
                        composable("home") {
                            HomeView(navController)
                        }
                        composable("register") {
                            RegisterView(navController, viewModel = RegisterViewModel())
                        }
                        composable("login") {
                            LoginView(navController, viewModel = LoginViewModel())
                        }
                        composable("mails?id={id}", arguments = listOf(navArgument(name = "id") {
                            defaultValue = 0
                        })) {
                            val id = it.arguments?.getInt("id")
                            MailsView(navController, viewModel = MailsViewModel(), id!!)
                        }
                        composable("creation?id={id}", arguments = listOf(navArgument(name = "id") {
                            defaultValue = 0
                        })) {
                            val id = it.arguments?.getInt("id")
                            CreationView(navController, viewModel = CreationViewModel(), id!!)
                        }
                        composable("sent?id={id}", arguments = listOf(navArgument(name = "id") {
                            defaultValue = 0
                        })) {
                            val id = it.arguments?.getInt("id")
                            SentView(navController, viewModel = SentViewModel(), id!!)
                        }
                        composable("spam?id={id}", arguments = listOf(navArgument(name = "id") {
                            defaultValue = 0
                        })) {
                            val id = it.arguments?.getInt("id")
                            SpamView(navController, viewModel = SpamViewModel(), id!!)
                        }
                        composable("deleted?id={id}", arguments = listOf(navArgument(name = "id") {
                            defaultValue = 0
                        })) {
                            val id = it.arguments?.getInt("id")
                            DeletedView(navController, viewModel = DeletedViewModel(), id!!)
                        }
                        composable(
                            "mail?id={id}&userId={userId}",
                            arguments = listOf(navArgument(name = "id") {
                                defaultValue = 0
                            }, navArgument(name = "userId") { defaultValue = 0 })
                        ) {
                            val id = it.arguments?.getInt("id")
                            val userId = it.arguments?.getInt("userId")
                            MailView(navController, viewModel = MailViewModel(), id!!, userId!!)
                        }
                        composable("calendar") {
                            CalendarView(navController, viewModel = CalendarViewModel())
                        }
                    })
                }
            }
        }
    }
}



