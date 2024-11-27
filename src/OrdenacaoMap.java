import java.util.*;

public class OrdenacaoMap {

    public static void main(String[] args) {
        System.out.println("--\t Ordem aleatória \t");

        Map<String, Livro> meusLivros = new HashMap<>() {{
            put(" Hawking, Stephen", new Livro("Uma Breve História do tempo", 256));
            put(" Duhigg, Charles", new Livro("O poder do Hábito", 408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};

        for (Map.Entry<String, Livro> livro:meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("------------------------------------------------------------------");
        System.out.println("--\t Ordem inserção \t");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put(" Hawking, Stephen", new Livro("Uma Breve História do tempo", 256));
            put(" Duhigg, Charles", new Livro("O poder do Hábito", 408));
            put(" Harari, Yuval Noah", new Livro("21 lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro:meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("------------------------------------------------------------------");
        System.out.println("--\t Ordem alfabética autores\t");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);
        for (Map.Entry<String, Livro> livro:meusLivros3.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("------------------------------------------------------------------");
        System.out.println("--\t Ordem alfabética nomes dos livros \t");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("------------------------------------------------------------------");
        System.out.println("--\t Ordem número de página \t");

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);

    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }

}
 class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

     @Override
     public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
         return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
     }
 }