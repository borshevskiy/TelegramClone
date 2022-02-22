package com.borshevskiy.telegramclone.ui.createSecretChat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.borshevskiy.telegramclone.databinding.FragmentCreateSecretChatBinding

class CreateSecretChatFragment : Fragment() {

    private var _binding: FragmentCreateSecretChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateSecretChatBinding.inflate(inflater, container, false)
        binding.textCreateSecretChat.text = "CreateSecretChatFragment"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}