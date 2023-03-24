package org.techtown.shoppi_android.ui.common.rvadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techtown.shoppi_android.databinding.ItemCategoryPromotionBinding
import org.techtown.shoppi_android.model.Product
import org.techtown.shoppi_android.ui.common.ProductClickListener

class PromotionAdapter(private val clickListener: ProductClickListener) :
    ListAdapter<Product, PromotionAdapter.PromotionViewHolder>(ProductDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PromotionViewHolder {
        val binding =
            ItemCategoryPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PromotionViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
    // inner 처리 ProductClickListener 구현체 공유를 위한
    inner class PromotionViewHolder(
        private val binding: ItemCategoryPromotionBinding,
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(product: Product) {
            // data binding
            binding.product = product
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }


}


class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}