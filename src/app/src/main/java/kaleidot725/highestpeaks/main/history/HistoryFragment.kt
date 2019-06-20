package kaleidot725.highestpeaks.main.history

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.Binds
import dagger.android.support.AndroidSupportInjection

import kaleidot725.highestpeaks.R
import kaleidot725.highestpeaks.databinding.HistoryFragmentBinding
import kaleidot725.highestpeaks.main.MainNavigator
import kaleidot725.highestpeaks.model.data.Holder
import kaleidot725.highestpeaks.model.data.Picture
import kaleidot725.michetimer.model.repository.PictureRepository
import javax.inject.Inject

class HistoryFragment : Fragment() {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    @Inject
    lateinit var navigator : MainNavigator

    @Inject
    lateinit var repository : PictureRepository

    @Inject
    lateinit var preview : Holder<Picture>

    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.history_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, HistoryViewModelFactory(navigator, repository, preview)).get(HistoryViewModel::class.java)
        viewModel.load()

        val binding = DataBindingUtil.bind<HistoryFragmentBinding>(this.view as View)
        binding?.lifecycleOwner = this
        binding?.vm = viewModel

        val recyclerView =view.findViewById<RecyclerView>(R.id.picture_recycler_view)
        recyclerView.adapter = PictureAdapter(this, viewModel.pictureViewModels.value ?: listOf())
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
    }
}
