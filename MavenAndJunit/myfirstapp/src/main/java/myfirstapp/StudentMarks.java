package myfirstapp;

public class StudentMarks {
	private String name;
	private int mathsMarks;
	private int englishMarks;
	private int scienceMarks; 
	
	StudentMarks() {
		this.name = "abc";
		this.mathsMarks = 0;
		this.englishMarks = 0;
		this.scienceMarks = 0;
	}

	public void setName(String name) {

		if (name.equals("")) {
			throw new InvalidNameException("Name can not be empty");
		} else {
			this.name = name;
		}
	}

	public void setDetails(String name, int mathsMarks, int englishMarks, int scienceMarks) {
		this.name = name;
		this.mathsMarks = mathsMarks;
		this.englishMarks = englishMarks;
		this.scienceMarks = scienceMarks;
	}

	public int getTotal() {
		return this.mathsMarks + this.englishMarks + this.scienceMarks;
	}

	public boolean checkIfPass(int inputTotal) {
		if (inputTotal < 35)
			return false;
		else
			return true;
	}

}
