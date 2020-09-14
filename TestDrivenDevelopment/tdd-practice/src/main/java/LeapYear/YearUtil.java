package LeapYear;

public class YearUtil {
	public boolean isLeapYear(long year) {
		if (year < 0) {
			throw new IllegalArgumentException("Negative year is not a valid input");
		} else {
			boolean isLeap = false;
			if (year % 4 == 0) {
				if (year % 100 == 0) {
					if (year % 400 == 0)
						isLeap = true;
					else
						isLeap = false;
				} else
					isLeap = true;
			} else {
				isLeap = false;
			}
			return isLeap;
		}
	}
}
