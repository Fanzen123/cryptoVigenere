
import java.util.ArrayList;

import factory.VigenereCipher;

public class Main {

	public static void main(String[] args) {
		VigenereCipher vc = new VigenereCipher();
		// String message = "jadore ecouter la radio toute la journee";
		// String key = "musique";
		// String encoded = vc.encode(message, key);
		// System.out.println("Encoded =" + encoded);
		String encoded = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJG";
		ArrayList<factory.VigenereCipher.Sequence> array = vc.findSequence(encoded.replaceAll(" ", ""));
		for(int i = 0;i < array.size();i++) {
			// array.get(i).space = Math.abs(array.get(i).space);
			// System.out.println(array.get(i).name +" => " + array.get(i).space);
		}
		System.out.println("number length key=" + vc.lengthkey (vc.findMultiple(array)));
	}

}
