package com.example.tute05.models

import com.example.tute05.models.validations.ValidationResults

class FormData(
               private var studentId: String,
               private var year:String,
               private var semester:String,
               private var agree:Boolean
)
{

    fun validateStudentId():ValidationResults{

        return  if (studentId.isEmpty()){
            ValidationResults.Empty("Enter the student ID")

        }else if(!studentId.startsWith("IT")){
            ValidationResults.Invalid("Student ID must start with IT")

        }else if(studentId.length != 10){
            ValidationResults.Invalid("Student ID must contains 10 characters")

        }else{
            ValidationResults.Valid
        }

    }

    fun validateYear() : ValidationResults{

        return  if(year.isEmpty()){
            ValidationResults.Empty("Select the year")

        }else{
            ValidationResults.Valid
        }
    }

    fun validateSemester() : ValidationResults{

        return  if(semester.isEmpty()){
            ValidationResults.Empty("Select the year")

        }else{
            ValidationResults.Valid
        }
    }

    fun validateAgreement():ValidationResults{

        return if(!agree){
            ValidationResults.Invalid("You have to agree to the terms and conditions!")

        }else{
            ValidationResults.Valid
        }
    }

}




