package org.techtown.shoppi_android.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techtown.shoppi_android.model.Banner
import org.techtown.shoppi_android.databinding.ItemHomeBannerBinding

class HomeBannerAdapter :
    ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallBack()) {

    private lateinit var binding: ItemHomeBannerBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        binding = ItemHomeBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeBannerViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: HomeBannerViewHolder,
        position: Int
    ) {// holder 레이아웃, List[position] 데이터

        holder.bind(getItem(position)) // 레이아웃에  List[position] 데이터를 바인딩 시킨다.


    }

    class HomeBannerViewHolder(private val binding: ItemHomeBannerBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(banner: Banner) {
            binding.banner = banner
            binding.executePendingBindings()
        }
    }
}


class BannerDiffCallBack : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
}