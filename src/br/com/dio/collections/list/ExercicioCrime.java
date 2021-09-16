package br.com.dio.collections.list;

import java.util.*;

public class ExercicioCrime {
    public static void main(String[] args) {
        List<String> respostas = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Telefonou para a vitima?");
        String resposta = sc.next();
        respostas.add(resposta.toLowerCase());
        System.out.println("Esteve no local do crime?");
        resposta = sc.next();
        respostas.add(resposta.toLowerCase());
        System.out.println("Mora perto da vitima?");
        resposta = sc.next();
        respostas.add(resposta.toLowerCase());
        System.out.println("Devia para a vitima?");
        resposta = sc.next();
        respostas.add(resposta.toLowerCase());
        System.out.println("Já trabalhou com a vítima?");
        resposta = sc.next();
        respostas.add(resposta.toLowerCase());

        System.out.println(respostas);

        int count = 0;
        Iterator<String> contador = respostas.iterator();
        while(contador.hasNext()) {
            String resp = contador.next();
            if(resp.contains("s")) {
                count++;
            }
        }

        switch (count) {
            case 2:
                System.out.println(">> SUSPEITO <<"); break;
            case 3:
            case 4:
                System.out.println(">> CÚMPLICE <<");break;
            case 5:
                System.out.println(">> ASSASINO <<"); break;
            default:
                System.out.println(">> INOCENTE <<"); break;
        }
    }
}
