package br.com.fiap.locawebchallenge


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
import br.com.fiap.locawebchallenge.View.calendar.CalendarView
import br.com.fiap.locawebchallenge.View.creation.CreationView
import br.com.fiap.locawebchallenge.View.home.HomeView
import br.com.fiap.locawebchallenge.View.login.LoginView
import br.com.fiap.locawebchallenge.View.mail.MailView
import br.com.fiap.locawebchallenge.modules.calendar.CalendarViewModel
import br.com.fiap.locawebchallenge.modules.creation.CreationViewModel
import br.com.fiap.locawebchallenge.modules.deleted.DeletedView
import br.com.fiap.locawebchallenge.modules.deleted.DeletedViewModel
import br.com.fiap.locawebchallenge.modules.login.LoginViewModel
import br.com.fiap.locawebchallenge.modules.mail.MailViewModel
import br.com.fiap.locawebchallenge.modules.mails.MailsView
import br.com.fiap.locawebchallenge.modules.mails.MailsViewModel
import br.com.fiap.locawebchallenge.modules.register.RegisterView
import br.com.fiap.locawebchallenge.modules.register.RegisterViewModel
import br.com.fiap.locawebchallenge.modules.sent.SentView
import br.com.fiap.locawebchallenge.modules.sent.SentViewModel
import br.com.fiap.locawebchallenge.modules.spam.SpamView
import br.com.fiap.locawebchallenge.modules.spam.SpamViewModel
import br.com.fiap.locawebchallenge.ui.theme.LocawebChallengeTheme

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



