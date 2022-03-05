package com.example.registroestudantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Lista extends AppCompatActivity {

    private ListView lista_estudante;
    private Db_Manager db_manager;


    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,DatabaseHelper.COD,
            DatabaseHelper.NOME, DatabaseHelper.NUMB, DatabaseHelper.NOTA, DatabaseHelper.NOTA2 };
    final int[] to = new int[] { R.id.id, R.id.nome, R.id.numero, R.id.nota1, R.id.nota2 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        db_manager = new Db_Manager(this);
        db_manager.open();
        Cursor cursor = db_manager.fetch();

        lista_estudante = findViewById(R.id.lista);


        adapter = new SimpleCursorAdapter(this, R.layout.visualizar_lista, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        lista_estudante.setAdapter(adapter);

        // OnCLickListiner For List Items
        lista_estudante.setOnItemClickListener((parent, view, position, viewId) -> {
            TextView idTextView = view.findViewById(R.id.id);
            TextView nomeTextView = (TextView) view.findViewById(R.id.nome);
            TextView cellTextView = (TextView) view.findViewById(R.id.numero);
            TextView nota1TextView =(TextView) view.findViewById(R.id.nota1);
            TextView nota2TextView = (TextView) view.findViewById(R.id.nota2);

            String id = idTextView.getText().toString();
            String nome = nomeTextView.getText().toString();
            String numero =cellTextView.getText().toString();
            String nota1 =nota1TextView.getText().toString();
            String nota2 =nota2TextView.getText().toString();

            Intent modify_intent = new Intent(getApplicationContext(), Modificar.class);
            modify_intent.putExtra("Id", id);
            modify_intent.putExtra("Nome", nome);
            modify_intent.putExtra("Numero", numero);
            modify_intent.putExtra("Nota 1", nota1);
            modify_intent.putExtra("Nota 2", nota2);

            startActivity(modify_intent);
        });


    }
}