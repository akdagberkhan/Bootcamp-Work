package com.merttoptas.retrofittutorial.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.retrofittutorial.data.model.Users
import com.merttoptas.retrofittutorial.databinding.ItemUsersLayoutBinding

class UserAdapter() : ListAdapter<Users, UserAdapter.UserViewHolder>(UsersDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUsersLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(private val binding: ItemUsersLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(users: Users) {
            binding.tvNameValue.text = users.name
            binding.tvMailValue.text = users.email
            binding.executePendingBindings()
        }
    }

    class UsersDiffUtil : DiffUtil.ItemCallback<Users>() {
        override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
            return oldItem == newItem
        }
    }
}