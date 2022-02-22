package com.borshevskiy.telegramclone.ui.settings

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.borshevskiy.telegramclone.R
import com.borshevskiy.telegramclone.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_actions, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}