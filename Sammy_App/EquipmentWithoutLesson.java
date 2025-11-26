public class EquipmentWithoutLesson extends Equipment {
	
	public EquipmentWithoutLesson(int type, EquipmentAndValues values) {
		super(type, values);
		validateEquipmentType();
	}

	private void validateEquipmentType() {
		if (getType() >= 1 && getType() <= 5) {
			throw new InvalidEquipmentException(getType(), "Habilitar incluir aula");
		}
	}
}