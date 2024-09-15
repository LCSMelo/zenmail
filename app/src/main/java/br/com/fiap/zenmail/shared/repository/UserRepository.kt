    package br.com.fiap.zenmail.shared.repository

    import android.content.Context
    import br.com.fiap.zenmail.shared.db.SQLiteDb
    import br.com.fiap.zenmail.shared.models.User

    class UserRepository(context: Context) {
        private val db = SQLiteDb.getDatabase(context).userDAO()

        fun createUser(user: User) {
            db.createUser(user)
        }

        fun getAllUsers(): Array<User> {
            return db.getAllUsers()
        }

        fun getUser(email: String, password: String): User {
            return db.getUser(email, password)
        }

        fun getUserById(id: Int): User {
            return db.getUserById(id)
        }
    }