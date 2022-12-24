package com.example.jetpackcomposelearning.screens.scale

sealed class LineType {
    object Normal: LineType()
    object FiveStep: LineType()
    object TenStep : LineType()
}