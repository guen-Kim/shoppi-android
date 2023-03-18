package org.techtown.shoppi_android.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.shoppi_android.databinding.FragmentCategoryDetailBinding

class CategoryDetailFragment: Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding

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

        // bundle 객체에 전달된 데이터 조회하기
        val categoryId = requireArguments().getString("KEY_CATEGORY_ID")
        val categoryLabel = requireArguments().getString("KEY_CATEGORY_LABEL")

        binding.toolbarCategoryDetail.title = categoryLabel

    }

}