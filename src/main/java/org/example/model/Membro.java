package org.example.model;

public class Membro {
    private String nome;
    private String CPF;
    private String telefone;
    private String Endereco;

    public Membro() {
    }

    public Membro(String nome, String CPF, String telefone, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        Endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public void addMembro(){

    }

    public void infoMembro(String nome){

    }

    public void atualizarMembro(String nome){

    }

    public void removerMembro(String nome){

    }
}
