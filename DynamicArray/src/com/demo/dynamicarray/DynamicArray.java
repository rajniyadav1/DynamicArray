package com.demo.dynamicarray;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DynamicArray {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        //return correct queries result
        List<Integer> correctQueries = new ArrayList<>();

        //Create a 2-dimensional array, arr, of n empty arrays. 
        List<List<Integer>> arr = new ArrayList<>();

        //Initializing with empty list
        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<Integer>());
        }

        //create an integer, lastAnswer, and initialize it to 0.
        int lastAnswer = 0;

        for(List<Integer> q : queries){
            int queryType = q.get(0);  
            int x = q.get(1);
            int y = q.get(2);
            int index = (x ^ lastAnswer) % n;
            
            switch(queryType){
                case 1:
                    arr.get(index).add(y);
                    break;
                case 2:
                    int size = arr.get(index).size();
                    lastAnswer = arr.get(index).get(y % size);
                    correctQueries.add(lastAnswer);
                    break;
            }
        }
        return correctQueries;
    }
    
    public static void main(String[] args) throws IOException {
    	/**
    	 * Sample Input
    	 * 	2 5
    	 * 	1 0 5
    	 *	1 1 7
    	 *	1 0 3
    	 *	2 1 0
    	 *	2 1 1
    	 * Sample Output
    	 *	[7, 3]
    	 */
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        System.out.println(result.toString());

        bufferedReader.close();
        
    }
}


