package com.classwork.ur83dz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.classwork.ur83dz.databinding.FragmentMainBinding
import com.classwork.ur83dz.databinding.FragmentResaltBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResaltBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResaltBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val model = it.getSerializable("start") as Series
            binding.nameTv.text = model.name
            binding.statusTv.text = model.status
            Glide.with(binding.posterImg).load(model.img).into(binding.posterImg)
        }
    }
}