package com.example.guessnumberapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast


class NumbersFragment : Fragment() {
    lateinit var imageViewOne: ImageView
    lateinit var imageViewTwo: ImageView
    lateinit var imageViewThree: ImageView
    lateinit var imageViewFour: ImageView
    lateinit var imageViewFive: ImageView
    lateinit var imageViewSix: ImageView
    lateinit var imageViewSeven: ImageView
    lateinit var imageViewEight: ImageView
    lateinit var imageViewNine: ImageView
    lateinit var  images :Array<ImageView>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewOne = view.findViewById(R.id.NumFrag_IV_One)
        imageViewTwo = view.findViewById(R.id.NumFrag_IV_Two)
        imageViewThree = view.findViewById(R.id.NumFrag_IV_Three)
        imageViewFour = view.findViewById(R.id.NumFrag_IV_Four)
        imageViewFive = view.findViewById(R.id.NumFrag_IV_Five)
        imageViewSix = view.findViewById(R.id.NumFrag_IV_Six)
        imageViewSeven = view.findViewById(R.id.NumFrag_IV_Seven)
        imageViewEight = view.findViewById(R.id.NumFrag_IV_Eight)
        imageViewNine = view.findViewById(R.id.NumFrag_IV_Nine)
        images = arrayOf(
            imageViewOne, imageViewTwo, imageViewThree, imageViewFour,
            imageViewFive, imageViewSix, imageViewSeven, imageViewEight, imageViewNine
        )
        val randomNumber = arguments?.getInt("randomNumber_Key")

        for (img in images) {
            img.setOnClickListener {
           if((images.indexOf(img)+1)==randomNumber){
             Toast.makeText(activity, "You Are Wine!", Toast.LENGTH_SHORT).show()
//               img.setImageResource((R.drawable.truered))
               img.background = resources.getDrawable(R.drawable.greenrightmark)
               disableAllImage()
           }else{
//                Toast.makeText(activity, "randomNumber=$randomNumber ", Toast.LENGTH_SHORT).show()
               img.background = resources.getDrawable(R.drawable.redwrongmark)
               img.isEnabled=false
           }

            }
        }
//        Toast.makeText(activity,"randomNumber= $randomNumber ",Toast.LENGTH_SHORT).show()
    }
      fun disableAllImage(){
          for (img in images) {
              img.isEnabled=false
          }
      }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numbers, container, false)
    }

}