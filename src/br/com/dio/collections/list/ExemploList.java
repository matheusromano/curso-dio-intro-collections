package br.com.dio.collections.list;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        System.out.println("Crie uma lista  e adcione as sete notas: ");
        List<Double> notas = new ArrayList<>();
        notas.add(5d);
        notas.add(2d);
        notas.add(6d);
        notas.add(8d);
        notas.add(4d);
        notas.add(5d);
        notas.add(2d);

        System.out.println(notas.toString()); //exibe todas as notas

        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(4d));

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8.9);
        System.out.println(notas);

        System.out.println("Substitua a nota 2.0 pelo valor 9.5: ");
        notas.set(notas.indexOf(2d), 9.5);
        System.out.println(notas);

        System.out.println("Confira se a nota 3.0 existe na tabela: " + notas.contains(3d));

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota : notas) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota 6.0: ");
        notas.remove(6d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

//        System.out.println("Apague toda a lista");
//        notas.clear();
//        System.out.println(notas);
//
//        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());

        LinkedList<Double> notas2 = new LinkedList<>();

        System.out.println("Cria uma lista e add os elementos da outra lista: " + notas2.addAll(notas));
        System.out.println(notas2);

        System.out.println("Mostre a primeira nota da lista sem removê-la: " + notas2.peekFirst());
        System.out.println(notas2);

        System.out.println("Mostre a primeira nota da lista removendo-a: " + notas2.pollFirst());
        System.out.println(notas2);






    }
}
