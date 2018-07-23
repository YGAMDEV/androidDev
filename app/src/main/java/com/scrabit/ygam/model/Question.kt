package com.scrabit.ygam.model

data class Question (
        var textId: Int,
        val text: String,
        val choice: Choice,
        val isFinalPage: Boolean
)