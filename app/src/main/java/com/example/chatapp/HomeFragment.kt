package com.example.chatapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.chatapp.adapter.MyRvAdapter
import com.example.chatapp.databinding.FragmentHomeBinding
import com.example.chatapp.models.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var database: FirebaseDatabase
    lateinit var reference: DatabaseReference
    lateinit var MyRvAdapter : MyRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        database=FirebaseDatabase.getInstance()
        reference=database.getReference("user")



        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User>()
                val children = snapshot.children
                for (child in children){
                    val user = child.getValue(User::class.java)
                    if (user != null) {
                        list.add(user)
                    }
                }
                Log.d(TAG, "onDataChange: $list")
                MyRvAdapter = MyRvAdapter(list,object : MyRvAdapter.RvAction{
                    override fun onClick(user: User) {
                        findNavController().navigate(R.id.massageFragment, bundleOf("keyuser" to user))
                    }

                })
                binding.tv.adapter = MyRvAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

        })


        return binding.root
    }
}