package kaleidot725.ashiato.ui.edit.format

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope
import kaleidot725.ashiato.data.repository.FormatRepository
import kaleidot725.ashiato.data.service.picture.FormatEditor
import kaleidot725.ashiato.data.service.picture.PictureEditor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FormatViewModel(
    private val pictureEditor: PictureEditor,
    private val formatEditor: FormatEditor,
    private val formatRepository: FormatRepository
) : ViewModel() {
    private val _formatRecyclerViewModels: MutableLiveData<List<FormatRecyclerViewModel>> =
        MutableLiveData()
    val formatRecyclerViewModels: LiveData<List<FormatRecyclerViewModel>> get() = _formatRecyclerViewModels

    fun load() {
        viewModelScope.launch(Dispatchers.Default) {
            val vms = formatRepository.all()
                .map { FormatRecyclerViewModel(pictureEditor, formatEditor, it) }
            _formatRecyclerViewModels.postValue(vms)
        }
    }
}
