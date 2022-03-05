package com.example.registroestudantes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Db_Manager {
    DatabaseHelper databaseHelper;
    Context contexto;
    SQLiteDatabase sqllitedb;


    public Db_Manager(Context contexto){
        this.contexto=contexto;

    }

    public Db_Manager open(){
        databaseHelper=new DatabaseHelper(contexto);
        sqllitedb=databaseHelper.getWritableDatabase();
        return this;

    }

    public void close(){

        databaseHelper.close();
    }

    public void insert_estudante(Estudante estudante){
        ContentValues contentValue = new ContentValues();

        contentValue.put(DatabaseHelper.COD,estudante.getId());
        contentValue.put(DatabaseHelper.NOME,estudante.getNome());
        contentValue.put(DatabaseHelper.NUMB,estudante.getNrCell());
        contentValue.put(DatabaseHelper.NOTA,estudante.getNota1());
        contentValue.put(DatabaseHelper.NOTA2,estudante.getNota2());
        sqllitedb.insert(DatabaseHelper.ESTUDANTES,null,contentValue);

    }


    public Cursor getlist() {

        ArrayList<Estudante> estudantes=new ArrayList<>();
        Cursor cursor=sqllitedb.rawQuery(" SELECT * FROM " +DatabaseHelper.ESTUDANTES, null);


        return cursor;
    }








    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID,DatabaseHelper.COD, DatabaseHelper.NOME, DatabaseHelper.NUMB, DatabaseHelper.NOTA, DatabaseHelper.NOTA2 };
        Cursor cursor = sqllitedb.query(DatabaseHelper.ESTUDANTES, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id,String nome,String cell,String nota1,String nota2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NOME, nome);
        contentValues.put(DatabaseHelper.NUMB, cell);
        contentValues.put(DatabaseHelper.NOTA, nota1);
        contentValues.put(DatabaseHelper.NOTA2, nota2);
        int i = sqllitedb.update(DatabaseHelper.ESTUDANTES, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        sqllitedb.delete(DatabaseHelper.ESTUDANTES, DatabaseHelper._ID + "=" + _id, null);
    }
}
