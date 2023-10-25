package com.example.tute05.models.validations

sealed class ValidationResults{

    data class Empty(val errorMessage:String):ValidationResults()
    data class Invalid(val errorMessage:String):ValidationResults()
    object Valid:ValidationResults()

}
