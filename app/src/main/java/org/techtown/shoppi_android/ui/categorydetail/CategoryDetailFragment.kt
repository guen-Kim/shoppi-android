package org.techtown.shoppi_android.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.shoppi_android.databinding.FragmentCategoryDetailBinding
import org.techtown.shoppi_android.ui.common.ProductClickListener
import org.techtown.shoppi_android.ui.common.rvadapter.PromotionAdapter

@AndroidEntryPoint
class CategoryDetailFragment : Fragment(), ProductClickListener {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()

    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString("KEY_CATEGORY_LABEL")
        binding.toolbarCategoryDetail.title = categoryLabel
    }

    private fun setListAdapter() {
        val topSectionSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = SectionTitleAdapter()
        val promotionAdapter = PromotionAdapter(this)
        // ConcatAdapter, 할당 순으로 데이터 배치
        binding.rvCategoryDetail.adapter = ConcatAdapter(topSectionSectionAdapter,titleAdapter, promotionAdapter)
        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            promotionAdapter.submitList(promotions.items)
            titleAdapter.submitList(listOf(promotions.title))
        }
        viewModel.topSelling.observe(viewLifecycleOwner) { topSelling->
            topSectionSectionAdapter.submitList(listOf(topSelling))

        }

    }


    // ProductClickListener
    override fun onProductClick(productId: String) {
        //Todo ProductDetailFragment 이동 구현

    }


}