package com.example.registroestudantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity implements View.OnClickListener {

    private EditText nome1, cell1,note1,note2;
    private Button mod,apagar;
    Db_Manager db_manager;
    private long _id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        nome1=findViewById(R.id.et_nome1);
        cell1=findViewById(R.id.et_cell1);
        note1=findViewById(R.id.et_note1);
        note2=findViewById(R.id.et_note2);

        mod=(Button) findViewById(R.id.btn_new);
        apagar=(Button) findViewById(R.id.btn_delete);

        db_manager = new Db_Manager(this);
        db_manager.open();
        mod.setOnClickListener(this);
        apagar.setOnClickListener(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("Id");
        String nome = intent.getStringExtra("Nome");
        String numero = intent.getStringExtra("Numero");
        String nota1 = intent.getStringExtra("Nota 1");
        String nota2 = intent.getStringExtra("Nota 2");
        _id = Long.parseLong(id);

        nome1.setText(nome);
        cell1.setText(numero);
        note1.setText(nota1);
        note2.setText(nota2);




    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_new:
                //String codigo = codigo1.getText().toString();
                String nome = nome1.getText().toString();
                String numero=cell1.getText().toString();
                String n1=note1.getText().toString();
                String n2=note2.getText().toString();  /*codigo*/
                db_manager.update(_id,nome,numero,n1,n2);
                this.returnHome();
                break;

            case R.id.btn_delete:
                db_manager.delete(_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}