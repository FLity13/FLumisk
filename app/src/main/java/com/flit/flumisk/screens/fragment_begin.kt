package com.flit.flumisk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.flit.flumisk.R
import com.stericson.RootShell.*

class fragment_begin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_begin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val root_status = view.findViewById<TextView>(R.id.root_status)

        if (RootShell.isAccessGiven()) {
            //❌🟢🔴✅
            root_status.text = "Root-доступ : \uD83D\uDFE2"

        } else {
            root_status.text = "Root-доступ : \uD83D\uDD34"
        }

    }

}