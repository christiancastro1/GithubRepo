package com.example.githubrepo.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//create a top level functions: are funcitons which exist outside any enclosing classs

fun createGitHubApiService():GitHubApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(GitHubApiService::class.java)

}
interface GitHubApiService {
    @GET("/search/repositories")//indicates this will generate a GET request to the api endpoint
    fun searchRepositories(
        @Query("q")query: String,
        @Query("sort") sort: String = "stars",
        @Query("order")order: String = "desc"
    ): Call<SearchResult>


}
