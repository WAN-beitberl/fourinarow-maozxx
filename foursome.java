import java.util.Scanner;

// in order to save time some methods were taken from the internet and previous projects but
// connecting all and writing the important stuff like winner was done solely me
public class foursome
{
    public static String[][] createMap()
    {
        String[][] map = new String[7][15];

        // running on all rows
        for (int i =0;i<map.length;i++)
        {

            // running on all lines
            for (int j =0;j<map[i].length;j++)
            {
                if (j % 2 == 0) map[i][j] = "|";
                else map[i][j] = " ";
                if (i == 6) map[i][j] = "X";
            }
        }
        return map;
    }

    // method for printing current map
    public static void printPattern(String[][] f)
    {
        for (int i =0;i<f.length;i++)
        {
            for (int j=0;j<f[i].length;j++)
            {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }
    public static void dropRedPattern(String[][] f)

    {
        System.out.println("Enter Red disk (0–6): ");

        // creating scanner for input
        Scanner scan = new Scanner (System.in);

        // using school taught algorithem קווי הפרדה
        int c = 2*scan.nextInt()+1;

        // checking all line for empty
        for (int i =5;i>=0;i--)
        {
            // check for empty
            if (f[i][c] == " ")
            {
                f[i][c] = "R";
                break;
            }
        }
    }

    public static void dropYellowPattern(String[][] f)
    {
        System.out.println("Enter Yellow disk (0–6): ");

        // creating scanner for input
        Scanner scan = new Scanner (System.in);

        // using school taught algorithem and because of the קווי הפרדה
        int c = 2*scan.nextInt()+1;

        // checking all line for empty
        for (int i =5;i>=0;i--)
        {
            // check for empty
            if (f[i][c] == " ")
            {
                f[i][c] = "Y";
                break;
            }
        }
    }

    // checking for winner אלכסון ושורות
    public static String checkWinner(String[][] map)
    {
        // go through rows
        for (int row =0;row<6;row++)
        {
            // go through lines
            for (int line=0;line<7;line+=2)
            {
                // checking if won in line
                if ((map[row][line+1] != " ")
                        // all checking needed to for win
                        && (map[row][line+3] != " ")
                        && (map[row][line+5] != " ")
                        && (map[row][line+7] != " ")
                        && ((map[row][line+1] == map[row][line+3])
                        && (map[row][line+1] == map[row][line+5])
                        && (map[row][line+1] == map[row][line+7])))
                    return map[row][line+1];
            }
        }
        // go through rows
        for (int line=1;line<15;line+=2)
        {
            // go through lines
            for (int row =0;row<3;row++)
            {
                // checking if won in row
                if((map[row][line] != " ")
                        && (map[row+1][line] != " ")
                        && (map[row+2][line] != " ")
                        && (map[row+3][line] != " ")
                        && ((map[row][line] == map[row+1][line])
                        && (map[row+1][line] == map[row+2][line])
                        && (map[row+2][line] == map[row+3][line])))
                    return map[row][line];

            }

        }

        // checking diagnals up - אלכסוניפ
        for (int row=0;row<3;row++)
        {
            for (int line=1;line<9;line+=2)
            {
                if((map[row][line] != " ")
                        && (map[row+1][line+2] != " ")
                        && (map[row+2][line+4] != " ")
                        && (map[row+3][line+6] != " ")
                        && ((map[row][line] == map[row+1][line+2])
                        && (map[row+1][line+2] == map[row+2][line+4])
                        && (map[row+2][line+4] == map[row+3][line+6])))
                    return map[row][line];
            }
        }

        // checking diagnals down- אלכסוניפ
        for (int row=0;row<3;row++)
        {
            for (int line=7;line<15;line+=2)
            {
                if((map[row][line] != " ")
                        && (map[row+1][line-2] != " ")
                        && (map[row+2][line-4] != " ")
                        && (map[row+3][line-6] != " ")
                        && ((map[row][line] == map[row+1][line-2])
                        && (map[row+1][line-2] == map[row+2][line-4])
                        && (map[row+2][line-4] == map[row+3][line-6])))
                    return map[row][line];
            }
        }
        return null;
    }



    // calling all methods
    public static void main(String args[]) {

        // making varaibles map flag turn
        String[][] map = createMap();
        boolean flag = true;
        int turn = 0; // red starts all the time
        printPattern(map);
        while(flag == true)
        {
            if (turn % 2 == 0) dropRedPattern(map);
            else dropYellowPattern(map);
            turn++;
            printPattern(map);
            if (checkWinner(map) != null)
            {
                if (checkWinner(map) == "R")
                    System.out.println(" Red Won");
                else if (checkWinner(map)== "Y")
                    System.out.println("Yellow Won");
                flag = false;
            }
        }
    }
}

