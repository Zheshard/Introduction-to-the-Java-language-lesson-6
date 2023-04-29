import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class task_1 {
	public static void main(String[] args) {
		List<Notebook> laptops = initListNotebooks();
		HashMap<Integer, String> parametrs = params();
		filter(parametrs, laptops);
	}

	// Метод создания массива ноутбуков с использованием объекта Notebook:
	public static ArrayList<Notebook> initListNotebooks() {
		ArrayList<Notebook> notebooks = new ArrayList<>();
		Notebook note1 = new Notebook("Apple Macbook Pro 16", 16, 512, "macOS", "серый космос", 16.2);
		Notebook note2 = new Notebook("Lenovo IdeaPad 1 15ALC7", 8, 512, "Windows", "cloud grey", 15.6);
		Notebook note3 = new Notebook("ASUS X515JA-EJ1814", 8, 256, "Windows", "синий", 15.6);
		Notebook note4 = new Notebook("Acer Nitro 5 AN515-57", 16, 512, "Windows", "черный", 15.6);
		Notebook note5 = new Notebook("Apple MacBook Air 13 Late", 8, 256, "macOS", "серый космос", 13.3);
		Notebook note6 = new Notebook("ASUS Vivobook 15 M1502", 8, 512, "Windows", "серебристый", 15.6);
		notebooks.add(note1);
		notebooks.add(note2);
		notebooks.add(note3);
		notebooks.add(note4);
		notebooks.add(note5);
		notebooks.add(note6);
		return notebooks;
	}

	// Метод, запрашивающий критерии поиска ноутбуков. Критерии формируются в Map,
	// где ключ - цифра, введенная пользователем и соответсвующая критерию. Значение
	// Map - минимальное значение параметра, введенное пользователем:
	public static HashMap<Integer, String> params() {
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, String> mapParam = new HashMap<>();
		while (true) {
			System.out.println(
					"Введите цифру, соответствующую необходимому критерию: \n1 - Объем ОЗУ, Гб.\n2 - Объем жесткого диска, Гб.\n3 - Операционная система.\n4 - Цвет.\n5 - Диагональ экрана.\n0 - Завершить выборку и вывести результат.");
			int n = scanner.nextInt();
			scanner.nextLine();
			if (n == 0) {
				break;
			} else if (n < 1 || n > 5) {
				System.out.println("Введено неверное значение.");
			} else {
				System.out.println("Введите значение параметра: ");
				String param = scanner.nextLine();
				mapParam.put(n, param);
			}
		}
		return mapParam;
	}

	// Метод, принимающий Map ноутбуков и Map параметров поиска. Метод возвращает
	// список ноутбуков, удовлетворяющих запрсоу пользователя:
	public static void filter(HashMap<Integer, String> params, List<Notebook> notebooks) {
		System.out.println("Результаты поиска: ");
		for (Notebook notebook : notebooks) {
			boolean coincidence = true;
			for (int key : params.keySet()) {
				switch (key) {
					case (1):
						if (notebook.ram < Integer.parseInt(params.get(key))) {
							coincidence = false;
						}
						break;
					case (2):
						if (notebook.HDCapacity < Integer.parseInt(params.get(key))) {
							coincidence = false;
						}
						break;
					case (3):
						if (!notebook.opSys.equals(params.get(key))) {
							coincidence = false;
						}
						break;
					case (4):
						if (notebook.color.equals(params.get(key))) {
							coincidence = false;
						}
						break;
					case (5):
						if (notebook.screenDiagonal < Double.parseDouble(params.get(key))) {
							coincidence = false;
						}
						break;
				}
			}
			if (coincidence) {
				notebook.getAll();
				System.out.println();
			}
		}
	}
}