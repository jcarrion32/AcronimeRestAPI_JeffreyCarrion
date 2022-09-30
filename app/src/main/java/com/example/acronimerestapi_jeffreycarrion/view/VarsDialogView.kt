package com.example.acronimerestapi_jeffreycarrion.view

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.acronimerestapi_jeffreycarrion.data.model.AbbreviationItem
import com.example.acronimerestapi_jeffreycarrion.databinding.VariationListBinding

class VarsDialogView(
    context: Context
) : ConstraintLayout(context) {
    private val binding = VariationListBinding.inflate(
        LayoutInflater.from(context), this, false
    )
    private val newAdapter = Adapter()
    private val builder = AlertDialog.Builder(context).create()

    fun buildVarsDialogView(list: List<AbbreviationItem>) {

        with(builder) {
            binding.apply {
                rvVarsList.apply {
                    adapter = newAdapter
                    newAdapter.setNewList(list)
                }
                btnDismiss.setOnClickListener { dismiss() }
            }
            setView(binding.root)
            show()
        }
    }

    fun dismiss() {
        builder.dismiss()
    }
}