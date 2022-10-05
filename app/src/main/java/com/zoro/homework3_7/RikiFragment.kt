package com.zoro.homework3_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.zoro.homework3_7.databinding.FragmentRikiBinding
import com.zoro.homework3_7.databinding.ItemRiciBinding


class RikiFragment : Fragment() {
    private val RiciLIst=ArrayList<Parametr>()
    private lateinit var binding:FragmentRikiBinding
    private  lateinit var  item:ItemRiciBinding
    private lateinit var  adapterMusic: RickAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRikiBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = RickAdapter(RiciLIst,this::onClick)
        binding.rici.adapter=adapter
    }

     fun loadData() {
         RiciLIst.add(Parametr(R.drawable.img,"Alive","Rick Sanchez"))
         RiciLIst.add(Parametr(R.drawable.img_6,"Alive","Morty Smith"))
         RiciLIst.add(Parametr(R.drawable.img_4,"Alive"," Albert Einstein"))
         RiciLIst.add(Parametr(R.drawable.img_7,"Alive"," Jerry Smith"))
    }
    private fun onClick(position:Int){
        val bundle = Bundle()
        bundle.putSerializable("key",RiciLIst[position])
        findNavController().navigate(R.id.blankFragment,bundle)
    }



}