package org.example;

import org.example.model.Membro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Membro membro = new Membro();

        try {
            while (true){
                System.out.println("=============== Biblioteca ===============");
                System.out.println("\nMenu......................................\n");
                System.out.println("[1] - Área de membros\n");

                System.out.print("Escolha um numero para navegar pelo menu: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        membro.membroMenu();
                        break;

                    default:
                        System.out.println("escolha invalida");
                        break;
                }
            }
        }catch (Exception e){

        }
    }
}