package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel

    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) {
                gameFinished()
                viewModel.onGameFinishComplete()
            }
        })

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

    }

    /**
     * Called when the game is finished
     */
    fun gameFinished() {
        val currentScore = viewModel.score.value ?: 0
        val action = GameFragmentDirections.actionGameToScore(currentScore)
        findNavController(this).navigate(action)
    }

}
