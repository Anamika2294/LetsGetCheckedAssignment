package com.example.letsgetcheckedassignment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class PopupFragment : DialogFragment() {
    private var subregion: String? = null
    private var population: Int? = null
    private var area: Double? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subregion = arguments?.getString("Subregion")
        population = arguments?.getInt("Population")
        area = arguments?.getDouble("Area")


        Log.v("PopupFragment",""+subregion+" "+population+" "+area)

        // Pick a style based on the num.
        val style = DialogFragment.STYLE_NO_FRAME
        val theme = R.style.DialogTheme
        setStyle(style, theme)
    }

    // Override the Fragment.onAttach() method to instantiate the
    // NoticeDialogListener
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.frag_dialog_layout, container, false)

        val btnCancel = view.findViewById<View>(R.id.cancel) as Button
        //val btnAccept = view.findViewById<View>(R.id.buttonAccept) as ImageButton


        val txt_subregion = view.findViewById<View>(R.id.country_subregion) as TextView

       // Log.v("TextView",""+txt_subregion)


        val txt_population = view.findViewById<View>(R.id.population) as? TextView
        val txt_area = view.findViewById<View>(R.id.area) as? TextView


        Log.v("PopupFragmentonCreateView",""+subregion+" "+population+" "+area)



        txt_subregion.text ="ABC"
         txt_population!!.text = population.toString()
         txt_area!!.text = area.toString()



        //FontUtils.setTypeface(getActivity(), textViewQuestion, "fonts/mangal.ttf");
        //FontUtils.setTypeface(getActivity(), textViewAnswer, "fonts/mangal.ttf");
        btnCancel.setOnClickListener {
           // Toast.makeText(activity, "action cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }
//
//        btnAccept.setOnClickListener {
//            Toast.makeText(activity, "User Accepted Action", Toast.LENGTH_SHORT).show()
//            dismiss()
//        }

        return view
    }

    companion object {


        /**
         * Create a new instance of CustomDialogFragment, providing "num" as an
         * argument.
         */
        fun newInstance(subregion: String,population: Int, area:Double): PopupFragment {
            val f = PopupFragment()
            Log.v("PopupFragmentInstance",""+subregion+" "+population+" "+area)

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("Subregion",subregion)
            args.putInt("Population",population)
            args.putDouble("Area",area)


            f.arguments = args

            return f
        }
    }
}