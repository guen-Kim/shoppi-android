package org.techtown.shoppi_android.ui.common

import androidx.recyclerview.widget.DiffUtil
import org.techtown.shoppi_android.model.Category


class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem

    }
}