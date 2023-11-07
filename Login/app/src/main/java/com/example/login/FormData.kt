package com.example.login

class FormData(
    private var userName:String,
    private var password:String
) {

    fun validUserName():ValidationResult{
        return if (userName.isEmpty()){
            ValidationResult.Empty("UserName is Empty")
        }else if (userName != "Admin"){
            ValidationResult.Invalid("Invalid user name")
        }else{
            ValidationResult.Valid
        }
    }

    fun validPasword():ValidationResult{
        return if (password.isEmpty()){
            ValidationResult.Empty("Password is Empty")
        }else if (password != "admin@123"){
            ValidationResult.Invalid("Invalid password")
        }else{
            ValidationResult.Valid
        }
    }


}