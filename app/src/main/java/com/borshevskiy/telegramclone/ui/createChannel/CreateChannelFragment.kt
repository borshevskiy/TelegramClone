package com.borshevskiy.telegramclone.ui.createChannel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.borshevskiy.telegramclone.databinding.FragmentCreateChannelBinding

class CreateChannelFragment : Fragment() {

    private var _binding: FragmentCreateChannelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateChannelBinding.inflate(inflater, container, false)
        binding.textCreateChannel.text = "CreateChannelFragment"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}