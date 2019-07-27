package kaleidot725.highestpeaks.ui.edit.format

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kaleidot725.highestpeaks.di.repository.FormatRepository
import kaleidot725.highestpeaks.ui.main.history.HistoryViewModel

class FormatViewModelFactory(private val formatRepository : FormatRepository)  : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == FormatViewModel::class.java) {
            return FormatViewModel(formatRepository) as T
        }

        throw IllegalArgumentException("undefined class")
    }
}
