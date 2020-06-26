package com.example.initialarsetup.androiddevs.furnituretryout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.initialarsetup.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

private const val BOTTOM_SHEET_PEEK_HEIGHT = 50f

class MainActivity : AppCompatActivity() {

    private val models = mutableListOf(
        Model(
            R.drawable.chair, "Chair",
            R.raw.chair
        ), Model(
            R.drawable.oven, "Oven",
            R.raw.oven
        ),
        Model(
            R.drawable.table, "Table",
            R.raw.table
        ),
        Model(
            R.drawable.piano, "Piano",
            R.raw.piano
        )

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomSheet();//PERMITE CREAR EL AREA ABAJO DEL OBJECTO
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvModels.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvModels.adapter = ModelAdapter(models)
    }

    private fun setupBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.peekHeight =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                BOTTOM_SHEET_PEEK_HEIGHT,
                resources.displayMetrics
            ).toInt()
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                bottomSheet.bringToFront()
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {}
        })
    }
}
