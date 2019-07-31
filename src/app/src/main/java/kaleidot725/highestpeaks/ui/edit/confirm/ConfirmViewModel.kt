package kaleidot725.highestpeaks.ui.edit.confirm

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kaleidot725.highestpeaks.di.data.Picture
import kaleidot725.highestpeaks.di.service.FormatEditor
import kaleidot725.highestpeaks.di.service.PictureEditor
import kaleidot725.highestpeaks.ui.edit.EditNavigator
import kaleidot725.michetimer.model.repository.PictureRepository
import java.lang.Exception

class ConfirmViewModel(
    val navigator: EditNavigator,
    val pictureRepository: PictureRepository,
    val formatEditor : FormatEditor,
    val pictureEditor : PictureEditor
) : ViewModel() {

    private val _editPath : MutableLiveData<String> = MutableLiveData()
    val editPath : LiveData<String> = _editPath

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    init {
        if (pictureRepository.took == null) {
            navigator.exit()
        }

        val target = pictureRepository.took as Picture
        val preview = pictureRepository.newPicture()

        pictureEditor.start(target, preview)
        pictureEditor.modifyText(formatEditor.create())

        _editPath.value = pictureEditor.preview!!.path
        val disposable = pictureEditor.state.subscribe {
            if (pictureEditor.preview != null) {
                _editPath.postValue(pictureEditor.preview!!.path)
            }
        }
        compositeDisposable.add(disposable)
    }

    fun save(view : View) {
        pictureEditor.end()
        navigator.exit()
    }

    fun cancel(view : View) {
        pictureEditor.cancel()
        navigator.exit()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}