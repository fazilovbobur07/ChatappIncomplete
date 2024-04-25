package com.example.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.databinding.FragmentMassageBinding
import com.example.chatapp.models.MyMassage
import com.example.chatapp.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MassageFragment : Fragment() {
    lateinit var binding: FragmentMassageBinding
    lateinit var reference: DatabaseReference
    lateinit var database: FirebaseDatabase
    lateinit var aut: FirebaseAuth
    lateinit var user:User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMassageBinding.inflate(layoutInflater)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("massage")

        user = arguments?.getSerializable("keyuser") as User
        binding.btnSend.setOnClickListener{
            val id = reference.push().key
            val mymessage = MyMassage(id,aut.uid,user.UID,binding.edtWrite.text.toString())

            reference.child(id!!).setValue(mymessage)
        }


        return binding.root
    }
}