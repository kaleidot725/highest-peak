package kaleidot725.ashiato.di.service.picture

import io.reactivex.subjects.Subject

interface ColorEditor {
    val lastEnabled: Color
    val enabled: Subject<Color>
    fun enable(color: Color)
}