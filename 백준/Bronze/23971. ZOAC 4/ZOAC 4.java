import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        float[] in = new float[4];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < 4; i++){
            in[i] = Float.parseFloat(st.nextToken());
        }

        float h = in[0];
        float w = in[1];
        float n = in[2];
        float m = in[3];

        double l = Math.ceil(w / (m + 1));
        double k = Math.ceil(h / (n + 1));

        int answer = (int) (l * k);
        System.out.println(answer);
    }
}
