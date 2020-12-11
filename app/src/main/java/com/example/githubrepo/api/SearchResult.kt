package com.example.githubrepo.api

import com.example.githubrepo.models.Repo

data class SearchResult(val items: List<Repo>)  // what we get back from query