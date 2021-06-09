package org.Note

import org.w3c.dom.Entity

class NoteService : Crud<Note> {

       private var notes: MutableList<Note> = arrayListOf()



    fun getAll(): MutableList<Note> {
        return notes
    }
    override fun add(note: Note): Int {
        val note = if (notes.isEmpty()) note.copy(noteId = 1)
        else note.copy(noteId = notes.last().noteId + 1)
        notes.plusAssign(note)
        return notes.last().noteId
    }

    override fun edit(noteNew: Note): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteNew.noteId) {
                if (note.deleted == false) {
                    noteNew.ownerId = note.ownerId
                    notes[index] = noteNew
                    println(noteNew)
                    return true
                }
            }

        }
        throw  NoteNotFoundException()
    }

    override fun delete(IdDelete: Int): Boolean {

        for ((index, note) in notes.withIndex()) {
            if (notes[index].noteId === (IdDelete)) {
                note.deleted = true
                return true
            }
        }
        throw  NoteNotFoundException()
    }

    override fun getList(ids: Int): List<Note> {
        var outputNotes: List<Note> = arrayListOf()
        for ((index, note) in notes.withIndex()) {
            if (ids == notes[index].ownerId) {
                if (!notes[index].deleted) outputNotes += notes[index]
            } else continue
        }
        return outputNotes
    }




    override fun getById(idSearch: Int): Note? {
        for ((index, note) in notes.withIndex()) {
            if (notes[index].noteId === (idSearch)) {
                if (!notes[index].deleted)
                    return note
                break
            }
        }
        throw  NoteNotFoundException()
    }

    override fun restoreComment(idRestore: Int): Boolean {
        TODO("Not yet implemented")
    }
}