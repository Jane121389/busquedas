import java.io.*;
import java.util.Scanner;
class decimal_matriz_hexa
{
    public static void main(String [] args)
    {
        long    numero          =0;
        int     s               =1;
        Scanner sc              =new Scanner(System.in);
        long    hexadecimal[][] =new long[4][4];
        long    hexadecimal2[][]=new long[4][4];
        for (int i=0; i < 4; i++)
            for (int j=0; j < 4; j++)
                hexadecimal[i][j]=sc.nextInt();
        for (int i=15; i > 0; i--)
        {
            numero=numero + (long)(Math.pow(16, i) * s);
            System.out.print(" " + numero + " ");
            s++;
        }
        System.out.println("");
        numero=hexa_decimal(hexadecimal);
        System.out.println(numero);
        hexadecimal2=decimal_hexa(numero);
        for (int i=0; i < 4; i++)
        {
            for (int j=0; j < 4; j++)
                System.out.print(" " + hexadecimal2[i][j] + " ");
            System.out.println("");
        }
    }

    static long [][] decimal_hexa(long decimal)
    {
        long div =decimal;
        long hexadecimal[][]=new long[16][16];
        long modulo =decimal;
        int  fila =0, fila2=0;
        int  columna =0, columna2=0;
        while (div > 0)
        {
            modulo                    =(div % 16);
            div                       =div / 16;
            fila                      =3 - fila2;
            columna                   =3 - columna2;
            hexadecimal[fila][columna]=modulo;
            columna2++;
            if (columna2 > 3)
            {
                columna2=0;
                fila2++;
            }
        }
        return hexadecimal;
    }

    static long hexa_decimal(long [][] hexadecimal)
    {
        long numero_hexa=0;
        int  fila       =0;
        int  columna    =0;
        for (fila=0; fila < 4; fila++)
            for (columna=0; columna < 4; columna++)
            {
                numero_hexa=numero_hexa + hexadecimal[fila][columna] * (long)(Math.pow(16, ((3 - fila) * 4) + (3 - columna)));
                System.out.print(" " + numero_hexa + " ");
            }
        return numero_hexa;
    }
}
