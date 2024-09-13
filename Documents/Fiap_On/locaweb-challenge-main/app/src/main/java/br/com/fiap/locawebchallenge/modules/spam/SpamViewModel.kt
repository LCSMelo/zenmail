package br.com.fiap.locawebchallenge.modules.spam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.locawebchallenge.shared.models.Message

class SpamViewModel : ViewModel() {
    private val _messages = MutableLiveData<Array<Message>>(emptyArray())
    val messages : LiveData<Array<Message>> = _messages

    fun setMessages(value: Array<Message>){
        _messages.value = value
    }
}