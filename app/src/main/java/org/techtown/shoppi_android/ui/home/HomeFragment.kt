package org.techtown.shoppi_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

import org.techtown.shoppi_android.R
import org.techtown.shoppi_android.common.KEY_PRODUCT_ID
import org.techtown.shoppi_android.databinding.FragmentHomeBinding
import org.techtown.shoppi_android.ui.common.rvadapter.PromotionAdapter
import org.techtown.shoppi_android.ui.categorydetail.SectionTitleAdapter
import org.techtown.shoppi_android.ui.common.EventObserver
import org.techtown.shoppi_android.ui.common.ProductClickListener


@AndroidEntryPoint
class HomeFragment : Fragment(), ProductClickListener {

    private val homeViewModel: HomeViewModel by viewModels() // injection

    // databinding 클래스
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setTopBanners()
        setNavigation()
        setListAdapter()


    }

    private fun setToolbar() {
        homeViewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title

        }
    }

    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            // 어뎁터 초기화 후 topBanner 구독
            adapter = HomeBannerAdapter(homeViewModel).apply {
                homeViewModel.topBanner.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }


            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin
            // 다음 페이지 위치
            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(
                binding.viewpagerHomeBannerIndicator, this
            ) { tab, position -> }.attach()
        }
    }// with

    private fun setNavigation() {
        homeViewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver { productId ->
            findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
                KEY_PRODUCT_ID to productId
            ))
        })
    }




    private fun setListAdapter() {
        // 어댑터 생성
        val titleAdapter = SectionTitleAdapter()

        val promotionAdapter = PromotionAdapter(this)

        // 어댑터 binding
        binding.rvHome.adapter = ConcatAdapter(titleAdapter, promotionAdapter)

        // 하단 데이터 구독
        homeViewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }

    // ProductClickListener
    override fun onProductClick(productId: String) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
            //Todo 임시값 처리
            KEY_PRODUCT_ID to "desk-1"
        ))
    }
}


