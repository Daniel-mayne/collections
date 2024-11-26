import java.sql.SQLOutput;
import java.util.*;

public class ExemploList {

    public static void main(String[] args) {
        //Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

        //List notas = new ArrayList();
        //List<Double> notas = new ArrayList<>();
        //ArrayList<Double> notas = new ArrayList<>();
        //List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        //List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        //notas.add(10d);
        //System.out.println(notas);

        //List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        //notas.add(1d);
        //notas.remove(5d);
        //System.out.println(notas);

       /* System.out.println("Crie uma Lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.6);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(4.6);

        System.out.println(notas);
        System.out.println("Exibe a posição da nota 5.0: " + notas.indexOf(5d));

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8.0);
        System.out.println(notas);


        System.out.println("Substitua a nota 5.0 pela 6.0: ");
        notas.set(3, 6.0);
        System.out.println(notas);

        System.out.println("Confira se tem 5.0 na lista: " + notas.contains(5.0));

        System.out.println("Exiba todas as notas na ordem que foram informadas: ");
        for (Double nota : notas) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        //System.out.println("Exibe a soma das notas: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("Exibe a soma das notas: " + soma);

        System.out.println("Exibe a média das notas: " + (soma / notas.size()));

        notas.remove(0d);
        System.out.println("Remova a nota 0: " + notas);


        notas.remove(0);
        System.out.println("Remova a nota na posição 0: " + notas);

        System.out.println("Remova as notas menores que 7");

        Iterator<Double> indice = notas.iterator();
        while (indice.hasNext()) {
            Double next = indice.next();
            if (next < 7) {
                indice.remove();
            }
        }
        System.out.println(notas);

        //  System.out.println("Apague toda a lista");
        // notas.clear();

        System.out.println("Confira se a lista esta vazia: " + notas.isEmpty());
*/


        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("aniel", 13, "Amarelo"));
            add(new Gato("Bryan", 29, "Branco"));
            add(new Gato("Mariana", 21, "Preto"));
        }};
        System.out.println(meusGatos); //ordem de inserção


        Collections.shuffle(meusGatos);  // ordem aleatoria
        System.out.println(meusGatos);

        Collections.sort(meusGatos);  // ordem natural
        System.out.println(meusGatos);

        //Collections.sort(meusGatos, new ComparatorIdade()); // ordem idade
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        //ordem cor
        Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        // ordem por nome, cor e idade

        //Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);
    }
}

class Gato implements Comparable<Gato>{

    private  String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
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
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }


}

class ComparatorIdade implements  Comparator<Gato>{
    @Override
    public int compare(Gato gato1, Gato gato2){
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }
}

class ComparatorCor implements  Comparator<Gato>{
    @Override
    public int  compare(Gato gato1, Gato gato2){
return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato gato1, Gato gato2){
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());
        if (nome != 0) return nome;
        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());
        if (cor != 0) return  cor;
         return Integer.compare(gato1.getIdade(), gato2.getIdade());

    }
}