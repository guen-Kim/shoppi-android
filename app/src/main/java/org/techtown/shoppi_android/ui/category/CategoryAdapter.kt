package org.techtown.shoppi_android.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.techtown.shoppi_android.databinding.ItemCategoryBinding
import org.techtown.shoppi_android.databinding.ItemHomeBannerBinding
import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.ui.home.HomeBannerAdapter

class CategoryAdapter:
    androidx.recyclerview.widget.ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallBack())  {


    private lateinit var  binding : ItemCategoryBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryViewHolder {
        binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryAdapter.CategoryViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position)) // 레이아웃에  List[position] 데이터를 바인딩 시킨다.
    }



    class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root) {


        fun bind(category: Category){
            binding.category = category
            binding.executePendingBindings()
        }

    }


}



class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem

    }
}