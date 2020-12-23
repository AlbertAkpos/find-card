package me.alberto.findcard.screen.findcard.view

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.createBalloon
import me.alberto.findcard.App
import me.alberto.findcard.R
import me.alberto.findcard.databinding.FragmentFindCardBinding
import me.alberto.findcard.screen.findcard.viewmodel.FindCardViewModel
import me.alberto.findcard.util.*
import javax.inject.Inject


class FindCardFragment : Fragment() {

    private lateinit var setRightOut: AnimatorSet
    private lateinit var setLeftIn: AnimatorSet
    private var backCardVisible = false
    private lateinit var binding: FragmentFindCardBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: FindCardViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindCardBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        initCardAnimation()
        setClickListeners()
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardNumberEdittext.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            val text = s.toString().trim()
            if (text.length == ACCEPTED_CARD_NUMBER_RANGE) {
                viewModel.getCardDetails(text)
            }

        }
    }

    private fun setupObservers() {
        viewModel.card.observe(viewLifecycleOwner) { card ->
            card ?: return@observe
            binding.card = card
           println("""
               
               
              card: $card 
               
           """)
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->
            state ?: return@observe
            when (state) {
                is State.Loading -> {
                    binding.frontCard.beGone()
                    binding.backCard.beGone()
                    binding.progressBar.beVisible()
                }

                is State.Error -> {
                    binding.frontCard.beGone()
                    binding.backCard.beGone()
                    binding.progressBar.beGone()
                    showError(state.error)
                }

                is State.Success -> {
                    binding.frontCard.beVisible()
                    binding.backCard.beVisible()
                    binding.progressBar.beGone()
                    canShowToolTip()
                }
            }

        }
    }

    private fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }

    private fun canShowToolTip() {
        val pref = requireActivity().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val toolTipShown = pref.getBoolean(TOOL_TIP_PREF, false)
        if (!toolTipShown) {
            showToolTip()
            pref.edit().putBoolean(TOOL_TIP_PREF, true).apply()
        }
    }


    private fun showToolTip() {
        val toolTip = createBalloon(requireContext()) {
            setArrowSize(10)
            setWidthRatio(0.4f)
            setArrowOrientation(ArrowOrientation.BOTTOM)
            setHeight(60)
            setArrowPosition(0.7f)
            setCornerRadius(4f)
            setAlpha(0.9f)
            setAutoDismissDuration(3000L)
            setText("Click to flip card")
            setTextColorResource(R.color.white)
            setBackgroundColorResource(R.color.black)
            setBalloonAnimation(BalloonAnimation.ELASTIC)
            setLifecycleOwner(lifecycleOwner)
        }
        toolTip.showAlignTop(binding.frontCard)
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