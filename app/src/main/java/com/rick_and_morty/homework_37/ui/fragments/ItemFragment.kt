package com.rick_and_morty.homework_37.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rick_and_morty.homework_37.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    private lateinit var binding: FragmentItemBinding
    private val args by navArgs<ItemFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imCharacterAvatar.setImageResource(args.character.avatar)
        binding.tvCharacterName.text = args.character.name
        binding.tvCharacterStatus.text = args.character.status
    }
}