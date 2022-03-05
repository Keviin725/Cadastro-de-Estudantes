package com.example.registroestudantes;

public class Estudante {
    private String id;
    private String nome;
    private String nrCell;
    private String nota1;
    private String nota2;


    public Estudante(String id, String nome, String nrCell, String nota1, String nota2) {
        super();
        this.id = id;
        this.nome = nome;
        this.nrCell = nrCell;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Estudante() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNrCell() {
        return nrCell;
    }

    public void setNrCell(String nrCell) {
        this.nrCell = nrCell;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }
}
