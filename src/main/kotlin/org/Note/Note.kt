package org.Note

data class Note(

    val noteId: Int = 0,
    var ownerId: Int = 0,
    val title: String = "",
    val text: String = "",
    var deleted: Boolean = false

)


//privacy_viewнастройки приватности просмотра заметки в специальном формате. список слов, разделенных через запятую, по умолчанию all, доступен начиная с версии 5.30
//privacy_commentнастройки приватности комментирования заметки в специальном формате. список слов, разделенных через запятую, по умолчанию all, доступен начиная с версии 5.30

