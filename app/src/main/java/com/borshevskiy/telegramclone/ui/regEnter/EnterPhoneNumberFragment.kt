package com.borshevskiy.telegramclone.ui.regEnter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.borshevskiy.telegramclone.R
import com.borshevskiy.telegramclone.databinding.FragmentEnterPhoneNumberBinding
import com.borshevskiy.telegramclone.utils.showToast

class EnterPhoneNumberFragment : Fragment() {

    private var _binding: FragmentEnterPhoneNumberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterPhoneNumberBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerBtnNext.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
        if (binding.registerInputPhoneNumber.text.isEmpty()) {
            showToast(R.string.register_toast_enter_phone.toString())
        } else {
            findNavController().navigate(R.id.nav_enterCode)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}