package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder :RecyclerView.ViewHolder {
    constructor(@NonNull itemView: View) : super(itemView)

    @SuppressLint("UseSparseArrays")
    private val viewHashMap = HashMap<Int?, View>()

    @SuppressLint("unchecked")
    fun <T : View> getView(@IdRes id: Int): T {
        var view = viewHashMap.get(id)
        if (view == null){
            view = itemView.findViewById(id)
            viewHashMap.put(id,view)
        }

        return view as T
    }

    protected open fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }
}