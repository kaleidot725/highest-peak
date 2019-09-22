package kaleidot725.ashiato.ui.main

import android.net.Uri
import java.io.File

interface MainNavigator {
    // Activity
    fun navigateCamera(): Boolean
    fun navigateEdit(): Boolean
    fun navigateSetting(): Boolean
    fun navigateLicense(): Boolean
    fun navigateContact(): Boolean
    fun navigatePreview(): Boolean

    // Fragment
    fun navigateHome(): Boolean
    fun navigateHistory(): Boolean
    fun navigateSettingList(): Boolean

    // Share Compat
    fun navigateShare(files : List<File>)
}