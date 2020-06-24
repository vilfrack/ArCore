package com.example.initialarsetup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
private const val BOTTOM_SHEET_PEEK_HEIGHT = 50f
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomSheet();//PERMITE CREAR EL AREA ABAJO DEL OBJECTO
    }

    private fun setupBottomSheet(){
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.peekHeight=
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                BOTTOM_SHEET_PEEK_HEIGHT,
                resources.displayMetrics
            ).toInt()
        //CUANDO SE MUEVE Y SE SELECCIONA EL LINEAR, QUEDA UN ESPACIO GRIS. CON EL SIGUIENTE
        //BLOQUE DE CODIGO SE CORRIGE ESA FALLA
            bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback(){
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    bottomSheet.bringToFront()
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    TODO("Not yet implemented")
                }

            })
    }
}