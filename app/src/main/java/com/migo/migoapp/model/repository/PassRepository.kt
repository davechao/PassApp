package com.migo.migoapp.model.repository

import com.migo.migoapp.model.db.AppDb
import com.migo.migoapp.model.db.PassDao

class PassRepository constructor(db: AppDb) {

    private val passDao: PassDao = db.passDao()

}