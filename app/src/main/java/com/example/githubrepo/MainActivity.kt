package com.example.githubrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.models.Repo
import com.example.githubrepo.models.reposlist.ReposAdapter

class MainActivity : AppCompatActivity() {

    private val adapter = ReposAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list: RecyclerView = findViewById(R.id.rvList)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        val sampleData = listOf(
            Repo("repo1") ,
            Repo("repo1"),
            Repo("repo1"),
            Repo("repo1"),
            Repo("repo1"),
            Repo("repo1"),
            Repo("repo1")
        )
        adapter.submitList(sampleData)

    }

}