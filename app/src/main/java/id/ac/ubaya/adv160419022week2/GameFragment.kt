package id.ac.ubaya.adv160419022week2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random


class GameFragment : Fragment() {
    var result:Int = 0
    var answer:Int = 0
    var score:Int = 0
    var random = listOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        score = 0
        GetRandom()


        btnSubmit.setOnClickListener {
            answer = inputAnswer.text.toString().toInt()
            Log.d("Answer", answer.toString())
            if (answer == result)
            {
                score++
                GetRandom()
                inputAnswer.getText()?.clear()
            }
            else
            {
                // Dapatkan action yg ingin dijalankan
                val action = GameFragmentDirections.actionResultFragment("GAME OVER", score)
                //Jalankan action tsb
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun GetRandom(){
        val randomValues = List(2) { Random.nextInt(1, 99) }

        // RANDOM NUMBER
        result = randomValues[0]+randomValues[1]
        Log.d("Values", randomValues.toString())
        Log.d("Result", result.toString())

        // SHOW RANDOM
        decimalOne.text = randomValues[0].toString()
        decimalTwo.text = randomValues[1].toString()
    }
}