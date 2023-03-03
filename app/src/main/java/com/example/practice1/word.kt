package com.example.practice1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice1.databinding.FragmentLetterBinding
import com.example.practice1.databinding.FragmentWordBinding

class word : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
companion object {
    val LETTER = "letter"
    val SEARCH_PREFIX = "https://www.google.com/search?q="
}
    private var _binding :FragmentWordBinding?=null
    private  val binding get() =  _binding!!
    private lateinit var letterId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId=it.getString(LETTER).toString()
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentWordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.Wordlist
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment word.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            word().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}