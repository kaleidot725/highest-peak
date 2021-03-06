package kaleidot725.ashiato.ui.edit.format

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kaleidot725.ashiato.R
import kaleidot725.ashiato.databinding.FormatFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FormatFragment : Fragment() {

    companion object {
        fun newInstance() = FormatFragment()
    }

    private val formatViewModel: FormatViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FormatFragmentBinding>(
            inflater,
            R.layout.format_fragment,
            container,
            false
        ).apply {
            vm = formatViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = this.view?.findViewById<RecyclerView>(R.id.format_recycler_view)
        formatViewModel.formatRecyclerViewModels.observe(this, Observer {
            recyclerView?.adapter =
                FormatRecyclerAdapter(
                    this,
                    formatViewModel.formatRecyclerViewModels.value ?: listOf()
                )
            recyclerView?.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            recyclerView?.setHasFixedSize(true)
        })

        formatViewModel.load()
    }
}
