package com.example.fineduca.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuario")
data class Usuario(
    @PrimaryKey(true)var id: Long = 0,
    var nome: String ="",
    var email: String ="",
    @ColumnInfo(name = "is_agreed") var agreedToTerms: Boolean = false

)
