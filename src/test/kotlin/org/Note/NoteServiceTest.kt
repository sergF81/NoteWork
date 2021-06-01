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
        val result2 = m2.delete(2)
        assertTrue(result2)
    }
}

class CommentServiceTest3 {
    @Test
    fun getById() {
        val m2 = NoteService()
        m2.add(Note(ownerId = 3, text = "Проверка3"))
        m2.add(Note(ownerId = 4, text = "Проверка4"))
        val m3 = CommentService()
        m3.add(Comment(noteId = 3, message = "Hi"))
        val result3 = m3.getById(1)
        assertEquals("Comment(commentId=1, noteId=3, ownerId=0, message=Hi, deleted=false)", result3)
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