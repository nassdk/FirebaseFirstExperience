package com.nassdk.supchat.domain.global

import com.arellomobile.mvp.MvpPresenter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.koin.core.KoinComponent
import org.koin.core.inject
import ru.terrakok.cicerone.Router
import org.koin.java.KoinJavaComponent.inject as inject1

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>(), KoinComponent  {

    val auth    : FirebaseAuth     by lazy { FirebaseAuth.getInstance() }
    val database: FirebaseDatabase by lazy { FirebaseDatabase.getInstance() }
    val referenceUsers  = database.getReference(USERS)
    val referenceChats  = database.getReference(CHATS)
    val fbUser              = FirebaseAuth.getInstance().currentUser

    val router: Router by inject()

    open fun onBackPressed() = router.exit()

    companion object {
        const val USERS = "Users"
        const val CHATS = "Chats"
    }
}