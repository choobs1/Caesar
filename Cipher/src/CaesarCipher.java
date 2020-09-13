
public class CaesarCipher {
	
	public static void main (String[] args) {
		testCipher2();
	}
	
	public String encrypt(String input, int key) {
		StringBuilder encrypted = new StringBuilder(input);
		String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlph = alph.substring(key) + alph.substring(0,key);
		
		for (int i = 0 ; i < encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			int idx = alph.indexOf(Character.toUpperCase(currChar));
			if (idx != -1) {
				char newChar = shiftAlph.charAt(idx);
				if (Character.isLowerCase(currChar)) 
					encrypted.setCharAt(i, Character.toLowerCase(newChar));
				else
					encrypted.setCharAt(i, newChar);	
			}
		}
		
		return encrypted.toString();
	}
	
	public String encryptTwo(String input, int key1, int key2) {
		StringBuilder encrypted = new StringBuilder(input);
		String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlph1 = alph.substring(key1) + alph.substring(0, key1);
		String shiftAlph2 = alph.substring(key2) + alph.substring(0, key2);
		
		for (int i = 0; i < encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			int idx = alph.indexOf(Character.toUpperCase(currChar));
			
			if (idx != -1) {
				if (i % 2 == 0) {
					char newChar = shiftAlph1.charAt(idx);
					if (Character.isLowerCase(currChar)) 
						encrypted.setCharAt(i, Character.toLowerCase(newChar));
					else
						encrypted.setCharAt(i, newChar);	
				}
				else {
					char newChar = shiftAlph2.charAt(idx);
					if (Character.isLowerCase(currChar)) 
						encrypted.setCharAt(i, Character.toLowerCase(newChar));
					else
						encrypted.setCharAt(i, newChar);	
				}
			}
		}
		return encrypted.toString();
	}

	private static void testCipher() {
		int key = 17;
		CaesarCipher yo = new CaesarCipher();
		String msg = yo.encryptTwo("I am a bat", 23, 17);
		System.out.println(msg);
		String reply = yo.encrypt("Z rd r srk", 26-key);
		System.out.println(reply);
	}
	
	private static void testCipher2() {
		int key1 = 23;
		int key2 = 17;
		CaesarCipher yo = new CaesarCipher();
		String msg = yo.encryptTwo("First Legion", key1, key2);
		System.out.println(msg);
		String reply = yo.encryptTwo("Czojq Ivdzle", 26-key1, 26-key2);
		System.out.println(reply);
	}
}
