package com.merttoptas.retrofittutorial.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.merttoptas.retrofittutorial.R
import com.merttoptas.retrofittutorial.data.model.DataState
import com.merttoptas.retrofittutorial.databinding.FragmentUserBinding
import com.merttoptas.retrofittutorial.ui.posts.adapter.OnPostClickListener
import com.merttoptas.retrofittutorial.ui.users.adapter.UserAdapter
import com.merttoptas.retrofittutorial.ui.users.viewmodel.UsersViewEvent
import com.merttoptas.retrofittutorial.ui.users.viewmodel.UsersViewModel

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private val viewModel by viewModels<UsersViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.userLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success -> {
                    it.data?.let { safeData ->
                        binding.rvUsersList.adapter = UserAdapter().apply {
                            submitList(safeData)
                        }
                    } ?: run {
                        Toast.makeText(requireContext(), "No data", Toast.LENGTH_SHORT).show()
                    }
                }
                is DataState.Error -> {
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_LONG).show()
                }
                is DataState.Loading -> {
                }
            }
        }

        viewModel.eventStateLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is UsersViewEvent.ShowMessage -> {}
                is UsersViewEvent.NavigateToDetail -> {}
            }
        }
    }

}