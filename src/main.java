import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main
{

    public static void main(String[] args)
    {
        System.out.println("FIRST");
        System.out.println(twoArrayComparer(new int[]{1,2,3},new int[]{3,2,1}));

        System.out.println("\nSECOND");
        arrayScan(new int[]{1,2,4,4});

        System.out.println("\nTHIRD");
        System.out.println(twoStringComparer("Hel", "HelHelHel"));

        System.out.println("\nFOUR");
        System.out.println(arraySum(new int[]{1,2,3,5}));

        System.out.println("\nFIFTH");
        sort(new String[]{"abrgfdsgfsdgfsdgsfdgsfdga","afdsgsfdggb","a"});
    }
    /*
    Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] за складом.
    Масиви можуть відрізнятися по порядку елементів, але бути однаковими зі складу.
    Приклад: [1,4,7]==[4,7,1- еквівалентні]
    */
    public static boolean twoArrayComparer(int[] arr1, int[] arr2)
    {
        int length = arr1.length;
        if(length != arr2.length) return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int index = 0; index < length;++index)
            if(arr1[index]!=arr2[index])
                return false;
        return true;
    }
    /*
     Створіть метод, який підраховує кількість однакових чисел у будь якому масиві int[].
     Приклад [1,7,3,9,34,3,7]. Результат : 1 - 1 раз, 7 - 2 рази, 3 - 2 рази і т.д.
     */
    public static void arrayScan(int[] arr)
    {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int item : arr)
        {
            if (result.containsKey(item))
                result.put(item, result.get(item) + 1);
            else
                result.put(item, 1);

        }
        System.out.println(result.toString());
    }
    /*
     Створіть метод, який приймає два параметри типу String
     та повертає кількість повних повторів одного слова літерами другого.
     Приклад: слово =він= можливо набрати три рази літерами , які є у рядку  =ннніііввввукег=
     */
    public static int twoStringComparer(String str1, String str2)
    {
        int numOfReplacing;
        int result = 0;
        while(true){
            numOfReplacing = str1.length();
            for(int index1 = 0,index2 = 0, length = str2.length();index2 < length;)
            {
                if(str1.charAt(index1) == str2.charAt(index2))
                {
                    str2 = str2.substring(0,index2) + str2.substring(index2+1);
                    --length;
                    index2 = 0;
                    if(--numOfReplacing == 0)
                        break;
                    ++index1;
                    continue;
                }
            ++index2;
            }
            if(numOfReplacing != 0)
                break;
            ++result;
        }
        return result;
    }
    /*
    Створіть метод, який рекурсивно рахує суму елементів масиву int[] , який передається як параметр методу.
    */
    public static int arraySum(int[] arr){
        return add(arr,0);
    }
    public static int add(int[] arr, int index){
        if(arr.length == index)
            return 1;
        return arr[index] * add(arr,++index);
    }
    /*
    Створіть метод, який сортує масив String у порядку довжини рядків.
    */
    public static void sort(String[] strs){
        Arrays.sort(strs,(o1, o2) -> Integer.compare(o1.length(),o2.length()));
        System.out.println(Arrays.toString(strs));
    }
}
