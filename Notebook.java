public class Notebook {
	protected String modelName;
	protected int ram;
	protected int HDCapacity;
	protected String opSys;
	protected String color;
	protected Double screenDiagonal;

	public Notebook(String modelName, int ram, int HDCapacity, String opSys, String color, Double screenDiagonal) {
		this.modelName = modelName;
		this.ram = ram;
		this.HDCapacity = HDCapacity;
		this.opSys = opSys;
		this.color = color;
		this.screenDiagonal = screenDiagonal;
	}

	void getAll() {
		System.out.println("Модель ноутбука: " + modelName);
		System.out.println("Объем ОЗУ, Гб: " + ram);
		System.out.println("Объем жесткого диска, Гб: " + HDCapacity);
		System.out.println("Операционная система: " + opSys);
		System.out.println("Цвет: " + color);
		System.out.println("Диагональ экрана: " + screenDiagonal);
	}
}