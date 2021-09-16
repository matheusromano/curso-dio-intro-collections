package br.com.dio.collections.map;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class ExercicioPopulacao {
    public static void main(String[] args) {
        System.out.println("Crie um dicionario que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> estadosPopulacao = new HashMap<>(){{
            put("RS", 10693929);
            put("SC", 6248436);
            put("PR", 10444526);

        }};

        System.out.println("Substitua a populacao do PR para 10.500.000 ");
        estadosPopulacao.put("PR", 10500000);
        System.out.println(estadosPopulacao);

        System.out.println("Confira se SP esta no dicionario se nao inclua SP - 12.396.372 ");
        if (estadosPopulacao.containsKey("SP") == false) {estadosPopulacao.put("SP", 12396372);}
        System.out.println(estadosPopulacao);

        System.out.println("Exiba a populacao de SC: " + estadosPopulacao.get("SC"));

        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> estadoPopulacao2 = new LinkedHashMap<>() {{
            put("RS", 10693929);
            put("SC", 6248436);
            put("PR", 10444526);
            put("SP", 12396372);
        }};
        System.out.println(estadoPopulacao2);

        System.out.println("Exiba todos os estados e suas populaçãos em ordem alfabetica: ");
        Map<String, Integer> estadosPopulacao3 = new TreeMap<>(estadoPopulacao2);
        System.out.println(estadosPopulacao3);

        Collection<Integer> populacao = estadoPopulacao2.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";

        for(Map.Entry<String, Integer> entry : estadoPopulacao2.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenorPopulacao = entry.getKey();

        }

        System.out.printf("Exiba o estado com o menor população (%s) e seu respectivo valor (%d)\n",
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("Exiba o estado com a maior população (%s) e seu respectivo valor (%d)\n",
                estadoMaiorPopulacao, Collections.max(populacao));

        int soma = 0;
        Iterator<Integer> iterator = estadoPopulacao2.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);

        System.out.println("Exiba a média da população deste dicionário de estados: " + (soma / estadoPopulacao2.size()));

        Iterator<Integer> iterator1 = estadoPopulacao2.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 10000000) iterator1.remove();
        }
        System.out.println(estadoPopulacao2);

        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        estadosPopulacao.clear();
        System.out.println(estadosPopulacao);

        System.out.println("Confira se a lista está vazia: " + estadosPopulacao.isEmpty());
    }
}

