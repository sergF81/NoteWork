package org.Note

class NoteNotFoundException : Exception("Заметка с данным ID не найдена!") {

}

class CommentNotFoundException : Exception("Комментарий с данным ID не найден!") {

}
