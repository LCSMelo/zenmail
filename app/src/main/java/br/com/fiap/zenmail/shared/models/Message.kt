package br.com.fiap.zenmail.shared.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_message", )
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val recipient: String,
    val sender: String,
    val message: String = "",
    val date: Long,
    val status: String = "",
    val wasRead: Boolean
)