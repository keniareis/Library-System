package org.example.controller;

import org.example.model.Membro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembroController {
    List<Membro> membros = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void addMembro(){
        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.next();

        System.out.println("Telefone: ");
        String telefone = scanner.next();
        scanner.nextLine();

        System.out.println("Endereco (ex: Rua:\n Numero:\n Cidade:\n: ");
        String endereco = scanner.nextLine();

        Membro membro = new Membro(nome, cpf, telefone, endereco);

        membros.add(membro);

        System.out.println("Membro adicionado!");
    }

    public Membro buscarMembro(String nome){
        return membros.stream()
                .filter(membro -> membro.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void atualizarMembro(String nome){

    }

    public void removerMembro(String nome){
        boolean removed = membros.removeIf(membro -> membro.getNome().equalsIgnoreCase(nome));
        if (removed) {
            System.out.println("Membro removido");
        }else {
            System.out.println("Membro nao encontrado");
        }
    }

    public void verMembros(){
        if (!membros.isEmpty()){
            for (Membro membro : membros){
                System.out.println(membro);
            }
        }else{
            System.out.println("Não há membros cadastrados");
        }
    }
}
