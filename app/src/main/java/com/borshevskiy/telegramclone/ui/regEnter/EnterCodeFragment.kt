package com.borshevskiy.telegramclone.ui.regEnter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.borshevskiy.telegramclone.R
import com.borshevskiy.telegramclone.databinding.FragmentEnterCodeBinding
import com.borshevskiy.telegramclone.utils.AppTextWatcher
import com.borshevskiy.telegramclone.utils.showToast

class EnterCodeFragment : Fragment() {

    private var _binding: FragmentEnterCodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterCodeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerInputCode.addTextChangedListener(AppTextWatcher {
            if (binding.registerInputCode.text.length == 6) {
                codeVerification()
            }
        })
    }

    private fun codeVerification() {
        showToast("Ok")
        findNavController().navigate(R.id.nav_chat)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}