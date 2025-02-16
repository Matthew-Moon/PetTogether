package com.matthew.pettogether.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matthew.pettogether.domain.repository.CategoryCodeRepository
import com.matthew.pettogether.domain.usecase.GetCategoryCodeUseCase
//import com.matthew.pettogether.domain.usecase.GetCategoryCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoryCodeRepository: CategoryCodeRepository,
    private val getCategoryCodeUseCase: GetCategoryCodeUseCase,
) : ViewModel() {

    fun test() {
        viewModelScope.launch {
            Timber.d("getCategoryCodeUseCase() ==> ${getCategoryCodeUseCase()}")

//            val result = categoryCodeRepository.getCategoryCode()

//            Timber.d("result ==> ${result.response.body.items}")
//            getCategoryCodeUseCase()

        }
    }
}