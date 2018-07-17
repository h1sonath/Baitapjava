
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] map = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "P", "*"},
                {"*", "*", "*", "*"}
        };

        Scanner scanner = new Scanner(System.in);

        int playerX = 2;
        int playerY = 2;
        int e1x = (int) (Math.random()*4);
        int e1y = (int) (Math.random()*4);
        int gx =(int) (Math.random()*4);
        int gy=(int) (Math.random()*4);
        int e2x =(int) (Math.random()*4);
        int e2y =(int) (Math.random()*4);
        while ((e1x == e2x && e1y == e2y ) || (e2x == gx &&e2y == gy) ||  (e1x == gx &&e1y == gy) || (playerX== gx && playerY ==gy)|| (playerX ==e1x && playerY == e1y) || (playerX == e2x && playerY == e2y))
        {
            e1x =(int) (Math.random()*4);
            e1y = (int)(Math.random()*4);
            gy =(int) (Math.random()*4);
            gx = (int) (Math.random()*4);
            e2x =(int) (Math.random()*4);
            e2x = (int) (Math.random()*4);
        }
        map[e1x][e1y] = "E";
        map[e2x][e2y] = "E";
        map[gx][gy] = "G";

        while (true) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[j][i] + " ");
                }
                System.out.println();
            }

            System.out.println("Nhap ky tu ban phim: ");
            String key = scanner.next();

            map[playerX][playerY] = "*";
            map[e1x][e1y] = "*";
            map[e2x][e2y] = "*";
            map[gx][gy]= "G";



            switch (key) {
                case "w":
                    playerY -= 1;
                    e1y+=1;
                    e2x-=1;
                    break;
                case "s":
                    playerY += 1;

                    e1y+=1;
                    e2x-=1;
                    break;
                case "a":
                    playerX -= 1;
                    e1y+=1;
                    e2x-=1;
                    break;
                case "d":
                    playerX += 1;
                    e1y+=1;
                    e2x-=1;
                    break;
            }
            if (playerY == -1) playerY = map.length - 1;
            if (playerY == map.length) playerY = 0;
            if (playerX == -1) playerX = map.length - 1;
            if (playerX == map.length)  playerX = 0;
            if (e1y == -1) e1y = map.length - 1;
            if (e1y == map.length) e1y = 0;
            if (e1x == -1) e1x = map.length - 1;
            if (e1x == map.length)  e1x = 0;
            if (e2y == -1) e2y = map.length - 1;
            if (e2y == map.length) e2y = 0;
            if (e2x == -1) e2x = map.length - 1;
            if (e2x == map.length)  e2x = 0;
            if(gx== playerX & gy == playerY)
            {
                System.out.println("win");
                return;

            }
            if((playerX == e1x && playerY == e1y) || (playerX== e2x && playerY == e2y))
            {
                System.out.println("thau");
                return;
            }
            map[playerX][playerY] = "P";
            map[e1x][e1y] = "E";
            map[e2x][e2y] = "E";
        }
    }
}