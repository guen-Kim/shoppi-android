package org.techtown.shoppi_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

import org.techtown.shoppi_android.R
import org.techtown.shoppi_android.ui.common.ViewModelFactory

class HomeFragment : Fragment() {


    private val homeViewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        ) // hostActivity가 모두 구성된 이후에 inflate 되어야함. false로 생성시점 늦춤


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)



        homeViewModel.title.observe(viewLifecycleOwner) { title ->
            toolbarTitle.text = title.text
            Glide.with(this)
                .load(title.iconUrl)
                .into(toolbarIcon);
        }
/*
            homeViewModel.topBanner.observe(viewLifecycleOwner) { banners ->
                viewpager.adapter = HomeBannerAdapter().apply {
                    submitList(banners)

                }
            }*/

        // 어뎁터 초기화 후 topBanner observe
        viewpager.adapter = HomeBannerAdapter().apply {
            homeViewModel.topBanner.observe(viewLifecycleOwner) { banners ->
                viewpager.adapter = HomeBannerAdapter().apply {
                    submitList(banners)
                }


                val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
                val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
                val screenWidth = resources.displayMetrics.widthPixels
                val offset = screenWidth - pageWidth - pageMargin
                // 다음 페이지 위치
                viewpager.offscreenPageLimit = 3
                viewpager.setPageTransformer { page, position ->
                    page.translationX = position * -offset
                }

                TabLayoutMediator(
                    viewpagerIndicator, viewpager
                ) { tab, position -> }.attach()


            }
        }
    }
}
