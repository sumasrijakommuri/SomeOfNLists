import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> allLists = new ArrayList<>();
        ArrayList<String> formattedLists = new ArrayList<>();
        ArrayList<String[]> splitLists = new ArrayList<>();

        ArrayList<ArrayList<WordCount>> objectLists = new ArrayList<>();
        ArrayList<ArrayList<WordCount>> sortedLists = new ArrayList<>();

        //Reading Input
        Scanner scanner = new Scanner(System.in);
        int numberOfLists = Integer.parseInt(scanner.nextLine());
        while(numberOfLists>0)
        {
            allLists.add(scanner.nextLine());
            numberOfLists--;
        }

        //Formatting input

        for (String input:allLists) {
            input = input.replace("},{", "-");
            input = input.replace("{", "");
            input = input.replace("}", "");
            input = input.replace("[", "");
            input = input.replace("]", "");
            formattedLists.add(input);
        }

        //Splitting to strings
        for (String format:formattedLists) {
            splitLists.add(format.split("-"));
        }


        //Converting into list of WordCount objects

        ArrayList<WordCount> templist;
        for (String[] split:splitLists) {
            templist = new ArrayList<>();
            for (String unit: split) {
                String[] obj = unit.split(",");
                WordCount wc = new WordCount(obj[0], Integer.parseInt(obj[1]));
                templist.add(wc);
            }
            objectLists.add(templist);
        }

        //Sorting each list
        for (ArrayList<WordCount> list:objectLists) {
            list = MergeSort.mergeSort(list);
            sortedLists.add(list);
        }

        ArrayList<WordCount> result = new ArrayList<>();
        //merging lists
        for (ArrayList<WordCount> list:sortedLists) {
            result = MergeLists.mergeLists(list,result);
        }


        for (WordCount wc : result)
        {
            System.out.println(wc.name + " : " + wc.value);
        }
    }

}