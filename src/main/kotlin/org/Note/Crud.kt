package org.Note

import org.w3c.dom.Entity

interface Crud <E>{   // ������ ��� ������ � ���������.
    fun add(entity: E): Int // ������� ����� ������� � �������� ������������.
    //fun createComment() //��������� ����� ����������� � �������.
    fun delete(idDelete: Int):Boolean //������� ������� �������� ������������.
   // fun deleteComment() //������� ����������� � �������.
    fun edit(entity: E): Boolean //����������� ������� �������� ������������.
  //  fun editComment() //����������� ��������� ����������� � �������.
    fun getList(ids: Int):List<E> //���������� ������ �������, ��������� �������������.
    fun getById(idSearch: Int):E? //���������� ������� �� � id.
  //  fun getComments() //���������� ������ ������������ � �������.
    fun restoreComment(idRestore: Int):Boolean //��������������� �������� �����������.
}