import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("HP", "Windows", 8, 500, "red");
        Laptop laptop2 = new Laptop("Lenovo", "Linux", 12, 1000, "grey");
        Laptop laptop3 = new Laptop("ASUS", "Windows", 64, 2000, "red");
        Laptop laptop4 = new Laptop("Acer", "Android", 32, 4000, "black");
        Laptop laptop5 = new Laptop("Dell", "Linux", 4, 800, "green");
        Laptop laptop6 = new Laptop("Sony", "Windows", 16, 1400, "red");
        Laptop laptop7 = new Laptop("Apple", "iOS", 8, 1500, "yellow");
        Laptop laptop8 = new Laptop("Dell1", "Linux", 12, 1000, "grey");
        Laptop laptop9 = new Laptop("Dell", "Windows", 64, 2000, "red");
        Set<Laptop> setLaptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7, laptop8, laptop9));
        for (Laptop l : setLaptops) {
            System.out.println(l);

        }
        filterLaptops(setLaptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        
        System.out.println("Выберите критерии фильтрации и введите минимальные значения:");
        System.out.println("1 - Марка ноутбука");
        System.out.println("2 - Операционная система");
        System.out.println("3 - Объем RAM");
        System.out.println("4 - Объем HDD");
        System.out.println("5 - Цвет");
        System.out.println("0 - Завершить выбор критериев");

        int variant;
        do {
            System.out.print("Введите номер критерия (0 для завершения): ");
            variant = scanner.nextInt();
            if (variant == 0)
                break;
            switch (variant) {
                case 1:
                    System.out.print("Введите марку ноутбука: ");
                    String name = scanner.next();
                    filters.put("name", name);
                    break;
                case 2:
                    System.out.print("Введите операционную систему: ");
                    String os = scanner.next();
                    filters.put("system", os);
                    break;

                case 3:
                    System.out.print("Введите минимальный объем RAM GB: ");
                    int minRam = scanner.nextInt();
                    filters.put("sizeRam", minRam);
                    break;
                case 4:
                    System.out.print("Введите минимальный объем HDD GB: ");
                    int minHdd = scanner.nextInt();
                    filters.put("sizeHdd", minHdd);
                    break;
                case 5:
                    System.out.print("Введите цвет: ");
                    String color = scanner.next();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Неверный ввод!");
            }
        } while (variant != 0);

        
        List<Laptop> filteredLaptops = filter(laptops, filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, удовлетворяющих заданным критериям.");
        } else {
            System.out.println("Ноутбуки, удовлетворяющие критериям:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    public static List<Laptop> filter(Set<Laptop> laptops, Map<String, Object> filters) {
        List<Laptop> result = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean flag = true;
            for (String key : filters.keySet()) {
                Object value = filters.get(key);
                
                switch (key) {
                    case "name":
                        if (!laptop.getName().equalsIgnoreCase((String) value)) {
                            flag = false;
                        }
                        break;

                    case "system":
                        if (!laptop.getSystem().equalsIgnoreCase((String) value)) {
                            flag = false;
                        }
                        break;
                    case "sizeRam":
                        if (laptop.getSizeRam() < (int) value) {
                            flag = false;
                        }
                        break;
                    case "sizeHdd":
                        if (laptop.getSizeHdd() < (int) value) {
                            flag = false;
                        }
                        break;

                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase((String) value)) {
                            flag = false;
                        }
                        break;
                }
            }
            if (flag) {
                result.add(laptop);
            }
        }
        return result;
    }

}
