package org.example.model;

import org.example.controller.MembroController;

import java.util.Scanner;

public class Membro {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    MembroController controller = new MembroController();

    public Membro() {
    }

    public Membro(String nome, String CPF, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = CPF;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void membroMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("=============== Area de Membros ===============\n");
            System.out.println("[1] - Ver membros");
            System.out.println("[2] - Adicionar membros");
            System.out.println("[3] - Buscar membro");
            System.out.println("[4] - Atualizar membro");
            System.out.println("[5] - Remover membro");
            System.out.println("[0] - Sair\n");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    controller.verMembros();
                    break;

                case 2:
                    controller.addMembro();
                    break;

                case 3:
                    System.out.print("Nome completo do membro: ");
                    String nome = scanner.nextLine();
                    Membro membroEncontrado = controller.buscarMembro(nome);
                    if (membroEncontrado != null){
                        System.out.println("\nMembro encontrado: " + membroEncontrado + "\n");
                    }else {
                        System.out.println("Membro NÃO encontrado");
                    }
                    break;

                case 4:
                    System.out.print("Nome completo do membro: ");
                    nome = scanner.nextLine();
                    controller.atualizarMembro(nome);
                    break;

                case 5:
                    System.out.print("Nome completo do membro: ");
                    nome = scanner.nextLine();
                    controller.removerMembro(nome);
                    break;

                case 0:
                    System.out.print("\nSaindo...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }

    public String toString(){
        return "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Telefone: " + telefone + "\n" +
                "Endereco: " + endereco + "\n";

    }
}
