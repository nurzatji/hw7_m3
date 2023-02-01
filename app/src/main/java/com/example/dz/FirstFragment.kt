package com.example.dz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.dz.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_FAM = "fam"
        const val KEY_IMG = "Img"


    }

    private lateinit var binding: FragmentFirstBinding
    private var nameList = ArrayList<Names>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        val adapter = NameAdapter(nameList, this::onClick)
        binding.recyclerView.adapter = adapter

    }


    private fun loadData() {
        nameList = ArrayList<Names>()
        nameList.add(Names("Alive", "Rick Sanchez","https://i.pinimg.com/originals/0d/82/2c/0d822cc58bf00ddca38ea288b08a6bed.jpg"))
        nameList.add(Names("Alive", "Morty Smith", "https://i.pinimg.com/736x/66/83/da/6683da6fc8f5321d2dcb6023e03df4fb.jpg"))
        nameList.add(Names("Dead", "Albert Einstein", "https://i.pinimg.com/564x/e6/a4/c6/e6a4c69e6fa0adc901e6dc1228070a78.jpg"))
        nameList.add(Names("Alive", "Jerry Smith","https://comicvine.gamespot.com/a/uploads/original/6/66303/4472081-tumblr_n04lnrmooh1rfbbc6o1_1280.png"))
    }


    private fun onClick(position: Int) {

        val adapter = NameAdapter(nameList, this::onClick)
       binding.recyclerView.adapter = adapter
       nameList.apply {
           findNavController().navigate(
              R.id.secondFragment, bundleOf(
                  KEY_NAME to nameList[position].name,
                  KEY_FAM to nameList[position].fam, KEY_IMG to nameList[position].photo
              )
         )
    }

    }
}




