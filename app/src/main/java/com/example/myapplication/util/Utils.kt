package com.example.myapplication.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ContextAmbient

/**
 * function to get string from res values
 */
@Composable
fun string(@StringRes stringId: Int) = ContextAmbient.current.getString(stringId)