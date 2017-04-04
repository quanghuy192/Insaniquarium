import java.util.Random;

public class RandomUtilities {

	private static final Random r = new Random();

	private RandomUtilities() {
	}

	public static int getXPosition(int x) {
		int sign = r.nextInt(2);
		return (sign % 2 == 0) ? x + 1 : x - 1;
	}
}
