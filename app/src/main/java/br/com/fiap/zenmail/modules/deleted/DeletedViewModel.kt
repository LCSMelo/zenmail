package br.com.fiap.zenmail.modules.deleted

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.fiap.zenmail.shared.models.Message

class DeletedViewModel {
    private val _messages = MutableLiveData<Array<Message>>(emptyArray())
    val messages : LiveData<Array<Message>> = _messages

    fun setMessages(value: Array<Message>){
        _messages.value = value
    }
}