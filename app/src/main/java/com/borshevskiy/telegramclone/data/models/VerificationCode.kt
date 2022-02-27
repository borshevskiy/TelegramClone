package com.borshevskiy.telegramclone.data.models

import android.os.Parcelable
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.parcelize.Parcelize

@Parcelize
data class VerificationCode(
    var id: String,
    var token: PhoneAuthProvider.ForceResendingToken
): Parcelable
