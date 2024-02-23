
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int findValue = sc.nextInt();

        int x = n / 2;
        int y = n / 2;
        int value = 1;
        boolean endFlag = false;
        int[][] map = new int[n][n];
        map[y][x] = value;

        int action = 1;
        int cnt = 1;
        while (true) {
            for (int j = 0; j < 2; j++) {
                if (action == 1) {
                    for (int i = 0; i < cnt; i++) {
                        map[--y][x] = ++value;
                    }
                } else if (action == 2) {
                    for (int i = 0; i < cnt; i++) {
                        map[y][++x] = ++value;
                    }
                } else if (action == 3) {
                    for (int i = 0; i < cnt; i++) {
                        map[++y][x] = ++value;
                    }
                } else if (action == 4) {
                    for (int i = 0; i < cnt; i++) {
                        map[y][--x] = ++value;
                    }
                }
                if (++action > 4) action = 1;
                if (endFlag) break;
            }
            if (endFlag) break;
            if (++cnt >= n) {
                cnt--;
                endFlag = true;
            }
        }

        int[] result = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == findValue) {
                    result[0] = j + 1; // Adjusted for 1-based indexing
                    result[1] = i + 1; // Adjusted for 1-based indexing
                }
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        bw.write(result[1] + " " + result[0]);
        bw.newLine();
        sc.close();
        bw.flush(); // 버퍼에 남아있는 데이터를 모두 출력
        bw.close(); // BufferedWriter를 닫아 리소스 해제
        /*
        // java vm이 사용할수 있는 총 메모리(bytes), -Xmx
        long maxMem = Runtime.getRuntime().maxMemory()/1024/1024;
        // java vm에 할당된 총 메모리
        long totalMem = Runtime.getRuntime().totalMemory()/1024/1024;
        // java vm이 추가로 할당 가능한 메모리
        long freeMem = Runtime.getRuntime().freeMemory()/1024/1024;

        // 현재 사용중인 메모리
        long usedMem = totalMem - freeMem;
        // 퍼센트
        double pct = usedMem * 100.0 / maxMem;

        String t = "heap.current \t heap.percent \t heap.max";
        String s = String.format("%s\n%10dmb \t %11.1f%% \t %6dmb", t, usedMem, pct, maxMem);
        bw.write(s);

        bw.flush(); // 버퍼에 남아있는 데이터를 모두 출력
        bw.close(); // BufferedWriter를 닫아 리소스 해제
        */
    }
}
