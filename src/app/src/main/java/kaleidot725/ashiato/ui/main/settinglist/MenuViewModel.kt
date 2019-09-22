package kaleidot725.ashiato.ui.main.settinglist

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaleidot725.ashiato.R
import kaleidot725.ashiato.di.service.contact.Menu
import kaleidot725.ashiato.ui.main.MainNavigator

class MenuViewModel(
    val context: Context,
    val navigator: MainNavigator,
    val menu: Menu
) : ViewModel() {

    private val _icon: MutableLiveData<Int> = MutableLiveData<Int>()
    val icon: LiveData<Int> get() = _icon

    private val _title: MutableLiveData<String> = MutableLiveData<String>()
    val title: LiveData<String> get() = _title

    init {
        _icon.value = menu.icon
        _title.value = menu.title
    }

    fun click(view: View) {
        when (menu.title) {
            context.getString(R.string.menu_setting) -> navigator.navigateSetting()
            context.getString(R.string.menu_license) -> navigator.navigateLicense()
            context.getString(R.string.menu_contanct) -> navigator.navigateContact()
        }
    }
}