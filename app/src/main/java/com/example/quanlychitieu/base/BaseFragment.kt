package com.example.quanlychitieu.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quanlychitieu.ui.MainActivity
import com.google.android.material.appbar.MaterialToolbar

abstract class BaseFragment : Fragment() {
    val mainActivity: MainActivity by lazy {
        activity as MainActivity
    }
    var onBackNavigation: (() -> Unit)? = null
    var hideFragmentToThis: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideFragmentToThis?.invoke()
        init()
        initData()
        initAction()
        onBackNavigation = {
            init()
            initData()
            initAction()
        }
    }


    open fun setToolbar(view: MaterialToolbar, onclick: (() -> Unit)? = null) {
        view.setNavigationOnClickListener {
            mainActivity.onBackPressed()
            onclick?.invoke()
        }
    }


    abstract fun init()
    abstract fun initData()
    abstract fun initAction()


    fun finish() {
        requireActivity().finish()
    }


    fun showLoading() {

    }

    fun hideLoading() {

    }

}