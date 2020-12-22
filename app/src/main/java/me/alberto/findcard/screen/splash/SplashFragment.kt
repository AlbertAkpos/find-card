package me.alberto.findcard.screen.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.alberto.findcard.R
import java.util.*
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        Timer().schedule(2000) {
            val action = SplashFragmentDirections.actionSplashFragmentToFindCardFragment()
            findNavController().navigate(action)
        }

        return view
    }


}