package com.example.latfragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.latfragmentkotlin.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    val question = arrayOf("Kamu lebih suka KOPI panas atau dingin?",
                           "Kamu lebih suka SUSU panas atau dingin?",
                           "Kamu lebih suka TEH panas atau dingin?",
                           "Kamu lebih suka mandi dengan air panas atau dingin?",
                            "Kamu lebih suka makanan panas atau dingin?")

    var panas_score = 0
    var dingin_score = 0
    var current_question = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title="Jawab Pertanyaan"

        val binding: FragmentQuizBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        binding.textQuiz.text = question[0]

        binding.buttonPanas.setOnClickListener {
            panas_score++
            nextQuestion(binding)
        }

        binding.buttonDingin.setOnClickListener {
            dingin_score++
            nextQuestion(binding)
        }

        return binding.root
    }

    fun nextQuestion(binding: FragmentQuizBinding){
        current_question++

        if(current_question <question.size){
            binding.textQuiz.text = question[current_question]
//            Toast.makeText(context, "berhasil! panas : " + panas_score + " / dingin : " + dingin_score, Toast.LENGTH_SHORT).show()
        }
        else{
            var result = ""
            if(panas_score >= 1 && dingin_score >= 1){
                result = "kamu suka panas dan dingin"
            } else if (panas_score < 1) {
                result = "kamu pecinta dingin"
            } else {
                result ="kamu pecinta panas"
            }
            requireView().findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToFinishFragment(result))
        }
    }
}