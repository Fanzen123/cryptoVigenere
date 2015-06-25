package factory;

import java.util.ArrayList;
import java.util.HashMap;

public class VigenereCipher implements ICipher {

	private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public ArrayList<Character> generateKey(String message){

		 ArrayList<Character> keys = new ArrayList<>();
		 //add random charachers te generate the key
		 for(int i = 0; i < message.length(); i++){
			 keys.add(alphabet.toUpperCase().charAt((int) (Math.random() * 25)));
		 }
		 return keys;
	}
	
	public String decode(String encoded, ArrayList<Character> key){
		int keysIndex = 0;
		StringBuilder decoded = new StringBuilder();
		int transpose;
		for(int i = 0; i <encoded.length(); i++){
			transpose = key.get(i);
			decoded.append(((char)((encoded.charAt(i) - transpose + 26) % 26 + 'A')));
			if(transpose == key.size())
				transpose = 0;
		}
		return decoded.toString();
	}
	
	@Override
	public String encode(String message, String key) {
		StringBuilder builderKey = new StringBuilder();
		HashMap<Character, Character> associateKey = new HashMap<Character, Character>();
		
		/*
		 * Create tab
		 *  key => value == character from message => character value from key
		 */
		int o = 0;
		for(int i = 0; i < message.length();i++) {
			if(message.charAt(i) == 32) {
				builderKey.append(" ");
			} else {
				associateKey.put(new Character(message.charAt(i)), new Character(key.charAt(o)));
				Character messageCharacter = new Character(message.charAt(i));
				Character keyCharacter = new Character(key.charAt(o));
				
				if(!messageCharacter.equals(" ")) {
			        int leftToRight = ((int)messageCharacter.charValue()) - 97;
			        char character;
			        // System.out.println(leftToRight);
			        if(keyCharacter.charValue() + leftToRight < (97 + alphabet.length()))
		    			character = (char)(keyCharacter.charValue() + leftToRight);
		    		else 
		    			character = (char)(((keyCharacter.charValue() + leftToRight) % (97 + alphabet.length())) + 97);
			        
			        builderKey.append(new Character(character));
		        } else {
		        	builderKey.append(" ");
		        }
				
				if(++o >= key.length())
					o = 0;
			}
		}
	    
		return builderKey.toString();
	}

	@Override
	public String findKey(String messageEncoded) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Sequence> findSequence(String encoded) {
		return null;
	}
	
	public ArrayList<Integer> findMultiple(ArrayList<Sequence> sequences) {
		return null;
	}
	
	public int findMultiple(ArrayList<Integer> multiples, ArrayList<Sequence> sequences) {
		return 0;
	}
	
	class Sequence {
		public String name;
		public int space;
	}

}
