import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MagicSquare {

    int[][] arr = null;
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub  D:\EclipseWorkplace\Lab1_1160301023
        MagicSquare ms = new MagicSquare();
        //int[][] arr = null;
        System.out.println(ms.isLegalMagicSquare("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/1.txt"));
        System.out.println(ms.isLegalMagicSquare("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/2.txt"));
        System.out.println(ms.isLegalMagicSquare("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/3.txt"));
        System.out.println(ms.isLegalMagicSquare("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/4.txt"));
        System.out.println(ms.isLegalMagicSquare("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/5.txt"));
        System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.print("请输入生成的幻方的行列数：");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        if(MagicSquare.generateMagicSquare(size));
            System.out.println(ms.isLegalMagicSquare("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/6.txt"));
    }

    public boolean isLegalMagicSquare(String filename){
        
        File file = new File(filename);
        int line = -1;
        int linemark = 0;
        InputStreamReader reader = null;
        BufferedReader br = null;
        //read the files
        try {
            reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            br = new BufferedReader(reader);
            String s = null;
            br.mark((int) file.length() + 1);
            s = br.readLine();
            while (s != null) {//As the number of rows and columns are the same
                line++;         //so by calculating the number of columns to determine
                s = br.readLine();
            }
            br.reset();//Set a flag at the top of the file to return the header of the file after counting the number of columns
            arr = new int[line + 1][line + 1];
            s = br.readLine();
            while (s != null) {//Reading documents by line, with the split method in accordance with "\ t" segmentation
              try{
                String[] token = s.split("\t");
                for (int i = 0; i < token.length; i++) {
                    if (token.length != line + 1){
                        return false;
                    }
                    if (token[i].matches("[0-9]+")) {
                        arr[linemark][i] = Integer.parseInt(token[i]);
                    } else {
                        return false;
                    }
                }
                s = br.readLine();
                linemark++;
                
              }catch(Exception e){
                  
              }
            }
              
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {//Do not forget to turn off the input stream
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Calculate the sum of rows, columns, and diagonals
        int[][] num = new int[2][line + 1];
        int a1 = 0, a2 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j <= line; j++)
                num[i][j] = 0;
        for (int i = 0; i <= line; i++) {
            a1 += arr[i][i];
            a2 += arr[i][line - i];
            for (int j = 0; j <= line; j++) {
                num[0][i] += arr[i][j];
                num[1][i] += arr[j][i];
            }
        }
        //Determine whether magic square
        if (a1 == a2) {
            for (int i = 0; i < 2; i++)
                for (int j = 0; j <= line; j++) {
                    if (num[i][j] != num[0][0]){
                        return false;
                    }
                }
        } else {
            return false;
        }
        return true;
    }

    //Constructor
    public MagicSquare() {

    }
    
    public static boolean generateMagicSquare(int n) throws IOException {
        int magic[][] = new int[n][n];
        int row = 0, col = n / 2, i, j, square = n * n;
        File f = null;
        FileWriter fw = null;
        try {
            for (i = 1; i <= square; i++) {
                magic[row][col] = i;
                if (i % n == 0)
                    row++;
                else {
                    if (row == 0)
                        row = n - 1;
                    else
                        row--;
                    if (col == (n - 1))
                        col = 0;
                    else
                        col++;
                }
            }
        } catch (Exception e) {
            if (n % 2 == 0)
                System.out.println("矩阵行列数为偶数");
            else if (n <= 0)
                System.out.println("矩阵行列数为负数");
            return false;
        }
        try {
            f = new File("D:\\EclipseWorkplace\\Lab1_1160301023\\src/P1/txt/6.txt");
            fw = new FileWriter(f);
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    fw.write(magic[i][j] + "\t");
                fw.write("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
        return true;
    }

}
