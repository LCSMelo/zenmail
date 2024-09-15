package br.com.fiap.zenmail.modules.mail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.fiap.zenmail.shared.models.Message

class MailViewModel {
    private val _message = MutableLiveData<Message>()
    val message: LiveData<Message> = _message

    fun setMessage(value: Message){
        _message.value = value
    }
}