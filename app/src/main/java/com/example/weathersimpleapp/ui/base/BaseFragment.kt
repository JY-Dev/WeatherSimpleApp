package com.example.weathersimpleapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment.findNavController

/**
 * T : 데이터 바인딩 객체
 */
abstract class BaseFragment<T : ViewDataBinding> constructor(
    @LayoutRes private val contentLayoutId: Int
) : Fragment() {

    private lateinit var _binding: T
    protected val binding: T
        get() = _binding

    protected inline fun binding(block: T.() -> Unit): T =
        binding.apply(block)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, contentLayoutId, container, false)
        return _binding.root
    }

    protected fun String.showShortToast() =
        Toast.makeText(requireContext(),this,Toast.LENGTH_SHORT).show()

    protected fun NavDirections.navigate(){
        findNavController(this@BaseFragment).navigate(this)
    }
}