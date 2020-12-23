package me.alberto.findcard.screen.findcard.view

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.alberto.findcard.R
import me.alberto.findcard.databinding.FragmentFindCardBinding


class FindCardFragment : Fragment() {

    private lateinit var setRightOut: AnimatorSet
    private lateinit var setLeftIn: AnimatorSet
    private var backCardVisible = false
    private lateinit var binding: FragmentFindCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindCardBinding.inflate(inflater, container, false)

        initCardAnimation()
        setClickListeners()

        return binding.root
    }

    private fun setClickListeners() {
        binding.frontCard.setOnClickListener { flipCard() }
        binding.backCard.setOnClickListener { flipCard() }
    }


    private fun flipCard() {
        if (!backCardVisible) {
            setRightOut.setTarget(binding.frontCard)
            setLeftIn.setTarget(binding.backCard)
            setRightOut.start()
            setLeftIn.start()
            backCardVisible = true
        } else {
            setRightOut.setTarget(binding.backCard)
            setLeftIn.setTarget(binding.frontCard)
            setRightOut.start()
            setLeftIn.start()
            backCardVisible = false
        }
    }

    private fun initCardAnimation() {
        setRightOut =
            AnimatorInflater.loadAnimator(requireContext(), R.animator.out_animation) as AnimatorSet
        setLeftIn =
            AnimatorInflater.loadAnimator(requireContext(), R.animator.in_animation) as AnimatorSet

        val distance = 8000
        val scale = resources.displayMetrics.density * distance
        binding.frontCard.cameraDistance = scale
        binding.backCard.cameraDistance = scale
    }

}