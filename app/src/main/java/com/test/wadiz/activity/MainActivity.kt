package com.test.wadiz.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.google.android.material.tabs.TabLayout
import com.test.wadiz.BuildConfig
import com.test.wadiz.R
import com.test.wadiz.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private lateinit var navController: NavController
    private val binding: ActivityMainBinding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setSupportActionBar(binding.toolbar)

        BuildConfig.CUSTOM_API_KEY

        /**
         * 검색 API 예제 코드.
         * 샘플의 모든 코드는 원하는대로 변경, 수정 가능합니다.
         */
        lifecycleScope.launch {
            // val body = RequestRepository().requestSearch(keyword = "고양이")
            //Timber.d(body.toString())
        }
    }

    private fun initUI() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AllFragment())
            .addToBackStack(null)
            .commit()

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceType")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "${tab?.text}", Toast.LENGTH_SHORT).show()
                when (tab?.text) {
                    "전체" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, AllFragment())
                            .addToBackStack(null)
                            .commit()
                    }
                    "펀딩" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, FundingFragment())
                            .addToBackStack(null)
                            .commit()

                    }
                    "스토어" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, StoreFragment())
                            .addToBackStack(null)
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.ivSearch.setOnClickListener {
            binding.tabs.visibility = View.VISIBLE
            binding.container.visibility = View.VISIBLE
        }
    }

    /**
     * URL을 넘겨 웹브라우져 실행.
     */
    fun openWebView(url: String) = startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)))
}