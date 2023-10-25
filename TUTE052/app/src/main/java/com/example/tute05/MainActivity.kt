package com.example.tute05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.tute05.models.FormData
import com.example.tute05.models.validations.ValidationResults

class MainActivity : AppCompatActivity() {

    lateinit var edtStudent:EditText
    lateinit var spnYear:Spinner
    lateinit var spnSemester:Spinner
    lateinit var cbAgree:CheckBox

    private  var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtStudent  = findViewById(R.id.editStudentId)
        spnYear     = findViewById(R.id.spnYear)
        spnSemester = findViewById(R.id.spnSemester)
        cbAgree     = findViewById(R.id.cbAgree)

    }

    fun displayAlert(title:String, message:String){

        var builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok"){dialog, which -> }

        val dialog = builder.create()
        dialog.show()
    }

    fun submit(v:View){
        val myForm = FormData(
            edtStudent.text.toString(),
            spnYear.selectedItem.toString(),
            spnSemester.selectedItem.toString(),
            cbAgree.isChecked
        )

        val studentIdValidation     = myForm.validateStudentId()
        val spnYearValidation       = myForm.validateYear()
        val spnSemesterValidation   = myForm.validateSemester()
        val cbAgreeValidation       = myForm.validateAgreement()

        when(studentIdValidation){
            is ValidationResults.Valid -> {
                count++
            }

            is ValidationResults.Invalid -> {
                edtStudent.error = studentIdValidation.errorMessage
            }

            is ValidationResults.Empty -> {
                edtStudent.error = studentIdValidation.errorMessage
            }
        }

        when(spnYearValidation) {

            is ValidationResults.Valid -> {
                count++
            }

            is ValidationResults.Invalid -> {

            }

            is ValidationResults.Empty -> {
                val tv: TextView = spnYear.selectedItem as TextView
                tv.error = ""
                tv.text = spnYearValidation.errorMessage
            }


            }

        when (spnSemesterValidation) {

            is ValidationResults.Empty -> {
                val tv: TextView = spnSemester.selectedItem as TextView
                tv.error = ""
                tv.text = spnSemesterValidation.errorMessage
            }

            is ValidationResults.Invalid -> {

            }

            ValidationResults.Valid -> {
                count++
            }

        }

        when(cbAgreeValidation){
            is ValidationResults.Empty -> {

            }

            is ValidationResults.Invalid -> {
                displayAlert("Error", cbAgreeValidation.errorMessage)
            }

            ValidationResults.Valid -> {
                count ++
            }
        }

        if(count == 4){
            displayAlert("Success", "You have successfully Registered")
        }else{
            count  = 0
        }

    }




}