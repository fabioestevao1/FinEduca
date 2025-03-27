package com.example.fineduca.database.repository

import androidx.room.processor.Context
import com.example.fineduca.database.dao.UsuarioDb
import com.example.fineduca.model.Usuario

class UsuarioRepository(context: Context) {

    var db = UsuarioDb.getDatabase(context).UsuarioDao()

    fun salvar(usuario: Usuario): Long{
        return db.salvar(usuario = usuario)
    }

    fun atualizar(usuario: Usuario): Int{
        return db.atualizar(usuario = usuario)
    }

    fun excluir(usuario: Usuario): Int{
        return db.excluir(usuario=usuario)
    }

    fun buscarUsuarioPeloId(id:Long):Usuario{
        return db.buscarUsuarioPeloId(id = id)
    }

    fun listarUsuarios(): List<Usuario> {
        return db.listarUsuarios()
    }
}