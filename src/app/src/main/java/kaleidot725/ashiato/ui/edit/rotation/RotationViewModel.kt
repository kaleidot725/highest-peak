package kaleidot725.ashiato.ui.edit.rotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kaleidot725.ashiato.data.repository.AngleRepository
import kaleidot725.ashiato.data.service.picture.PictureEditor
import kaleidot725.ashiato.data.service.picture.RotationEditor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RotationViewModel(
    private val pictureEditor: PictureEditor,
    private val rotationEditor: RotationEditor,
    private val rotationRepository: AngleRepository
) : ViewModel() {
    private val _rotationRecyclerViewModels: MutableLiveData<List<RotationRecyclerViewModel>> =
        MutableLiveData()
    val rotaionRecyclerViewModels: LiveData<List<RotationRecyclerViewModel>> get() = _rotationRecyclerViewModels

    fun load() {
        viewModelScope.launch(Dispatchers.Default) {
            val vms = rotationRepository.all().map {
                RotationRecyclerViewModel(pictureEditor, rotationEditor, it)
            }
            _rotationRecyclerViewModels.postValue(vms)
        }
    }
}
