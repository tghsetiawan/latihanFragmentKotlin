package com.example.latfragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.latfragmentkotlin.databinding.FragmentIntroBinding
import androidx.navigation.Navigation

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title="Game Panas Atau Dingin"

        val binding: FragmentIntroBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false)

        binding.btnMulai.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_introFragment_to_quizFragment)
        )

        return binding.root
    }
}