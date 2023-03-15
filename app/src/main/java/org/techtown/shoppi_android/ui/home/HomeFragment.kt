package org.techtown.shoppi_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator

import org.techtown.shoppi_android.R
import org.techtown.shoppi_android.databinding.FragmentHomeBinding
import org.techtown.shoppi_android.ui.common.ViewModelFactory

class HomeFragment : Fragment() {


    private val homeViewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

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


    }

    private fun setToolbar() {
        homeViewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title

        }
    }

    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            // 어뎁터 초기화 후 topBanner observe
            adapter = HomeBannerAdapter().apply {
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
}


