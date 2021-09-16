package br.com.dio.collections.set;

import java.util.*;

public class ExercicioCores {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>(Arrays.asList("Branco", "Amarelo", "Azul", "Violeta", "Vermelho", "Verde", "Anil", "Laranja"));

        System.out.println("Exibir as cores uma abaixo da outra: ");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("Exibir a quantidade de cores existestes: " + cores.size());

        System.out.println("Exiba todas as cores na ordem alfabetica: ");
        Set<String> cores2 = new TreeSet<>(cores);
        System.out.println(cores2);

        System.out.println("Exiba as cores na ordem inversa da que foi informada ");
        List<String> coresList = new ArrayList<>(cores2);
        Collections.reverse(coresList);
        System.out.println(coresList);

        System.out.println("Exiba todas as cores que começam com a letra 'V': ");
        for(String cor : cores) {
            if(cor.startsWith("V")) System.out.println(cor);
        }

        System.out.println("Remova todas as cores que não começam com a letra “v”: ");
        Iterator<String> iterator2 = cores.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().startsWith("V")) iterator2.remove();
        }
        System.out.println(cores);

//        System.out.println("Exclua todas as cores que nao começam com 'V': ");
//        Iterator<String> cores4 = cores.iterator();
//        while (cores4.hasNext()) {
//            String next = cores4.next();
//            if (!next.startsWith("V")) cores4.remove();
//        }
//        System.out.println(cores);

        cores.clear();

        System.out.println("confira se o conjunto esta vazio: " + cores.isEmpty());
    }


}

