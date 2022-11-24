package com.rick_and_morty.homework_37.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rick_and_morty.homework_37.databinding.RickAndMortyItemBinding
import com.rick_and_morty.homework_37.ui.model.RickAndMortyCharacter

class CharactersAdapter(
    private val list: List<RickAndMortyCharacter>,
    private val onItemClick: (character: RickAndMortyCharacter) -> Unit
) :
    Adapter<CharactersAdapter.CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharactersViewHolder(
        RickAndMortyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class CharactersViewHolder(private val binding: RickAndMortyItemBinding) :
        ViewHolder(binding.root) {
        fun onBind(character: RickAndMortyCharacter) {
            binding.imCharacterAvatar.setImageResource(character.avatar)
            binding.tvCharacterStatus.text = character.status
            binding.tvCharacterName.text = character.name
        }

        init {
            binding.root.setOnClickListener {
                onItemClick(list[absoluteAdapterPosition])
            }
        }
    }
}