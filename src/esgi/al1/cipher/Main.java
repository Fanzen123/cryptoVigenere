package esgi.al1.cipher;

import java.util.ArrayList;



public class Main {
	
	public static void main(String[] args) {	
		/*HomophonicCipher h = new HomophonicCipher();
		HashMap<Character, ArrayList<Byte>> key = h.generateKey("hello etienne");
		System.out.println(key);*/
		VigenereCipher cipher = new VigenereCipher();
		String message = "HELLO";
		ArrayList<Character> key = cipher.generateKey(message);
		String encode = cipher.encode("HELLO", key);
		System.out.println("encode " + encode);
		System.out.println(cipher.decode(encode,key));
	}

}
