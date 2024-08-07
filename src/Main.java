import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[Num];
        int[] list = new int[1000001];
        int[] result = new int[Num];

        for(int i = 0; i < Num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list[arr[i]]++;
        }

        for(int i = 0; i < Num; i++) {
            while(!stack.isEmpty() &&  list[arr[stack.peek()]] < list[arr[i]]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }


        while(!stack.empty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}