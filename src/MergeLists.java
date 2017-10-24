import java.util.*;

public class MergeLists {
    public static ArrayList<WordCount> mergeLists(ArrayList<WordCount> left, ArrayList<WordCount> right)
    {
        ArrayList<WordCount> result= new ArrayList<>();

        int leftindex= 0;
        int rightindex=0;

        while(leftindex <left.size() && rightindex <right.size())
        {
            WordCount w1 = left.get(leftindex);
            WordCount w2 = right.get(rightindex);
            if(w1.name.equals(w2.name))
            {
                result.add(new WordCount(w1.name,w1.value+w2.value));
                leftindex++;
                rightindex++;
            }
            else if(w1.name.compareTo(w2.name)<0)
            {
                result.add(w1);
                leftindex++;
            }
            else
            {
                result.add(w2);
                rightindex++;
            }
        }

        if(leftindex == left.size())
        {
            while(rightindex < right.size())
            {
                result.add(right.get(rightindex));
                rightindex++;
            }
        }
        else if(rightindex== right.size())
        {
            while (leftindex< left.size())
            {
                result.add(left.get(leftindex));
                leftindex++;
            }
        }

        return result;
    }
}

