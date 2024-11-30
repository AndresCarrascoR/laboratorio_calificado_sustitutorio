package com.carrasco.andres.laboratoriocalificado03

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carrasco.andres.laboratoriocalificado03.models.Post

class PostAdapter(
    private val context: Context,
    private val posts: List<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtUserId: TextView = view.findViewById(R.id.txtUserId)
        val txtId: TextView = view.findViewById(R.id.txtId)
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
        val txtBody: TextView = view.findViewById(R.id.txtBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.txtUserId.text = "User ID: ${post.userId}"
        holder.txtId.text = "ID: ${post.id}"
        holder.txtTitle.text = post.title
        holder.txtBody.text = post.body

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:+51925137361")
                putExtra("sms_body", post.title)
            }
            context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:victor.saico@tecsup.edu.pe")
                putExtra(Intent.EXTRA_SUBJECT, "Post Body")
                putExtra(Intent.EXTRA_TEXT, post.body)
            }
            context.startActivity(intent)
            true
        }
    }

    override fun getItemCount(): Int = posts.size
}