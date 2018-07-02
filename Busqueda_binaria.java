import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
class Busqueda_binaria
{
    static List<Integer> listabusqueda = new LinkedList<Integer>(); //
    static int i_vec_busqueda;
    public static void main(String [] args)
    {
        int numero=0;   //numero igual a cero
        i_vec_busqueda=0;
        Scanner sc    =new Scanner(System.in); //instancia para lectura de datos
        boolean repite=false;
        while (numero != -1)
        {
            System.out.println("Introduzca número"); //imprime en pantalla
            numero=sc.nextInt();                     //lee del teclado
            repite=busqueda_binaria_remueve(numero); //introduce un dato en el metodo
            System.out.println("repite:" + repite);
            for (int s=0; s < i_vec_busqueda; s++)
                System.out.print(listabusqueda.get(s) + " ");
        }
    }

    static boolean busqueda_binaria(int numero)
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
                repeticion=true;
            else if (listabusqueda.get(i_vec_busqueda - 1) == numero) //verifica si el número de entrada es el último elemento del vector
                repeticion=true;
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
                        repeticion=true;
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

    static boolean busqueda_binaria_remueve(int numero)
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

