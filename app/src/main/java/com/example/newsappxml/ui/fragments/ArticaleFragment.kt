package com.example.newsappxml.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.newsappxml.R
import com.example.newsappxml.databinding.FragmentArticaleBinding
import com.example.newsappxml.databinding.NewsActivityBinding
import com.example.newsappxml.ui.NewsActivity
import com.example.newsappxml.ui.ViewModel.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticaleFragment : Fragment(R.layout.fragment_articale) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticaleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticaleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticaleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourite(article)
            Snackbar.make(view, "added to favourite", Snackbar.LENGTH_SHORT).show()
        }
    }
}