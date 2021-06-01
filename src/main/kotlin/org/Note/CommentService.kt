package org.Note

import org.Note.NoteService.Companion.notes


class CommentService : Crud<Comment> {
    var comments: MutableList<Comment> = arrayListOf()

    override fun add(comment: Comment): Int {
        for ((index, note) in notes.withIndex()) {
            if ((notes[index].noteId == comment.noteId) && !notes[index].deleted) {
                val comment = if (comments.isEmpty()) comment.copy(commentId = 1)
                else comment.copy(commentId = comments.last().commentId + 1)
                comments.plusAssign(comment)

            }
        }
        return comments.last().commentId
    }

    override fun delete(idDelete: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (notes[index].noteId === (idDelete)) {
                comment.deleted = true
                return true
            }
        }
        return false
    }

    override fun edit(commentNew: Comment): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comments[index].commentId == commentNew.commentId) {
                if (!comments[index].deleted) {
                    commentNew.ownerId = comments[index].ownerId
                    commentNew.noteId = comments[index].noteId
                    comments[index] = commentNew
                    return true
                }
            }
        }
        return false
    }

    override fun getList(ids: Int): List<Comment> {
        var outputComments: List<Comment> = arrayListOf()
        for ((index, note) in comments.withIndex()) {
            if (ids == comments[index].noteId) {
                if (!comments[index].deleted) outputComments += comments[index]
            } else continue
        }
        return outputComments
    }

    override fun getById(idSearch: Int): Comment? {
        for ((index, comment) in comments.withIndex()) {
            if (comments[index].commentId == idSearch) {
                if (!comments[index].deleted)
                    return comment
                break
            }
        }
        throw  CommentNotFoundException()
    }

    override fun restoreComment(idRestore: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (notes[index].noteId == idRestore) {
                comment.deleted = false
                return true
            }
        }
        return false
    }


}