import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class virus {
//	private static int NoOfTestCases;
	static Scanner scanner;
	static List<String> output = new ArrayList<>();
	public static void main(String[] args) {
		File file = new File("input2.txt");
		ReadFile(file);
	}
	
	public static void ReadFile(File file)
	{
		try {
			scanner = new Scanner(file);
			ArrayList<String> list = new ArrayList<String>();
			while (scanner.hasNextLine()){
			    list.add(scanner.nextLine());
			}
			scanner.close();
			ProcessFile(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void ProcessFile(ArrayList<String> list) {
		int size = 6;
		List<List<String>> list2 = new LinkedList<List<String>>();
		for (int i = 1; i < list.size(); i+= size)
		{
			list2.add(list.subList(i, Math.min(i + size, list.size())));
		}
		System.out.println(list2.toString());
		ProcessFurther(list2);
	}
	
	private static void ProcessFurther(List<List<String>> list2) {
		int i = 0;
		while(i < list2.size())
		{
//			int VirusSize = Integer.parseInt(list2.get(i).get(1));
			String fileName1 = list2.get(i).get(2);
			String fileName2 = list2.get(i).get(3);
			String fileName3 = list2.get(i).get(4);
			String fileName4 = list2.get(i).get(5);
			String array[] = {fileName1, fileName2, fileName3, fileName4};
			String common = findstem(array);
//				common = common1;
				int index1 = fileName1.indexOf(common);
				int index2 = fileName2.indexOf(common);
				int index3 = fileName3.indexOf(common);
				int index4 = fileName4.indexOf(common);
				output.add("Case #" + (i + 1) + ": " + index1 + " " + index2 + " " + index3 + " " + index4 + " ");
				System.out.println(common);
			i++;
		}
		CreateOutputFile(output);
	}
	
	public static String findstem(String arr[])
    {
        // Determine size of the array
        int n = arr.length;
 
        // Take first word from array as reference
        String s = arr[0];
        int len = s.length();
 
        String res = "";
 
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
 
                // generating all possible substrings
                // of our reference string arr[0] i.e s
                String stem = s.substring(i, j);
                int k = 1;
                for (k = 1; k < n; k++)
 
                    // Check if the generated stem is
                    // common to all words
                    if (!arr[k].contains(stem))
                        break;
 
                // If current substring is present in
                // all strings and its length is greater
                // than current result
                if (k == n && res.length() < stem.length())
                    res = stem;
            }
        }
 
        return res;
    }
	
	public static void CreateOutputFile(List<String> list)
	{
		File file = new File("output2.txt");
		try {
			if(file.createNewFile())
			{
				
			}
			FileWriter fileWriter = new FileWriter(file);
			for(String str : list)
			{
				fileWriter.write(str + System.lineSeparator());
			}
			fileWriter.close();
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}