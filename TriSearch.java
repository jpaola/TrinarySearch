package TriSearch;

import java.util.Random;
/*
 * A recursive implementation of a trinary search function for arrays of any
 * size that returns location of x in a given presorted (increasing order)
 * array arr[l..r] is present, otherwise -1. Unlike the binary search function,
 * the triSearch function considers two dividing points. The terSearch function
 * is tested on a randomly and arbitrary presorted int arr = {1, 4, 7, 8, 15, 
 * 18, 21, 22, 25, 29, 32, 34, 36, 41, 44, 55, 59, 67, 68, 72, 74, 77, 80, 82,
 * 87, 88, 91, 97, 99}, but it should work for any sized array of type int.
 *
 * @author Paola Jiron  05/27/15
 */

public class TriSearch
{

    /**
     * A function that implements the process of searching through a sorted
     * array of int by diving the array into three parts and eliminating the
     * partition that does not hold the value x searched for.
     * @param arr An array of int.
     * @param l the leftmost index.
     * @param r the rightmost index.
     * @param x the value searched for.
     * @return the index (location) of the value if it is found on the array, -1
     * otherwise.
     */
    public static int terSearch(int arr[], int l, int r, int x)
    {
        // l holds the head of the list [0] and r holds the tail of the
        // list [length - 1]; ex. l.........r

        if ( l > r )
        {
            return -1;
        }
        
        int d1 = l + ((r - l) / 3);
        int d2 = d1 + ((r - l) / 3);

        if (arr[d1] == x)
        {
            return d1;
        }
        else if (arr[d2] == x)
        {
            return d2;
        }
        else if ( x < arr[d1])
        {
            return terSearch(arr, l, d1 - 1, x);
        }
        else if ( x > arr[d2])
        {
            return terSearch(arr, d2 + 1, r, x);
        }
        else
        {
            return terSearch(arr, d1, d2, x);
        }
        
    }

    // tests the TriSearch function with a presorted array
    public static void main(String[] args)
    {
        int[] arr =
        {
            1, 4, 7, 8, 15, 18, 21, 22, 25, 29, 32, 34, 36, 41, 44,
            55, 59, 67, 68, 72, 74, 77, 80, 82, 87, 88, 91, 97, 99
        };

        Random generate = new Random();

        int x = generate.nextInt(101); // returns an int from 0...100

        if (TriSearch.terSearch(arr, 0, arr.length - 1, x) == -1)
        {
            System.out.println(TriSearch.terSearch(arr, 0, arr.length - 1, x)
                 + "\n" + x + " is not on the list");
        }
        else
        {
            System.out.println(x + " is on index "
                 + TriSearch.terSearch(arr, 0, arr.length - 1, x));
        }
    }
} // end of TriSearch recursive class definition
