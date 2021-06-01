package org.Note

import org.w3c.dom.Entity

interface Crud <E>{   // Методы для работы с заметками.
    fun add(entity: E): Int // Создает новую заметку у текущего пользователя.
    //fun createComment() //Добавляет новый комментарий к заметке.
    fun delete(idDelete: Int):Boolean //Удаляет заметку текущего пользователя.
   // fun deleteComment() //Удаляет комментарий к заметке.
    fun edit(entity: E): Boolean //Редактирует заметку текущего пользователя.
  //  fun editComment() //Редактирует указанный комментарий у заметки.
    fun getList(ids: Int):List<E> //Возвращает список заметок, созданных пользователем.
    fun getById(idSearch: Int):E? //Возвращает заметку по её id.
  //  fun getComments() //Возвращает список комментариев к заметке.
    fun restoreComment(idRestore: Int):Boolean //Восстанавливает удалённый комментарий.
}