package com.example.android_practice_search.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice_search.constants.Constants
import com.example.android_practice_search.constants.KakaoKey
import com.example.android_practice_search.databinding.FragmentSearchBinding
import com.example.android_practice_search.retrofit.ImageModel
import com.example.android_practice_search.retrofit.retrofitClient
import com.example.android_practice_search.retrofit.retrofitClient.apiService
import com.example.android_practice_search.retrofit.retrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val listAdapter by lazy {
        SearchListAdapter()
    }
    private val searchResultList = arrayListOf<SearchModel>()

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        binding.recyclerView.adapter = listAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        binding.searchButton.setOnClickListener {
            val searchText = binding.searchEdittext.text.toString()

            if(searchText.isNotEmpty()) {
                getImageResult(searchText)
            }
            else {

            }

        }
    }

    private fun getImageResult(searchText: String) {
//        val response = apiService.getImage(KakaoKey.AUTH_HEADER, searchText, "recency", 1, 80)
//        response.imageDocument.forEach { document ->
//            val imageUrl = document.thumbnailUrl
//            val title = document.displaySiteName
//            val dateTime = document.datetime
//
//            searchResultList.add(SearchModel(imageUrl, title, dateTime))
//        }
//
//        listAdapter.addItems(searchResultList)
        apiService.getImage(Constants.KAKAO_BASE_URL, searchText, "recency", 1, 80)?.enqueue(object :
            Callback<ImageModel?> {
            override fun onResponse(call: Call<ImageModel?>, response: Response<ImageModel?>) {
                response.body()?.imageDocument?.forEach { document ->
                    val imageUrl = document.thumbnailUrl
                    val title = document.displaySiteName
                    val dateTime = document.datetime

                    searchResultList.add(SearchModel(imageUrl, title, dateTime))
                    Log.d("result", imageUrl)
                    listAdapter.addItems(searchResultList)
                }
            }

            override fun onFailure(call: Call<ImageModel?>, t: Throwable) {
                Log.d("result", "fail")
            }

        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

