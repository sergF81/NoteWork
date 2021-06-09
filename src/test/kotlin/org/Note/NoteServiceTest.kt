package org.Note

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        val m = NoteService()
        val result1 = m.add(Note(ownerId = 2, text = "Проверка333"))
        assertEquals(1, result1)
    }
}

class NoteServiceTest2 {
    @Test
    fun deleteTrue() {
        val m2 = NoteService()
        m2.add(Note(ownerId = 3, text = "Проверка3"))
        m2.add(Note(ownerId = 4, text = "Проверка Удаления"))
        val result2 = m2.delete(2)
        assertTrue(result2)
    }
}

class CommentServiceTest3 {
    @Test
    fun getById() {
        val m21 = NoteService()
        m21.add(Note(ownerId = 3, text = "Проверка3"))
        m21.add(Note(ownerId = 4, text = "Проверка4"))
        println(m21.getAll())
        val m3 = CommentService(m21)

        m3.add(Comment(noteId = 2, message = "Hi"))
        println(m3.comments.toList())
        val result3 = m3.getById(1)
        assertEquals("Comment(commentId=1, noteId=2, ownerId=0, message=Hi, deleted=false)", result3.toString())
    }
}

class NoteServiceTest4 {
    @Test(expected = NoteNotFoundException::class)
    fun shouldThrow() {
        val m4 = NoteService()
        m4.add(Note(ownerId = 3, text = "Проверка3"))
        m4.delete(2)
    }
}