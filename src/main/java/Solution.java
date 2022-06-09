import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static int[] getField(String creature, String str) {
        int[] field = new int[16];
        try {
            File input = new File("src/main/resources/cost_of_the_path");
            FileReader fr = new FileReader(input);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();//считываем типы клеток
            String[] typeOfMoving = line.split(",");
            Map<String, Map<String, Integer>> costTable = new HashMap();//представление таблицы стоимости из файла resources/cost_of_the_path
            while ((line = reader.readLine()) != null) {//считываем стоимость перемещения для каждого существа
                String[] costOfMoving = line.split(",");
                Map<String, Integer> cost = new HashMap<>();
                for (int i = 1; i < typeOfMoving.length; i++)
                    cost.put(typeOfMoving[i], Integer.parseInt(costOfMoving[i]));
                costTable.put(costOfMoving[0], cost);
            }

            String[] stringField = str.split("");
            for (Map.Entry entry : costTable.entrySet()) {//создаем новое поле под переданные параметры
                if (entry.getKey().equals(creature)) {
                    for (int i = 0; i < 16; i++) {
                        for (Map.Entry entry2 : ((Map<String, Integer>) entry.getValue()).entrySet()) {
                            if (entry2.getKey().equals(stringField[i]))
                                field[i] = (Integer) entry2.getValue();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return field;
    }

    public static int getResult(String creature, String stringField) {
        int[] field = getField(creature, stringField);//создаем поле со стоимостями для существа
        Node[] arr = Node.createGraph(field);//строим граф поля
        return AStar.aStar(arr[0], arr[15]);//ищем минимальный путь, используя алгоритм А*
    }

    public static void main(String[] args) {
        System.out.println(getResult("Swamper", "STWSWTPPTPTTPWPP"));
    }
}