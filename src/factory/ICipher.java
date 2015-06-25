package factory;

import java.util.ArrayList;

public interface  ICipher {

	  String encode(String message, String key);
	  String decode(String encoded, ArrayList<Character> key);
	  String findKey(String messageEncoded);
}
