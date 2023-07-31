import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		int[] b = new int[26];
		int ascA = 97;
		for(int i = 0; i < a.length(); i++) {
			b[a.charAt(i)-97]++;
		}
		for(int c : b) {
			System.out.print(c + " ");
		}
	}
}
