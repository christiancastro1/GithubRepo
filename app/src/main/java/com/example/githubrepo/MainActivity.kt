package com.example.githubrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.api.SearchResult
import com.example.githubrepo.api.createGitHubApiService
import com.example.githubrepo.models.Repo
import com.example.githubrepo.repodetails.RepoDetailsActivity
import com.example.githubrepo.reposlist.ReposAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    val tag: String = "MainActivity"

    private lateinit var adapter: ReposAdapter  // lateinit allows us to delay the initialization until oncreate
    //since we want to use the context within the handling of the click

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ReposAdapter {repo->
            RepoDetailsActivity.startActivity(context = this, repo = repo)
        }

        val list: RecyclerView = findViewById(R.id.rvList)
        list.layoutManager = LinearLayoutManager(this)

        list.adapter = adapter
        val service = createGitHubApiService()
        service.searchRepositories("android").enqueue(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                val resp = response.body()?.items.orEmpty()
                adapter.submitList(resp)
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                Log.d(tag, "Error getting repositories")
            }

        })


    }

}