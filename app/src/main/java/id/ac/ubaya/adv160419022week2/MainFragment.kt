package id.ac.ubaya.adv160419022week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnStart.setOnClickListener {
//            Ambil nama pemain
            val playerName = txtName.text.toString()
//            Dapatkan action yg ingin dijalankan
            val action = MainFragmentDirections.actionGameFragment(playerName)
//            Jalankan action tsb
            Navigation.findNavController(it).navigate(action)
        }

        // Untuk memunculkan dialog tidak perlu alert dialog
        buttonOptions.setOnClickListener{
            val action = MainFragmentDirections.actionOptionsFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}