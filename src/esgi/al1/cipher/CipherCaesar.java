package esgi.al1.cipher;

public class CipherCaesar implements ICipher {
	
	private final static String alphabet = "abcdefghijklmnopqrstuvwxyz .;'-";

	@Override
	public String encode(String message, char key) {
		int intkey = (int)key - 96;
		System.out.println(intkey);
		char[] messageTable = message.toCharArray();
		if(intkey > alphabet.length())
			return null;
		for(int i = 0;i < messageTable.length; i++) {
			int messageCharIndex = message.charAt(i);
			int encodedCharIndex =  messageCharIndex + intkey;
			if(encodedCharIndex - 96 < alphabet.length())
				messageTable[i] = (char)((int)message.charAt(i) + intkey);
			else
				messageTable[i] = (char)(messageCharIndex % alphabet.length());
		}
		return new String(messageTable);
	}

	@Override
	public String decode(String encodedmsg, char key) {
		
		int intkey = (int)key;
		char[] messageTable = encodedmsg.toCharArray();
		StringBuilder encoded = new StringBuilder();
		if(key >= 26)
			return null;
		for(int i = 0;i < encodedmsg.length() - intkey; i++) {
			messageTable[i] = (char)((int)encodedmsg.charAt(i) - intkey);
		}
		for(int i = encodedmsg.length()- intkey;i <encodedmsg.length() ; i++) {
			messageTable[i] = (char)((int)encodedmsg.charAt(i) - intkey);
		}
		return new String(messageTable);
		
	}

}
