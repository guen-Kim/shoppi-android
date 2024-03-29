package org.techtown.shoppi_android.ui.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.shoppi_android.common.KEY_PRODUCT_ID
import org.techtown.shoppi_android.databinding.FragmentProductDetailBinding
import org.techtown.shoppi_android.ui.common.EventObserver

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    private val viewModel: ProductDetailViewModel by viewModels() // Injection

    lateinit var binding: FragmentProductDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 레이아웃 인플레이트
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        // 루트 뷰 반환
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fragment lifecycler로 초기화
        binding.lifecycleOwner = viewLifecycleOwner

        //databinding
        binding.viewModel = viewModel

        setNavigation()

        // productId 전달 받음
        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            // 전달 받은 id 값으로 api path 요청
            setLayout(productId)
        }

        setAddCart()

    }

    private fun setAddCart() {

        viewModel.addCartEvent.observe(viewLifecycleOwner, EventObserver {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("장바구니에 상품이 담겼습니다.")
                .setPositiveButton("확인") { dialog, which ->
                }.show()
        })
    }


    private fun setNavigation() {
        binding.toobalProductDetail.setNavigationOnClickListener {
            // 이전화면으로 돌아가기
            findNavController().navigateUp()
        }

    }


    private fun setLayout(productId: String) {
        // ProductDetail 데이터 로드
        viewModel.loadProductData(productId)
        // 어댑터 생성
        val descriptionAdapter = ProductDescriptionAdapter()
        // 리사이클러뷰 어댑터 참조
        binding.rvProductDetail.adapter = descriptionAdapter
        //live data product 구독
        viewModel.product.observe(viewLifecycleOwner) { product ->
            // data binding
            binding.product = product
            // recyclerview adapter 에 데이터 전달
            descriptionAdapter.submitList(product.descriptions)
        }

    }
}