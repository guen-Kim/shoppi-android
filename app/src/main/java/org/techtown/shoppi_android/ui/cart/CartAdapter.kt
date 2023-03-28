package org.techtown.shoppi_android.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.shoppi_android.databinding.ItemCartSectionBinding
import org.techtown.shoppi_android.databinding.ItemCartSectionHeaderBinding
import org.techtown.shoppi_android.model.CartHeader
import org.techtown.shoppi_android.model.CartItem
import org.techtown.shoppi_android.model.CartProduct

private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_ITEM = 1


class CartAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // CartAdapter 에서 사용될 데이터들
    private val cartProduct = mutableListOf<CartProduct>()

    //2. viewType 에 따른 binding view 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // viewType 에 따라 inflate layout 구분
        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(
                ItemCartSectionHeaderBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> ItemViewHolder(ItemCartSectionBinding.inflate(inflater, parent, false))

        }
    }

    // 1. CartProduct 다운 캐스팅 타입 확인, onCreateViewHolder 두 번째 인자로 입력됨
    override fun getItemViewType(position: Int): Int {
        return when (cartProduct[position]) {
            is CartHeader -> VIEW_TYPE_HEADER
            is CartItem -> VIEW_TYPE_ITEM
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val item = cartProduct[position] as CartHeader // 타입변환
                holder.bind(item)
            }
            is ItemViewHolder -> {
                val item = cartProduct[position] as CartItem
                holder.bind(item)
            }

        }
    }

    override fun getItemCount(): Int {
        return cartProduct.size // item 개수 반환
    }

    /**
     * adapter data handling Algorithm
     * */
    fun submitHeaderAndItemList(items: List<CartItem>) {
        // brandName 으로 그룹핑
        val itemGroups =
            items.groupBy { it.brandName }// Map<brandName: String, item :List<CartItem>>
        val products = mutableListOf<CartProduct>()

        itemGroups.entries.forEach { entry ->
            val header = CartHeader(entry.key)
            products.add(header)
            products.addAll(entry.value)
        }
        // update DataSet
        cartProduct.addAll(products)
        notifyItemRangeInserted(cartProduct.size, products.size)
    }


    /**
     *  두 개의 viewHodel 사용
     * */
    class HeaderViewHolder(private val binding: ItemCartSectionHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: CartHeader) {
            // binidng data
            binding.header = header
            binding.executePendingBindings()
        }


    }

    class ItemViewHolder(private val binding: ItemCartSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}