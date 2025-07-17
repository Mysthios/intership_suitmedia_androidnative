package com.example.intershipsuitmediaandroidnative.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intershipsuitmediaandroidnative.data.model.User
import com.example.intershipsuitmediaandroidnative.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    private val userRepository = UserRepository()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser.asStateFlow()

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    private var currentPage = 1
    private var hasMoreData = true

    fun setName(name: String) {
        _name.value = name
    }

    fun selectUser(user: User) {
        _selectedUser.value = user
    }

    fun isPalindrome(text: String): Boolean {
        val cleaned = text.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
        return cleaned == cleaned.reversed()
    }

    fun loadUsers(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) {
                _isRefreshing.value = true
                currentPage = 1
                hasMoreData = true
            } else {
                _isLoading.value = true
            }

            try {
                val response = userRepository.getUsers(currentPage, 10)
                if (isRefresh) {
                    _users.value = response.data
                } else {
                    _users.value = _users.value + response.data
                }

                hasMoreData = response.data.size == 10
                currentPage++
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
                _isRefreshing.value = false
            }
        }
    }

    fun loadMoreUsers() {
        if (!_isLoading.value && hasMoreData) {
            loadUsers()
        }
    }

    init {
        loadUsers()
    }
}