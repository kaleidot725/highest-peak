package kaleidot725.highestpeaks.ui.edit.position

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kaleidot725.highestpeaks.R

class PositionFragment : Fragment() {

    companion object {
        fun newInstance() = PositionFragment()
    }

    private lateinit var viewModel: PositionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.position_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PositionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
