import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
class puzzle_2
{
    static List<Long> listabusqueda = new LinkedList<Long>();   //
    static int i_vec_busqueda;
    public static void main(String [] args)
    {
        long meta =0;
        long numero_hash =0;
        long numero_hash2 =0;
        int  ia =0, ja=0, i=0, j=0;
        int  numero_aux =0;
        int  matriz_puzzle[][]=new int[4][4];
        int  s =1;
        int  valores =0;
        int  num =0;
        int  indice =0;
        int  in_i =0, in_j=0;
        Pila pila_hash =new Pila();
        for (i=15; i > 0; i--)
        {
            meta=meta + (long)(Math.pow(16, i) * s);
            s++;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Escriba los numeros del puzzle:");
        for (int m=0; m < 4; m++)
            for (int l=0; l < 4; l++)
            {
                matriz_puzzle[m][l]=sc.nextInt();
                if (matriz_puzzle[m][l] == 0)
                {
                    i=m;
                    j=l;
                }
            }

        numero_hash=hexa_decimal(matriz_puzzle);
        pila_hash.push(numero_hash);
        System.out.println(" " + numero_hash);
        busqueda_binaria(numero_hash);
        if (numero_hash == meta)
        {
            System.out.println("Puzzle resuelto");
            for (int m=0; m < 4; m++)
            {
                for (int l=0; l < 4; l++)
                    System.out.print(" " + matriz_puzzle[m][l]);
                System.out.println();
            }
        }
        else
        {
            while (numero_hash != meta)
            {
                //System.out.println("i:"+i+"j:"+j);
                valores=0;
                ia     =i + 1;
                ja     =j;
                if (ia < 4 && ja < 4 && ia >= 0 && ja >= 0)
                {
                    numero_aux  =matriz_puzzle[ia][ja];
                    numero_hash2=numero_hash - (numero_aux * (long)(Math.pow(16, ((3 - ia) * 4 + (3 - ja))))) + (numero_aux * (long)(Math.pow(16, ((3 - i) * 4 + (3 - j)))));
                    indice      =busqueda_binaria(numero_hash2);
                    if (indice != -1)
                    {
                        pila_hash.push(numero_hash2);
                        listabusqueda.remove(indice);
                        i_vec_busqueda--;
                        valores++;
                    }
                }
                ia=i;
                ja=j - 1;

                if (ia < 4 && ja < 4 && ia >= 0 && ja >= 0)
                {
                    numero_aux  =matriz_puzzle[ia][ja];
                    numero_hash2=numero_hash - (numero_aux * (long)(Math.pow(16, ((3 - ia) * 4 + (3 - ja))))) + (numero_aux * (long)(Math.pow(16, ((3 - i) * 4 + (3 - j)))));
                    indice      =busqueda_binaria(numero_hash2);
                    if (indice != -1)
                    {
                        pila_hash.push(numero_hash2);
                        listabusqueda.remove(indice);
                        i_vec_busqueda--;
                        valores++;
                    }
                }
                ia=i - 1;
                ja=j;
                if (ia < 4 && ja < 4 && ia >= 0 && ja >= 0)
                {
                    numero_aux  =matriz_puzzle[ia][ja];
                    numero_hash2=numero_hash - (numero_aux * (long)(Math.pow(16, ((3 - ia) * 4 + (3 - ja))))) + (numero_aux * (long)(Math.pow(16, ((3 - i) * 4 + (3 - j)))));
                    indice      =busqueda_binaria(numero_hash2);
                    if (indice != -1)
                    {
                        pila_hash.push(numero_hash2);
                        listabusqueda.remove(indice);
                        i_vec_busqueda--;
                        valores++;
                    }
                }
                ia=i;
                ja=j + 1;
                if (ia < 4 && ja < 4 && ia >= 0 && ja >= 0)
                {
                    numero_aux  =matriz_puzzle[ia][ja];
                    numero_hash2=numero_hash - (numero_aux * (long)(Math.pow(16, ((3 - ia) * 4 + (3 - ja))))) + (numero_aux * (long)(Math.pow(16, ((3 - i) * 4 + (3 - j)))));
                    indice      =busqueda_binaria(numero_hash2);
                    if (indice != -1)
                    {
                        pila_hash.push(numero_hash2);
                        listabusqueda.remove(indice);
                        i_vec_busqueda--;
                        valores++;
                    }
                }
                numero_hash=pila_hash.actual();
                //System.out.print("num "+numero_hash);
                if (valores == 0)
                {
                    busqueda_binaria_remueve(numero_hash);
                    numero_hash=pila_hash.pop();
                }
                System.out.println("num " + numero_hash);
                if (numero_hash > -1)
                {
                    matriz_puzzle=decimal_hexa(numero_hash);
                    for (int m=0; m < 4; m++)
                    {
                        for (int l=0; l < 4; l++)
                            System.out.print(" " + matriz_puzzle[m][l]);
                        System.out.println();
                    }
                    System.out.println();
                    for (int m=0; m < 4; m++)
                        for (int l=0; l < 4; l++)
                            if (matriz_puzzle[m][l] == 0)
                            {
                                i=m;
                                j=l;
                            }
                }
                else
                {
                    numero_hash=meta;
                    System.out.println("NO TIENE SOLUCIÓN");
                    num=-2;
                }

                num++;
            }
            if (numero_hash == meta && num != -1)
            {
                System.out.println("Puzzle resuelto");
                for (int m=0; m < 4; m++)
                {
                    for (int l=0; l < 4; l++)
                        System.out.print(" " + matriz_puzzle[m][l]);
                    System.out.println();
                }
            }
        }
    }

    static int [][] decimal_hexa(long decimal)
    {
        long div =decimal;
        int  hexadecimal[][]=new int[4][4];
        int  modulo =0;
        int  fila =0, fila2=0;
        int  columna =0, columna2=0;
        while (div > 0)
        {
            modulo                    =(int)(div % 16);
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

    static long hexa_decimal(int [][] hexadecimal)
    {
        long numero_hexa=0;
        int  fila       =0;
        int  columna    =0;
        for (fila=0; fila < 4; fila++)
            for (columna=0; columna < 4; columna++)
                numero_hexa=numero_hexa + hexadecimal[fila][columna] * (long)(Math.pow(16, ((3 - fila) * 4) + (3 - columna)));

        return numero_hexa;
    }

    static int busqueda_binaria(long numero)
    {
        int repeticion    =0;
        int mitad         =0;
        int indice_inicial=0;
        int indice_final  =0;
        int indice        =0;
        if (i_vec_busqueda == 0)   //si no hay elementos en el vector
        {
            listabusqueda.add(0, numero); //si no hay elementos coloca el numero de entrada como primer elemento
            repeticion=0;
            i_vec_busqueda++;
        }
        else
        {
            if (listabusqueda.get(0) == numero) //verifica si el número de entrada es el primer elemento del vector
                repeticion=-1;
            else if (listabusqueda.get(i_vec_busqueda - 1) == numero) //verifica si el número de entrada es el último elemento del vector
                repeticion=-1;
            else if (numero > listabusqueda.get(i_vec_busqueda - 1)) //verifica si el número de entrada es mayor que el último elemento por lo tanto no existe
            {
                listabusqueda.add(i_vec_busqueda, numero);
                repeticion=i_vec_busqueda;
                i_vec_busqueda++;
            }
            else if (numero < listabusqueda.get(0))    //verifica si el número de entrada es menor que el primer elemento por lo tanto no existe
            {
                listabusqueda.add(0, numero);
                repeticion=0;
                i_vec_busqueda++;
            }
            else
            {
                mitad       =i_vec_busqueda;
                indice_final=i_vec_busqueda;
                while (mitad >= 1)
                {
                    if (mitad % 2 != 0 && mitad != 1 && (mitad + indice_inicial) < i_vec_busqueda)
                        mitad++;
                    mitad=Math.round(mitad / 2);
                    //System.out.println(" mita"+mitad+ "indice"+i_vec_busqueda+"indice inicial:"+indice_inicial+"indice final:"+indice_final);
                    if (numero == listabusqueda.get(mitad + indice_inicial - 1))
                        repeticion=-1;
                    else if (numero > listabusqueda.get(mitad + indice_inicial - 1))
                        indice_inicial=indice_inicial + mitad;
                    else if (numero < listabusqueda.get(mitad + indice_inicial - 1))
                        indice_final=indice_inicial + mitad;
                }
                if (repeticion != -1)
                {
                    listabusqueda.add(indice_inicial, numero);
                    repeticion=indice_inicial;
                    i_vec_busqueda++;
                }
            }
        }
        return repeticion;  //regresa true si hay repetición
    }

    static boolean busqueda_binaria_remueve(long numero)
    {
        boolean repeticion    =false;
        int     mitad         =0;
        int     indice_inicial=0;
        int     indice_final  =0;
        int     indice        =0;
        if (i_vec_busqueda == 0)   //si no hay elementos en el vector
        {
            listabusqueda.add(0, numero); //si no hay elementos coloca el numero de entrada como primer elemento
            repeticion=false;
            i_vec_busqueda++;
        }
        else
        {
            if (listabusqueda.get(0) == numero) //verifica si el número de entrada es el primer elemento del vector
            {
                listabusqueda.remove(0);
                i_vec_busqueda--;
                repeticion=true;
            }
            else if (listabusqueda.get(i_vec_busqueda - 1) == numero)    //verifica si el número de entrada es el último elemento del vector
            {
                listabusqueda.remove(i_vec_busqueda - 1);
                i_vec_busqueda--;
                repeticion=true;
            }
            else if (numero > listabusqueda.get(i_vec_busqueda - 1)) //verifica si el número de entrada es mayor que el último elemento por lo tanto no existe
            {
                listabusqueda.add(i_vec_busqueda, numero);
                repeticion=false;
                i_vec_busqueda++;
            }
            else if (numero < listabusqueda.get(0))    //verifica si el número de entrada es menor que el primer elemento por lo tanto no existe
            {
                listabusqueda.add(0, numero);
                repeticion=false;
                i_vec_busqueda++;
            }
            else
            {
                mitad       =i_vec_busqueda;
                indice_final=i_vec_busqueda;
                while (mitad >= 1)
                {
                    if (mitad % 2 != 0 && mitad != 1 && (mitad + indice_inicial) < i_vec_busqueda)
                        mitad++;
                    mitad=Math.round(mitad / 2);
                    //System.out.println(" mita"+mitad+ "indice"+i_vec_busqueda+"indice inicial:"+indice_inicial+"indice final:"+indice_final);
                    if (numero == listabusqueda.get(mitad + indice_inicial - 1))
                    {
                        repeticion=true;
                        listabusqueda.remove(mitad + indice_inicial - 1);
                        i_vec_busqueda--;
                    }
                    else if (numero > listabusqueda.get(mitad + indice_inicial - 1))
                        indice_inicial=indice_inicial + mitad;
                    else if (numero < listabusqueda.get(mitad + indice_inicial - 1))
                        indice_final=indice_inicial + mitad;
                }
                if (repeticion == false)
                {
                    listabusqueda.add(indice_inicial, numero);
                    i_vec_busqueda++;
                }
            }
        }
        return repeticion;  //regresa true si hay repetición
    }
}
class Pila  //Clase que simula una pila
{
    int indice;                      //índice del arreglo
    long arreglo[]=new long[100000]; //arreglo de enteros
    public Pila()
    {
        indice=0;   //indice del arreglo de la pila
    }

    public long pop() //elimina un elemento de la pila
    {
        indice--;                //decrementa el indice en uno
        long regresa=arreglo[1]; //toma el valor del elemento actual
        if (indice < 0)          //si no hay mas elementos en la pila devuelve -1
            return -1;
        for (int k=0; k < indice; k++) //recorre el arreglo
            arreglo[k]=arreglo[k + 1];
        return regresa; //regresa el elemento actual (después del eliminado)
    }

    public long actual()    //da el elemento actual de la pila
    {
        return arreglo[0];
    }

    public void push(long numero)   //introduce un elemento a la pila
    {
        for (int k=indice; k > 0; k--) //recorre la pila
            arreglo[k]=arreglo[k - 1];
        arreglo[0]=numero;
        indice++;
    }

    public void imprime_pila()  //imprime la pila en pantalla
    {
        System.out.println("");
        for (int k=0; k < indice; k++)
            System.out.print(arreglo[k]);
    }
}
