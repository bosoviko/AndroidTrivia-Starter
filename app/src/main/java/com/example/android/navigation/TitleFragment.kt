package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

// ЗАВДАННЯ: перейменувати аргументи параметрів, вибрати відповідні імена
// параметри ініціалізації фрагмента, напр. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * Простий підклас [Fragment].
 * Використовуйте заводський метод [TitleFragment.newInstance], щоб
 * створити екземпляр цього фрагмента.
 */
class TitleFragment : Fragment() {
    // ЗАВДАННЯ: перейменувати та змінити типи параметрів
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }




    companion object {
        /**
         * Використовуйте цей заводський метод для створення нового екземпляра
         * цей фрагмент з використанням наданих параметрів.
         *
         * @param param1 Параметр 1.
         * @param param2 Параметр 2.
         * @return Новий екземпляр фрагмента TitleFragment.
         */
        // TODO: перейменувати та змінити типи та кількість параметрів
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}