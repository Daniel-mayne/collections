import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(carrosPopulares.toString());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba o consumo do gol: " + carrosPopulares.get("uno"));

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba o terceiro modelo adicionado: ");

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba o consumo dos carros: " + carrosPopulares.values());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");

        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println(modeloMaisEficiente);
                System.out.println(consumoMaisEficiente);
            }
        }


        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba o modelo menos econômico e seu consumo: ");

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }


        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba a soma dos consumo: ");

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("A soma do consumo: " + soma);


        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + soma / carrosPopulares.size());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {

            if (iterator1.next().equals(15.6)) {
                iterator1.remove();
            }
        }
        System.out.println(iterator1);

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Apague o conjunto de carros: ");
        carrosPopulares.clear();

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Confira se a lista esta vazia: " +  carrosPopulares.isEmpty());

    }
}
