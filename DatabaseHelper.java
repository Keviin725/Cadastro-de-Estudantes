package com.example.registroestudantes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String ESTUDANTES = "Estudantes";

    // Table columns
    public static final String _ID = "_id";
    public static final String COD = "Codigo_do_Estudante";
    public static final String NOME = "Nome_do_Estudante";
    public static final String NUMB = "Number_de_celular_do_Estudante";
    public static final String NOTA = "nota_do_Estudante";
    public static final String NOTA2 = "nota_do_Estudante_2";

    // Database Information
    static final String DB_NAME = "I31";

    // database version
    static final int DB_VERSION = 1;
    private static final String create_table_estudante = "create table " + ESTUDANTES +"(" +_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," + COD + " TEXT NOT NULL UNIQUE , " + NOME + " TEXT NOT NULL , " + NUMB + " TEXT NOT NULL UNIQUE ," + NOTA + " TEXT NOT NULL ," + NOTA2 + " TEXT NOT NULL" +")";



    public DatabaseHelper(@Nullable Context context) {

        super(context, ESTUDANTES, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(create_table_estudante);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ESTUDANTES);
        onCreate(db);

    }
}
