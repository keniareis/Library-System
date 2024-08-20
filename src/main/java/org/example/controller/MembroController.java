package org.example.controller;

import org.example.model.Membro;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembroController {
    List<Membro> membros = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addMembro() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        String cpf = obterCPF();

        String telefone = obterTelefone();

        scanner.nextLine();
        System.out.print("Endereco (cidade, UF): ");
        String endereco = scanner.nextLine();

        Membro membro = new Membro(nome, cpf, telefone, endereco);

        membros.add(membro);

        System.out.println("\nMembro adicionado!\n");
    }

    public Membro buscarMembro(String nome){
        return membros.stream()
                .filter(membro -> membro.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void atualizarMembro(String nome){
        Membro updatedMembro = buscarMembro(nome);
        while (true) {
            System.out.println("Qual dado você quer atualizar: ");
            System.out.println("[1] - Telefone");
            System.out.println("[2] - Endereço");
            System.out.println("[0] - Voltar");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    String telefone = obterTelefone();
                    updatedMembro.setTelefone(telefone);
                    System.out.println("\nDados Atualizados com SUCESSO\n");
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Endereco (cidade, UF): ");
                    String endereco = scanner.nextLine();
                    updatedMembro.setEndereco(endereco);
                    System.out.println("\nDados Atualizados com SUCESSO\n");
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Escolha Invalida");

            }
        }
    }

    public void removerMembro(String nome){
        boolean removed = membros.removeIf(membro -> membro.getNome().equalsIgnoreCase(nome));
        if (removed) {
            System.out.println("\nMembro removido\n");
        }else {
            System.out.println("\nMembro nao encontrado\n");
        }
    }

    public void verMembros(){
        if (!membros.isEmpty()){
            for (Membro membro : membros){
                System.out.println(membro);
            }
        }else{
            System.out.println("\nNão há membros cadastrados\n");
        }
    }

    private String obterCPF(){
        String cpf;
        while (true){
            System.out.print("CPF: ");
            String numberCPF = scanner.next();
            cpf = isCPF(numberCPF);
            if (cpf != null){
                break;
            }else {
                System.out.println("CPF inválido. Por favor, digite novamente.\n");
            }
        }
        return cpf;
    }
    private String obterTelefone(){
        String telefone;
        while (true){
            System.out.print("Telefone: ");
            String numberPhone = scanner.next();
            telefone = isTelefone(numberPhone);
            if (telefone != null){
                break;
            }else {
                System.out.println("\nNúmero de telefone inválido. Por favor, digite novamente.\n");
            }
        }
        return telefone;
    }


    public String isCPF(String cpf){
        if (cpf.length() == 11) {
            return  cpf = cpf.substring(0, 3) + "." +
                    cpf.substring(3, 6) + "." +
                    cpf.substring(6, 9) + "-" +
                    cpf.substring(9, 11);
        }else {
            return null;
        }
    }
    public String isTelefone(String telefone){
        if (telefone.length() == 11) {
            return "(" + telefone.substring(0, 2) + ") " +
                    telefone.substring(2, 7) + "-" +
                    telefone.substring(7, 11);
        }else {
            return null;
        }
    }
}
