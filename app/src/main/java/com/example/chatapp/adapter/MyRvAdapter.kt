package com.example.chatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ItemRvBinding
import com.example.chatapp.models.User
import com.squareup.picasso.Picasso

class MyRvAdapter(var list: ArrayList<User>, val rvAction: RvAction): RecyclerView.Adapter<MyRvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding): RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user: User){
            itemRvBinding.tvName.text = user.displayname
            Picasso.get().load(user.photoUrl).into(itemRvBinding.rasm)
            itemRvBinding.root.setOnClickListener{
                rvAction.onClick(user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
    interface RvAction{
        fun onClick(
            user:User
        )
    }
}