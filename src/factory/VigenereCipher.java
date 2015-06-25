package factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
		ArrayList<Sequence> array = new ArrayList<Sequence>();
		String word;
		for(int length = 3; length < 7; length++) {
			for(int startIndex = 0; startIndex < encoded.length(); startIndex++) {
				if(encoded.length() < (startIndex+length)) 
					break;
				word = encoded.substring(startIndex, startIndex + length);
				// System.out.println(word);
				for(int i = startIndex + 1; i < encoded.length()-length; i++) {
					// System.out.println(i + "=>" + (i+length));
					if(encoded.length() < (i+length)) {
						break;
					}
					else if(word.equals(encoded.substring(i, i+length))) {
						Sequence s = new Sequence(word, i - startIndex);
						// System.out.println(s.name + s.space);
						array.add(s);
					}
				}
			}
		}
		
		return array;
	}
	
	public int findKey(ArrayList<Integer> multiples, ArrayList<Sequence> sequences) {
		return 0;
	}
	
	public List<Integer> diviseurInteger (int nbre)
	{
		List<Integer> listDiviseur =new ArrayList<>();
		if (nbre%2!=0)
		{
			listDiviseur.add(nbre);
		}
		for (int i=2;i<nbre/2 +1 ;i++)
		{
			if (nbre%i==0)
			{
				listDiviseur.add(i);
				
			}
		}
		
		return listDiviseur;
	}
	
	public int lengthkey (HashMap<Integer, List<Integer>> listInteger)
	{
		for(Entry<Integer, List<Integer>> entry : listInteger.entrySet()) {
		   for (int i=0;i< entry.getValue().size();i++)
		   {
			   if (searchInteger(entry.getValue().get(i), listInteger, i)==true)
			   {
				   return entry.getValue().get(i);
				  
			   }
		   }
		    
		}

		return 0;
	}
	
	
	public boolean searchInteger(int nbre,HashMap<Integer, List<Integer>> listInteger ,int index)
	{
		int occurence=0;
		for(Entry<Integer, List<Integer>> entry : listInteger.entrySet()) 
		{
			
			for (int k=0 ;k<entry.getValue().size();k++)
			{
				
				if (entry.getValue().get(k)== nbre)
				{
					occurence++;					
				}
				
			}	
		}
		if (occurence==listInteger.size())
		{
			return true;
			
		}
		return false ;
	}
	
	public HashMap<Integer, List<Integer>> findMultiple(ArrayList<Sequence> sequences) {
		HashMap<Integer, List<Integer>> list =new HashMap<Integer, List<Integer>>();
	   for (int i=0;i<sequences.size();i++)
	   {
		list.put(sequences.get(i).space,diviseurInteger(sequences.get(i).space));
	   }
		return list;
	}
	
	public class Sequence {
		public String name;
		public int space;
		public Sequence(String name, int space) {
			super();
			this.name = name;
			this.space = space;
		}
		
	}

}
