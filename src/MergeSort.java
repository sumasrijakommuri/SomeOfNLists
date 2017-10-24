import java.util.*;

public class MergeSort {
    public static ArrayList<WordCount> mergeSort(ArrayList<WordCount> input)
    {
        ArrayList<WordCount> left = new ArrayList<>();
        ArrayList<WordCount> right = new ArrayList<>();
        int length = input.size();
        int middle;

        if(input.size()==1 || input.size()==0)
        {
            return input;
        }
        else
        {
            middle = length/2;
            for(int i =0; i<middle;i++)
            {
                left.add(input.get(i));
            }
            for(int j=middle;j<length;j++)
            {
                right.add(input.get(j));
            }

            left = mergeSort(left);
            right = mergeSort(right);

            merge(left,right,input);
        }

        return input;
    }

    public static void merge(ArrayList<WordCount> left, ArrayList<WordCount> right, ArrayList<WordCount> input)
    {
        int leftindex = 0;
        int rightindex = 0;
        int inputindex =0;

        while(leftindex<left.size() && rightindex< right.size()){
            if(left.get(leftindex).name.compareTo(right.get(rightindex).name)<0)
            {
                input.set(inputindex,left.get(leftindex));
                leftindex++;
            }
            else
            {
                input.set(inputindex,right.get(rightindex));
                rightindex++;
            }
            inputindex++;
        }

        ArrayList<WordCount> intermediate;
        int interindex =0;
        if (leftindex >= left.size()) {
            intermediate = right;
            interindex = rightindex;
        } else {
            intermediate = left;
            interindex = leftindex;
        }

        for(int i=interindex;i<intermediate.size();i++)
        {
            input.set(inputindex,intermediate.get(interindex));
            inputindex++;
        }
    }
}
