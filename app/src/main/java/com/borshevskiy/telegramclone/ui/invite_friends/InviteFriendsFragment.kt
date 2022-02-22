package com.borshevskiy.telegramclone.ui.invite_friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.borshevskiy.telegramclone.databinding.FragmentInviteFriendsBinding

class InviteFriendsFragment : Fragment() {

    private var _binding: FragmentInviteFriendsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInviteFriendsBinding.inflate(inflater, container, false)
        binding.textInviteFriends.text = "InviteFriendsFragment"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}