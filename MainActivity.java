package com.example.registroestudantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nome,codigo,cell,nota1,nota2;
    private Button salvar,listar;
    private Toast t;

    Db_Manager db_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome=findViewById(R.id.et_nome);
        codigo =findViewById(R.id.et_id);
        cell =findViewById(R.id.et_cell);
        nota1=findViewById(R.id.et_nota1);
        nota2=findViewById(R.id.et_nota2);
        salvar=findViewById(R.id.btn_salvar);
        listar=findViewById(R.id.btn_listar);
        //ver=findViewById(R.id.versao);
        db_manager=new Db_Manager(this);

        //ver.setText(DB_VERSION);

        salvar.setOnClickListener(v -> {

            validarCredencias();


        });


        listar.setOnClickListener(v -> {

            Intent troca= new Intent(MainActivity.this,Lista.class);
            startActivity(troca);

        });
    }
    private Toast mostrar(int n){

        if(n==0){
            t=Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT);
        }
        else if (n==1){
            t=Toast.makeText(this,"SALVO COM SUCESSO",Toast.LENGTH_LONG);
        }

        return t;
    }

    private  void insert(String id, String nome, String numero,String nota1, String nota2){
        db_manager.open();
        db_manager.insert_estudante(new Estudante(id,nome,numero,nota1,nota2));
        db_manager.close();
    }

    void validarCredencias(){

        boolean isValid= true;
        if(isEmpty(nome)){

            nome.setError("Introduza Seu nome");
            isValid=false;
        }

        if(isEmpty(codigo)){
            codigo.setError("Insira Codigo");
            isValid=false;

        }
        if(isEmpty(cell)){

            cell.setError("Introduza numero de celular");
        }

        if(isEmpty(nota1)){

            nota1.setError("Introduza nota 1");
        }

        if(isEmpty(nota2)){

            nota2.setError("Introduza nota 2");
        }

        if(isValid){
            String codValue= codigo.getText().toString();
            String cellValue= cell.getText().toString();
            String nomeValue= nome.getText().toString();
            String nota1Value= nota1.getText().toString();
            String nota2Value= nota2.getText().toString();


            if(!nomeValue.isEmpty()) {
                if (!codValue.isEmpty()) {
                    if (!cellValue.isEmpty()) {
                        if (!nota1Value.isEmpty()) {
                            if (!nota2Value.isEmpty()) {
                                insert(codigo.getText().toString(), nome.getText().toString(), cell.getText().toString(), nota1.getText().toString(), nota2.getText().toString());


                                codigo.setText(null);
                                nome.setText(null);
                                cell.setText(null);
                                nota1.setText(null);
                                nota2.setText(null);
                                mostrar(1);
                                 
                                Toast.makeText(this, "Crendicias validas ", Toast.LENGTH_SHORT);
                            }
                        }
                    }
                }

            }else{

                Toast.makeText(this,"falhou credencias",Toast.LENGTH_SHORT);

            }

        }


    }


    boolean isEmpty(EditText text){

        CharSequence str= text.getText().toString();
        return TextUtils.isEmpty(str);

    }
}