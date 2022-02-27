package com.borshevskiy.telegramclone.ui.regEnter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.borshevskiy.telegramclone.R
import com.borshevskiy.telegramclone.databinding.FragmentEnterCodeBinding
import com.borshevskiy.telegramclone.utils.AUTH
import com.borshevskiy.telegramclone.utils.AppTextWatcher
import com.borshevskiy.telegramclone.utils.showToast
import com.google.firebase.auth.PhoneAuthProvider

class EnterCodeFragment : Fragment() {

    private var _binding: FragmentEnterCodeBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<EnterCodeFragmentArgs>()

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
        val credential = PhoneAuthProvider.getCredential(
            args.currentCode.id,
            binding.registerInputCode.text.toString()
        )
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showToast("Добро пожаловаться")
                findNavController().navigate(R.id.nav_chat)
            } else showToast(task.exception?.message.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}