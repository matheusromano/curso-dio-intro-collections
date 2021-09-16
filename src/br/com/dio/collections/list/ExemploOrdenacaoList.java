package br.com.dio.collections.list;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        List<Cachorro> meusCachorros = new ArrayList<>(){{
            add(new Cachorro("Augusto", 10, "amarelo"));
            add(new Cachorro("Augusto", 12, "preto"));
            add(new Cachorro("Augusto", 7, "branco"));

        }};
        System.out.println("Ordem de inserção: ");
        System.out.println(meusCachorros);

        System.out.println("Ordem aleatória: ");
        Collections.shuffle(meusCachorros);
        System.out.println(meusCachorros);

        System.out.println("Ordem natural (nomes): ");
        Collections.sort(meusCachorros);
        System.out.println(meusCachorros);

        System.out.println("Ordem por idade: ");
        Collections.sort(meusCachorros, new ComparatorIdade());
        meusCachorros.sort(new ComparatorIdade());
        System.out.println(meusCachorros);

        System.out.println("Ordem por cor: ");
        Collections.sort(meusCachorros, new ComparatorCor());
        meusCachorros.sort(new ComparatorCor());
        System.out.println(meusCachorros);

        System.out.println("Ordem por nome/idade/cor");
//        meusCachorros.sort(new ComparatorNomeIdadeCor());
        Collections.sort(meusCachorros, new ComparatorNomeIdadeCor());
        System.out.println(meusCachorros);

    }
}

class Cachorro implements Comparable<Cachorro>{
    private String nome;
    private Integer idade;
    private String cor;

    public Cachorro(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cachorro cachorro) {
        return this.getNome().compareToIgnoreCase(cachorro.getNome());
    }
}

class ComparatorIdade implements Comparator<Cachorro> {

    @Override
    public int compare(Cachorro c1, Cachorro c2) {
        return Integer.compare(c1.getIdade(),  c2.getIdade());
    }
}

class ComparatorCor implements Comparator<Cachorro> {

    @Override
    public int compare(Cachorro c1, Cachorro c2) {
        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }
}

class ComparatorNomeIdadeCor implements Comparator<Cachorro> {

    @Override
    public int compare(Cachorro c1, Cachorro c2) {
        int nome = c1.getNome().compareToIgnoreCase(c2.getNome());
        if (nome != 0) return nome;

        int idade = c1.getIdade().compareTo(c2.getIdade());
        if (idade != 0) return idade;

        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }
}

