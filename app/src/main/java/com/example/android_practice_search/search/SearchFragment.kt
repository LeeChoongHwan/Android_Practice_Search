package com.example.android_practice_search.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice_search.constants.KakaoKey
import com.example.android_practice_search.databinding.FragmentSearchBinding
import com.example.android_practice_search.retrofit.ImageModel
import com.example.android_practice_search.retrofit.RetrofitClient.apiService
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

            if (searchText.isNotEmpty()) {
                searchResultList.clear()
                listAdapter.clearItems()
                getImageResult(searchText)
            } else {

            }

        }
    }

    private fun getImageResult(searchText: String) {
        apiService.getImage(KakaoKey.AUTH_HEADER, searchText, "recency", 1, 60)?.enqueue(object :
            Callback<ImageModel?> {
            override fun onResponse(call: Call<ImageModel?>, response: Response<ImageModel?>) {
                for (img in response.body()?.imageDocument!!) {
                    val imageUrl = img.thumbnailUrl
                    val title = img.displaySiteName
                    val dateTime = img.datetime

                    searchResultList.add(SearchModel(imageUrl, title, dateTime))

                }
                listAdapter.addItems(searchResultList)
            }

            override fun onFailure(call: Call<ImageModel?>, t: Throwable) {
                Log.d("result", "$t")
            }

        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

