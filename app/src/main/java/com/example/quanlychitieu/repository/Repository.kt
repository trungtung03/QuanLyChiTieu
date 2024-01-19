package com.example.quanlychitieu.repository

import android.content.Context
import com.example.quanlychitieu.local.AppDatabase
import com.example.quanlychitieu.model.Archive
import com.example.quanlychitieu.model.Collect
import com.example.quanlychitieu.model.Money
import com.example.quanlychitieu.model.Note
import com.example.quanlychitieu.model.Spending
import com.example.quanlychitieu.model.NoteType

class Repository(context: Context) {
    private val databaseLocal: AppDatabase by lazy {
        AppDatabase.getInstance(context)
    }


    suspend fun addMoney(money: Money) = databaseLocal.getDatabaseDao().insertAll(money)
    suspend fun setSpending(spending: Spending) = databaseLocal.getSpendingDao().insertAll(spending)
    suspend fun setCollect(collect: Collect) = databaseLocal.getCollectDao().insertAll(collect)
    suspend fun addNote(note: Note) = databaseLocal.getNoteDao().addNote(note)
    suspend fun delete(note: Note) = databaseLocal.getNoteDao().delete(note)
    suspend fun updateNote(note: Note) = databaseLocal.getNoteDao().update(note)
    suspend fun addNoteType(noteType: NoteType) = databaseLocal.getNoteTypeDao().addNoteType(noteType)
    suspend fun updateNoteType(noteType: NoteType) = databaseLocal.getNoteTypeDao().updateNoteType(noteType)
    suspend fun deleteNoteType(noteType: NoteType) = databaseLocal.getNoteTypeDao().deleteNoteType(noteType)

    fun getAllNote()= databaseLocal.getNoteDao().getAll()
    fun getListCollect(): List<Collect> = databaseLocal.getCollectDao().getAll()
    fun getListCollectLivedata() = databaseLocal.getCollectDao().getAllLiveData()
    fun getMoney(): List<Money> = databaseLocal.getDatabaseDao().getAll()
    fun getListSpending(): List<Spending> = databaseLocal.getSpendingDao().getAll()
    fun getListSpendingLiveData() = databaseLocal.getSpendingDao().getAllLiveData()
    fun getListNoteType(): List<NoteType> = databaseLocal.getNoteTypeDao().getAll()
    fun getArchiveLiveData () = databaseLocal.getArchiveDao().getAllLiveData()
    suspend fun updateArchive (item : Archive) = databaseLocal.getArchiveDao().update(item)
    suspend fun removeArchive(item: Archive) = databaseLocal.getArchiveDao().delete(item)
    suspend fun addArchive(item: Archive)= databaseLocal.getArchiveDao().add(item)
}