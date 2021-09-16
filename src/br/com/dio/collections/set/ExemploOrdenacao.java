package br.com.dio.collections.set;

import java.io.File;
import java.util.*;

public class ExemploOrdenacao {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Set<Filme> meusFilmes = new HashSet<>() {{
            add(new Filme("As intocáveis", "Drama", 120));
            add(new Filme("Zocurando Nemo", "Animação", 100));
            add(new Filme("O Show de Truman", "Comédia", 150));
        }};
        for (Filme filme: meusFilmes) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());

        System.out.println("--\tOrdem inserção\t--");
        Set<Filme> meusFilmes1 = new LinkedHashSet<>() {{
            add(new Filme("Os intocáveis", "Drama", 120));
            add(new Filme("Procurando Nemo", "Animação", 100));
            add(new Filme("O Show de Truman", "Comédia", 150));
        }};
        for (Filme filme: meusFilmes1) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());

        System.out.println("--\tOrdem natural (Tempo de Filme)\t--");
        Set<Filme> meusFilmes2 = new TreeSet<>(meusFilmes1);
        for (Filme filme: meusFilmes2) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());

        System.out.println("--\tOrdem Nome/Gênero/Duração do Filme\t--");
        Set<Filme> meusFilmes3 = new TreeSet<>(new ComparatorNomeGeneroDuracaoFilme());
        meusFilmes3.addAll(meusFilmes);
        for (Filme filme: meusFilmes3) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());

        System.out.println("--\tOrdem por gênero\t--");
        Set<Filme> meusFilmes4 = new TreeSet<>(new ComparatorGenero());
        meusFilmes4.addAll(meusFilmes);
        for (Filme filme: meusFilmes4) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());

        System.out.println("--\tOrdem por Nome\t--");
        Set<Filme> meusFilmes5 = new TreeSet<>(new ComparatorNome());
        meusFilmes5.addAll(meusFilmes);
        for (Filme filme: meusFilmes5) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());

        System.out.println("--\tOrdem por Idade\t--");
        Set<Filme> meusFilmes6 = new TreeSet<>(new ComparatorIdade());
        meusFilmes6.addAll(meusFilmes);
        for (Filme filme: meusFilmes6) System.out.println(filme.getNome()  + " - "
                + filme.getGenero() + " - " + filme.getduracaoFilme());
    }
}

class Filme  implements Comparable<Filme> {
    private final String nome;
    private  final String genero;
    private  final Integer duracaoFilme;

    public Filme(String nome, String genero, Integer duracaoFilme) {
        this.nome = nome;
        this.genero = genero;
        this.duracaoFilme = duracaoFilme;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getduracaoFilme() {
        return duracaoFilme;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", duracaoFilme=" + duracaoFilme +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme Filme = (Filme) o;
        return Objects.equals(nome, Filme.nome) && Objects.equals(genero, Filme.genero) && Objects.equals(duracaoFilme, Filme.duracaoFilme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, duracaoFilme);
    }

    @Override
    public int compareTo(Filme filme) {
        int duracaoFilme = Integer.compare(this.getduracaoFilme(), filme.getduracaoFilme());
        if (duracaoFilme != 0) return duracaoFilme;

        return this.getGenero().compareTo(filme.getGenero());
    }

}

class  ComparatorNomeGeneroDuracaoFilme implements Comparator<Filme>{

    @Override
    public int compare(Filme o1, Filme o2) {
         int nome = o1.getNome().compareTo(o2.getNome());
         if (nome != 0) return nome;

         int genero = o1.getGenero().compareTo(o2.getGenero());
         if (genero != 0) return genero;

         return Integer.compare(o1.getduracaoFilme(), o2.getduracaoFilme());
    }
}

class ComparatorGenero implements Comparator<Filme> {

    @Override
    public int compare(Filme o1, Filme o2) {return o1.getGenero().compareToIgnoreCase(o2.getGenero());}
}

class ComparatorNome implements Comparator<Filme> {

    @Override
    public int compare(Filme o1, Filme o2) {return o1.getNome().compareToIgnoreCase(o2.getNome());}
}

class ComparatorIdade implements Comparator<Filme> {

    @Override
    public int compare(Filme o1, Filme o2) {return Integer.compare(o1.getduracaoFilme(), o2.getduracaoFilme());}
}