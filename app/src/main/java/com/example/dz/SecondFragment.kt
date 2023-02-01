package com.example.dz

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dz.FirstFragment.Companion.KEY_FAM
import com.example.dz.FirstFragment.Companion.KEY_IMG
import com.example.dz.FirstFragment.Companion.KEY_NAME

import com.example.dz.databinding.FragmentSecondBinding
import kotlin.properties.Delegates

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {
        arguments?.apply {
            val username = getString(KEY_NAME)
            val password = getString(KEY_FAM)
            val img = getString(KEY_IMG)
            binding.apply {
                tvName.text = username
                tvFam.text = password
                Glide.with(binding.imgPhoto).load(img).into(binding.imgPhoto)
            }
        }
    }
}

//const val KEY_NAME = "name"
//const val KEY_FAM = "fam"
//const val KEY_IMG =




//binding.tvName.text = item.name
//Glide.with(binding.imgPhoto).load(item.photo).into(binding.imgPhoto)
//binding.tvFam.text = item.fam
//}
