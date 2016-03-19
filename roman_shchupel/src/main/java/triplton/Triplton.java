package triplton;

public class Triplton {

	private final static int MAX_INST = 3;
	private static Triplton[] instance = new Triplton[MAX_INST];

	private Triplton() {

	}

	public static Triplton GetInstance() {

		for (int i = 0; i < MAX_INST; i++) {
			if (instance[i] == null) {
				instance[i] = new Triplton();
				return instance[i];
			}
		}


		return instance[MAX_INST-1];

	}
}
