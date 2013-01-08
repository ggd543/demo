package encryption;

public class A9Utility {

	public static String bytesToHex(byte[] b) {
		String s = "";
		for (int i = 0; i < b.length; i++) {
			if (i > 0 && i % 4 == 0) {
				s += " ";
			}
			s += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return s;
	}

	public static byte[] hexToBytes(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < s.length(); i+=2) {
			b[i/2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
		}
		return b;
	}

	public static byte[] intToBytes(int i) {
		byte[] b = new byte[4];
		for (int c = 0; c < 4; c++) {
			b[c] = (byte) ((i >>> (56 - 8 * c)) & 0xff);
		}
		return b;
	}

	public static int bytesToInt(byte[] b) {
		return ((b[0] << 24) & 0xff000000) | ((b[1] << 16) & 0xff0000) | ((b[2] << 8) & 0xff00) | (b[3] & 0xff);
	}

	public static byte[] longToBytes(long l) {
		byte[] b = new byte[8];
		for (int c = 0; c < 8; c++) {
			b[c] = (byte) ((l >>> (56 - 8 * c)) & 0xffL);
		}
		return b;
	}

	public static boolean[] byteToBits(byte b) {
		boolean[] bits = new boolean[8];
		for (int i = 0; i < 8; i++) {
			bits[7-i] = ((b & (1 << i)) != 0);
		}
		return bits;
	}

	public static byte[] bitsTo8Bytes(boolean[] bits) {
		byte[] b = new byte[8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				b[i] += (((bits[(8*i)+j])?1:0) << (7-j));
			}
		}

		return b;
	}

	public static int getBit(int x, int i) {
		return (x >>> i) & 0x01;
	}

	public static int getBit(int[] x, int i) {
		return (x[i / 32] >>> (i % 32)) & 0x01;
	}
	
	public static void setBit(int[] x, int i, int v) {
		if ((v & 0x01) == 1)
			x[i / 32] |= 1 << (i % 32); // set it
		else
			x[i / 32] &= ~(1 << (i % 32)); // clear it
	}
	
	public static int getNibble(int x, int i) {
		return (x >>> (4 * i)) & 0x0F;
	}
	
}
