package kaleidot725.daycamera.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.LibsBuilder
import kaleidot725.daycamera.R
import kaleidot725.daycamera.databinding.FragmentSettingBinding
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentSettingBinding>(inflater, LAYOUT_ID, container, false).apply {
            viewModel = SettingViewModel()
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contact_button.setOnClickListener {
            findNavController().navigate(R.id.action_settingFragment_to_contactFragment)
        }

        config_button.setOnClickListener {
            findNavController().navigate(R.id.action_settingFragment_to_configFragment)
        }

        privacy_button.setOnClickListener {
            findNavController().navigate(R.id.action_settingFragment_to_privacyFragment)
        }

        license_button.setOnClickListener {
            LibsBuilder()
                .withActivityTitle("License")
                .withShowLoadingProgress(false)
                .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR).start(context)
        }
    }

    companion object {
        private const val LAYOUT_ID = R.layout.fragment_setting
    }
}