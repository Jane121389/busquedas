import java.io.*;
import java.util.Scanner;
class Ajedrez
{
    public static void main(String [] args)
    {
        Scanner sc    =new Scanner(System.in); //instancia un objeto para leer del teclado
        Pila    pila_i=new Pila();             //intancia un objeto pila
        Pila    pila_j=new Pila();             //intancia un objeto pila
        int     tablero[][];
        int     i =0, j=0, ia=0, ja=0;
        int     n =0;
        int     l =0;
        int     i_anterior =0, j_anterior=0;
        int     movimientos=0;                              //movimientos necesarios para pasar por todas las casillas del tablero
        System.out.println("Escriba n del tablero (nxn):"); //imprime en pantalla
        n          =sc.nextInt();                           //lee n de (nxn) del tablero
        movimientos=(n * n);                                //movimientos de tablero
        tablero    =new int[n][n];                          //Define los elementos del arreglo tablero
        for (i=0; i < n; i++)                               //inicializa el tablero en ceros
            for (j=0; j < n; j++)
                tablero[i][j]=0;
        System.out.println("Elija en que fila del tablero desea iniciar:");
        i=sc.nextInt();
        System.out.println("Elija en que columna del tablero desea iniciar:");
        j=sc.nextInt();
        i--; //Disminuye en uno ya que las matrices empiezan en 0
        j--; //Disminuye en uno ya que las matrices empiezan en 0
        l++; //incrementamos nuestro contador de movimientos
        tablero[i][j]=1;
        pila_i.push(i);           //introduce en la pila el valor de ia
        pila_j.push(j);           //introduce en la pila el valor de ja
        for (; l < movimientos;)  //permanece en el ciclo mientras no se hallan terminado los movimientos
        {
            ia=i + 2;
            ja=j - 1;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i + 2;
            ja=j + 1;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i - 2;
            ja=j - 1;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i - 2;
            ja=j + 1;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i + 1;
            ja=j - 1;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i + 1;
            ja=j + 2;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i - 1;
            ja=j - 2;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            ia=i - 1;
            ja=j + 2;
            if (ia < n && ja < n && ia >= 0 && ja >= 0)    //si ia<ancho del tablero y ja<largo, si ia>=0 y ja>=0

                if (tablero[ia][ja] == 0)
                {
                    pila_i.push(ia);    //introduce en la pila el valor de ia
                    pila_j.push(ja);    //introduce en la pila el valor de ja
                }
            i=pila_i.actual();
            j=pila_j.actual();
            if (tablero[i][j] == 0)
            {
                l++;    //incrementamos nuestro contador de movimientos
                if (i >= 0 || j >= 0)
                    tablero[i][j]=l;      //coloca el número de movimiento en el arreglo tablero
                for (int s=0; s < n; s++) //imprime en pantalla el tablero
                {
                    for (int k=0; k < n; k++)
                        if (tablero[s][k] >= 10)
                            System.out.print(" " + tablero[s][k] + " ");
                        else
                            System.out.print("  " + tablero[s][k] + " ");
                    System.out.println("   ");
                }
                System.out.println("   ");
            }
            else
            {
                while (l < movimientos && tablero[i][j] != 0)  //Mientras la posición sea distinta de cero , es decir, mientras ya se halla pasado por este lugar
                {
                    if (tablero[i][j] != 0)    //Si la posición (i,j) ya esta ocupada por un movimiento
                    {
                        tablero[i][j]=0;          //colocar en cero ese movimiento
                        l--;                      //restar el contador de movimientos
                        for (int s=0; s < n; s++) //imprime en pantalla el tablero
                        {
                            for (int k=0; k < n; k++)
                                if (tablero[s][k] >= 10)
                                    System.out.print(" " + tablero[s][k] + " ");
                                else
                                    System.out.print("  " + tablero[s][k] + " ");
                            System.out.println("   ");
                        }
                        System.out.println("   ");
                    }
                    i=pila_i.pop(); //sacamos un elemento i de la lista
                    j=pila_j.pop(); //sacamos un elemento j de la lista
                    if (i < 0 || j < 0)
                    {
                        l=movimientos;
                        System.out.println("No hay solución ");
                    }
                }
                l++;    //incrementamos nuestro contador de movimientos
                if (i >= 0 && j >= 0)
                    tablero[i][j]=l;    //coloca el número de movimiento en el arreglo tablero
            }
        }
    }
}
class Pila  //Clase que simula una pila
{
    int indice;                   //índice del arreglo
    int arreglo[]=new int[10000]; //arreglo de enteros
    public Pila()
    {
        indice=0;   //indice del arreglo de la pila
    }

    public int pop() //elimina un elemento de la pila
    {
        indice--;               //decrementa el indice en uno
        int regresa=arreglo[1]; //toma el valor del elemento actual
        if (indice <= 0)        //si no hay mas elementos en la pila devuelve -1
            return -1;
        for (int k=0; k < indice; k++) //recorre el arreglo
            arreglo[k]=arreglo[k + 1];
        return regresa; //regresa el elemento actual (después del eliminado)
    }

    public int actual() //da el elemento actual de la pila
    {
        return arreglo[0];
    }

    public void push(int numero)    //introduce un elemento a la pila
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
