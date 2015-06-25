
import factory.VigenereCipher;

public class Main {

	public static void main(String[] args) {
		VigenereCipher vc = new VigenereCipher();
		String message = "jadore ecouter la radio toute la journee";
		String key = "musique";
		String encoded = vc.encode(message, key);
		System.out.println("Encoded =" + encoded);
	}

}
