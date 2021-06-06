package com.code.jumia.view

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.code.jumia.model.response.ErrorScreen
import com.code.jumia.view.BaseActivity
import com.code.jumia.view.util.BaseView

abstract class BaseFragment : Fragment() {
    override fun onDestroyView() {
        super.onDestroyView()
        if (activity != null && activity is BaseActivity && requireActivity().supportFragmentManager
                .backStackEntryCount > 0
        ) {
            (activity as BaseActivity).notifyFragmentsAppearing()
        }
    }

    open fun didAppear() {}
}