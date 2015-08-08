public class Utilities {
	private static char[] intToHexBuffer;

	public static boolean[] intToBinaryArrayFixedWidth(int i, int w) {
		if (w < 0) {
			return null;
		}
		boolean[] t = intToBinaryArray(i);
		if (t.length > w) {
			boolean[] result = new boolean[w];
			System.arraycopy(t, 0, result, 0, w);
			return result;
		}
		if (t.length < w) {
			boolean[] result = new boolean[w];
			System.arraycopy(t, 0, result, 0, t.length);
			return result;
		}
		return t;
	}

	public static boolean bitAt(int number, int bitPosition)
			throws IllegalArgumentException {
		if (bitPosition >= 0) {
			return (number >> bitPosition & 0x1) == 1;
		}
		throw new IllegalArgumentException();
	}

	public static boolean[] intToBinaryArray(int n) {
		int l = 0;
		int nShifted = n;
		while (nShifted != 0) {
			l++;
			nShifted >>>= 1;
		}
		if (l == 0) {
			return new boolean[1];
		}
		boolean[] result = new boolean[l];
		for (int i = 0; i < l; i++) {
			result[i] = (((n >> i & 0x1) == 1) ? true : false);
		}
		return result;
	}

	public static int binaryArrayToInt(boolean[] arr) {
		int result = 0;
		int i = 0;
		while (i < arr.length) {
			result += ((arr[i] != false) ? 1 << i : 0);
			i++;
		}
		return result;
	}

	public static int intFromIntegerSubset(int n, int from, int till)
			throws IllegalArgumentException {
		int result = 0;
		int i = 0;
		if (from <= till) {
			while (from + i <= till) {
				result += (bitAt(n, from + i) ? 1 << i : 0);
				i++;
			}
			return result;
		}
		throw new IllegalArgumentException();
	}

	private static final char[] hexChars = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static synchronized String intToHexFixedWidth(int num, int w) {
		if (w < 0) {
			return null;
		}
		if ((intToHexBuffer == null) || (intToHexBuffer.length < w)) {
			intToHexBuffer = new char[w];
		}
		for (int i = 0; i < w; i++) {
			intToHexBuffer[(w - i - 1)] = hexChars[(num >>> 4 * i & 0xF)];
		}
		return new String(intToHexBuffer, 0, w);
	}
}
