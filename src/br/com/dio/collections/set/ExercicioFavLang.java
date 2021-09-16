package br.com.dio.collections.set;

import java.util.*;

public class ExercicioFavLang {
    public static void main(String[] args) {
        System.out.println("--\tOrdem inserção\t--");
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>() {{
            add(new LinguagemFavorita("Java", 1991, "Intellij"));
            add(new LinguagemFavorita("Python", 1989, "VSCode"));
            add(new LinguagemFavorita("PHP", 1994, "Eclipse"));
        }};
        for (LinguagemFavorita linguagem: linguagens) System.out.println(linguagem.getNome()  + " - "
                + linguagem.getAnoDeCriacao() + " - " + linguagem.getIde());

        System.out.println("--\tOrdem Natural (nome)\t--");
        Set<LinguagemFavorita> linguagens1 = new TreeSet<>(linguagens);
        for (LinguagemFavorita linguagem: linguagens1) System.out.println(linguagem.getNome()  + " - "
                + linguagem.getAnoDeCriacao() + " - " + linguagem.getIde());

        System.out.println("--\tOrdem por IDE\t--");
        Set<LinguagemFavorita> linguagens2 = new TreeSet<>(new ComparatorIde());
        linguagens2.addAll(linguagens);
        for (LinguagemFavorita linguagem: linguagens2) System.out.println(linguagem.getNome()  + " - "
                + linguagem.getAnoDeCriacao() + " - " + linguagem.getIde());

        System.out.println("--\tOrdem por Ano de Criação e Nome\t--");
        Set<LinguagemFavorita> linguagens3 = new TreeSet<>(new ComparatorAnoENome());
        linguagens3.addAll(linguagens);
        for (LinguagemFavorita linguagem: linguagens3) System.out.println(linguagem.getNome()  + " - "
                + linguagem.getAnoDeCriacao() + " - " + linguagem.getIde());

        System.out.println("--\tOrdem por Nome, Ano de Criação e IDE\t--");
        Set<LinguagemFavorita> linguagens4 = new TreeSet<>(new ComparatorNomeAnoIde());
        linguagens4.addAll(linguagens);
        for (LinguagemFavorita linguagem: linguagens4) System.out.println(linguagem.getNome()  + " - "
                + linguagem.getAnoDeCriacao() + " - " + linguagem.getIde());



    }





}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public String toString() {
        return "{" +
                "Linguagem = '" + nome + '\'' +
                ",Ano de Criação = " + anoDeCriacao +
                ",IDE = '" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita o) {return this.nome.compareTo(o.nome);}
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class ComparatorAnoENome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class ComparatorNomeAnoIde implements  Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (nome != 0) return nome;

        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        return  o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}