package org.techtown.shoppi_android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

import org.json.JSONObject

class HomeFragment : Fragment() {

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


        val appbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val appbarLogo = view.findViewById<ImageView>(R.id.toolbar_home_icon)

        val assetsLoader = AssetsLoader()
        val homeData = assetsLoader.getJsonString(this.requireContext(), "home.json")
        Log.d("homeData", homeData ?: "")



        if (homeData != null) {
            val jsonData = JSONObject(homeData)
            val title = jsonData.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            val titleOb = Title(text, iconUrl)

            appbarTitle.text = titleOb.text
            Glide.with(this)
                .load(iconUrl)
                .into(appbarLogo);

        }


    }
}
