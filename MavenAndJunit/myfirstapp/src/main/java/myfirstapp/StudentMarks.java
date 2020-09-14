package myfirstapp;

public class StudentMarks {
	private String name;
	private int mathsMarks;
	private int englishMarks;
	private int scienceMarks;

	StudentMarks(String name, int mathsMarks, int englishMarks, int scienceMarks) {
		if (name.equals("")) {
			throw new InvalidNameException("Name can not be empty");
		} else {
			this.name = name;
		}

		if (mathsMarks < 0 || englishMarks < 0 || scienceMarks < 0) {
			throw new IllegalArgumentException("Marks can not be negative");
		}

		else {
			this.mathsMarks = mathsMarks;
			this.englishMarks = englishMarks;
			this.scienceMarks = scienceMarks;
		}
	}

	public void setName(String name) {

		if (name.equals("")) {
			throw new InvalidNameException("Name can not be empty");
		} else {
			this.name = name;
		}
	}

	public int getTotal() {
		return this.mathsMarks + this.englishMarks + this.scienceMarks;
	}

	public boolean checkIfPass(int n) {
		if (n < 35)
			return false;
		else
			return true;
	}
//
}
