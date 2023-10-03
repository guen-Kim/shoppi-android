package org.techtown.shoppi_android.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techtown.shoppi_android.databinding.ItemCategoryTopSellingSectionBinding
import org.techtown.shoppi_android.model.TopSelling


class CategoryTopSellingSectionAdapter:
    ListAdapter<TopSelling, CategoryTopSellingSectionAdapter.CategoryTopSellingSectionViewHolder>(TopSellingSectionDiffUtill()){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryTopSellingSectionViewHolder {
        val  binding = ItemCategoryTopSellingSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryTopSellingSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryTopSellingSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class CategoryTopSellingSectionViewHolder(private val binding: ItemCategoryTopSellingSectionBinding): RecyclerView.ViewHolder(binding.root) {

        //nested Adapter
        private val nestedAdapter = CategoryTopSellingItemAdapter()

        init{
            binding.rvCategorySection.adapter = nestedAdapter
        }


        fun bind(topSelling: TopSelling) {
            binding.title = topSelling.title
            binding.executePendingBindings()
            nestedAdapter.submitList(topSelling.categories)

        }
    }
}


class TopSellingSectionDiffUtill: DiffUtil.ItemCallback<TopSelling>() {
    override fun areItemsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TopSelling, newItem: TopSelling): Boolean {
        return oldItem == newItem

    }
}

