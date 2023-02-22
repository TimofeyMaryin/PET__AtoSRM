package com.example.atosrm.domain.model


@Deprecated("Не смог реализовать то, что было задумано....")
data class TextFieldModel(
    var value: String,
    var placeHolder: Int,
    var descriptor: Int,
    var onChangeValue: (String) -> Unit
)
