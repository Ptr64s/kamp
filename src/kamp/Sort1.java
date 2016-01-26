package kamp;

public class Sort1 {
	public static void main(String[] args) {
		String tmp = "160201 kl.16:00 - 160201 kl.21:00" + "\n" + "160205 kl.13:00 - 160205 kl.16:00" + "\n"
				+ "160205 kl.14:00 - 160205 kl.17:00" + "\n" + "160226 kl.10:00 - 160226 kl.15:00" + "\n"
				+ "160226 kl.11:00 - 160226 kl.12:00" + "\n" + "";
		String tmp1 = tmp.replace("\n", " ").replace("- ", "").replace("kl.", "");
		
		System.out.println(tmp1);
		System.out.println("Första mangeln");
		

		String[] inputArray1 = tmp1.split(" ");
		// System.out.println(inputArray1);
		// printArray(inputArray1);
		for (int i = 0; i < inputArray1.length - 4; i = i + 4) {
			// System.out.println("ej");
			if (inputArray1[i].equals(inputArray1[i + 4])) {
				// System.out.println("hej");
				if (inputArray1[i + 3].compareTo(inputArray1[i + 5]) >= 0) {
					inputArray1[i + 5] = inputArray1[i + 1];
					// System.out.println(inputArray1[i+5] + " " +
					// inputArray1[i+1]);

				}
			}

		}
		printArray(inputArray1);
		// System.out.println(inputArray1);
		System.out.println("Andra mangeln");
		for (int i = 0; i < inputArray1.length - 4; i = i + 4) {
			if (inputArray1[i].equals(inputArray1[i + 4])) {
				if (inputArray1[i + 1].equals(inputArray1[i + 5])) {
					if (inputArray1[i + 3].compareTo(inputArray1[i + 7]) < 0) {
						inputArray1[i + 3] = inputArray1[i + 7];
					}
				}
			}
		}
		printArray(inputArray1);
		System.out.println("Tredje mangeln");
	}

	private static void printArray(String[] inputArray1) {
		for (int i = 0; i < inputArray1.length - 3; i = i + 4) {
			System.out.println(
					inputArray1[i] + " " + inputArray1[i + 1] + " " + inputArray1[i + 2] + " " + inputArray1[i + 3]);

		}
	}

}

// > Sort1 arg1 arg2 arg3