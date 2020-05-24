package app.imuuzak.navigation_sample.ui.main

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class DetailViewModel() : ViewModel() {
    val name = MutableLiveData<String>()
    fun setName(name: String) {
        this.name.value = name
    }

    val purchased = MutableLiveData<Boolean>()
    val isPurchaseProcessing = MutableLiveData<Boolean>().apply { value = false }
    val purchaseText = Transformations.map(isPurchaseProcessing) {
        if (it) {
            "購入処理中です。しばらくお待ちください。"
        } else {
            "購入する"
        }
    }
    fun purchase() {
        isPurchaseProcessing.value = true
        Handler().postDelayed({
            purchased.value = true
        }, 3000)
    }

    fun clear() {
        isPurchaseProcessing.value = false
        purchased.value = false
    }
}
