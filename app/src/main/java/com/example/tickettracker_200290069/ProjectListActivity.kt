package com.example.tickettracker_200290069

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_project_list.*
import kotlinx.android.synthetic.main.item_projects.view.*

class ProjectListActivity : AppCompatActivity() {

    //Connect to db

    val db = FirebaseFirestore.getInstance()
    private var adapter: ProjectAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_list)

        //get recycler view to use linear layout
        project_recycler_view.layoutManager = LinearLayoutManager(this)

        //Database query
        val query = db.collection("projects").orderBy("project_name", Query.Direction.ASCENDING)

        //pass query results
        val options =
            FirestoreRecyclerOptions.Builder<Project>().setQuery(query, Project::class.java).build()
        adapter = ProjectAdapter(options)
        project_recycler_view.adapter = adapter

    }


    override fun onStart() {
        super.onStart()
        adapter!!.startListening()

    }

    override fun onStop() {
        super.onStop()
        if (adapter != null) {
            adapter!!.stopListening()
        }
    }


    //Create classes needed to bind data
    private inner class ProjectViewHolder internal constructor(private val view: View) :
        RecyclerView.ViewHolder(view) {

    }

    private inner class ProjectAdapter internal constructor(options: FirestoreRecyclerOptions<Project>) :
        FirestoreRecyclerAdapter<Project, ProjectViewHolder>(options) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
            //inflate item_projects.xml
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_projects, parent, false)
            return ProjectViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProjectViewHolder, position: Int, model: Project) {
            //populate project name and desc into the matching widgets
            holder.itemView.project_item_name.text = model.project_name
            holder.itemView.project_item_description.text = model.project_description
            holder.itemView.project_owner_name.text = model.project_owner


        }


    }
}