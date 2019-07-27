package kaleidot725.highestpeaks.ui.edit.format

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.AndroidSupportInjection

import kaleidot725.highestpeaks.R
import kaleidot725.highestpeaks.databinding.FormatFragmentBindingImpl
import kaleidot725.highestpeaks.di.repository.FormatRepository
import kaleidot725.michetimer.model.repository.PictureRepository
import javax.inject.Inject

class FormatFragment : Fragment() {

    companion object {
        fun newInstance() = FormatFragment()
    }


    @Inject
    lateinit var repository: FormatRepository

    private lateinit var viewModel: FormatViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.format_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, FormatViewModelFactory(repository)).get(FormatViewModel::class.java)

        val binding = DataBindingUtil.bind<FormatFragmentBindingImpl>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = viewModel

        val recyclerView = this.view?.findViewById<RecyclerView>(R.id.format_recycler_view)
        recyclerView?.adapter = FormatRecyclerAdapter(this, viewModel.formatRecyclerViewModels.value ?: listOf())
        recyclerView?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView?.setHasFixedSize(true)
     }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FormatViewModel::class.java)
    }
}
