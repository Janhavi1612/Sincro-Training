package LeapYear;

public class YearUtil {
	public boolean isLeapYear(long year) {
		if (year < 0) {
			throw new IllegalArgumentException("Negative year is not a valid input");
		} else {
			boolean isLeap = false;

			if ((year % 4 == 0 && year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
				isLeap = true;
			}

			return isLeap;
		}
	}
}
