package org.techtown.shoppi_android.ui.common

import android.graphics.Paint
import android.text.style.StrikethroughSpan
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.techtown.shoppi_android.R
import java.text.DecimalFormat
import kotlin.math.roundToInt

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")// 3자리 마다 콤마
    view.text = view.context.getString(R.string.unit_discount_currency, decimalFormat.format(price))
}



@BindingAdapter("priceAmount", "discountRate")
fun applyPriceDiscountRate(view: TextView, price: Int, discountRate: Int) {
    val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
    applyPriceFormat(view, discountPrice)
}


@BindingAdapter("priceAmount", "strikeThrough")
fun applyPriceAndStrikeStyle(view: TextView, price: Int, strikeThrough: Boolean) {
    applyPriceFormat(view, price)
    if(strikeThrough) {
        view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    }
}
