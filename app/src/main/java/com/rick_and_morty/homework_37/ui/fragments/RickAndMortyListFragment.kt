package com.rick_and_morty.homework_37.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rick_and_morty.homework_37.ui.model.RickAndMortyCharacter
import com.rick_and_morty.homework_37.R
import com.rick_and_morty.homework_37.databinding.FragmentRickAndMortyListBinding
import com.rick_and_morty.homework_37.ui.adapters.CharactersAdapter

class RickAndMortyListFragment : Fragment() {
    private lateinit var binding: FragmentRickAndMortyListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val charactersAdapter =
            CharactersAdapter(
                listOf(
                    RickAndMortyCharacter(R.drawable.rick, "Alive", "Rick"),
                    RickAndMortyCharacter(R.drawable.morty, "Alive", "Morty"),
                    RickAndMortyCharacter(R.drawable.summer, "Alive", "Summer Smith"),
                    RickAndMortyCharacter(R.drawable.jerry, "Alive", "Jerry Smith"),
                    RickAndMortyCharacter(R.drawable.beth, "Alive", "Beth Smith"),
                ), this::onItemClick
            )
        binding.rvCharacters.adapter = charactersAdapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun onItemClick(character: RickAndMortyCharacter) {
        findNavController().navigate(
            RickAndMortyListFragmentDirections.actionRickAndMortyListFragmentToItemFragment(
                character
            )
        )
    }
}