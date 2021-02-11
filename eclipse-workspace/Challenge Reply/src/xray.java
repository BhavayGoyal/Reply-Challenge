import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class xray {
	static Scanner scanner;
	static List<String> output = new ArrayList<>();
	static int CurrentCaseMinCount;
	public static void main(String[] args) {
		File file = new File("input3.txt");
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
		int size = 2;
		List<List<String>> list2 = new LinkedList<List<String>>();
		for (int i = 1; i < list.size(); i+= size)
		{
			list2.add(list.subList(i, Math.min(i + size, list.size())));
		}
		System.out.println(list2.toString());
		Solution(list2);
	}
	
	private static void Solution(List<List<String>> list2)
	{
		int i = 0;
		while(i < list2.size())
		{
			CurrentCaseMinCount = 0;
			String RadiationString = list2.get(i).get(1);
			String RadiationArraySplitted[] = RadiationString.split(" ");
			List<String> stringList = new ArrayList<String>(RadiationArraySplitted.length);
			for (String j : RadiationArraySplitted)
			{
				stringList.add(j);
			}
			Solution2(stringList, i);
			output.add("Case #" + (i + 1) + ": " + CurrentCaseMinCount);
			CreateOutputFile(output);
	//			int[] RadiationArray = Arrays.asList(RadiationString.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
//		    if(RadiationString.contains(" 0 "))
//		    {
//
//		    }
//		    else
//		    {
////		    	String[] array = intList.toArray(new String[0]);
////		    	System.out.println(Arrays.toString(array));
//				List<Integer> intList = new ArrayList<Integer>(RadiationArray.length);
//				for (int j : RadiationArray)
//				{
//				    intList.add(j);
//				}
//		    	int Min = Collections.min(intList);
//		    	for (int k : intList)
//		    	{
////			    	System.out.println(Arrays.toStrinsg(RadiationArray));
//		    	}
//		    }
		    i++;
		}
//		CreateOutputFile(output);
	}
	
	private static void Solution2(List<String> list, int Case)
	{
		if(!list.isEmpty())
		{
			if(list.get(0).equals("0"))
			{
				list.remove(0);
//				Solution2(list, Case);
			}
			try
			{
				if(list.size() == 0)
				{
					if(list.get(0).equals("0"))
					{
						list.remove(list.size() - 1);
//						Solution2(list, Case);
					}
				}
				else
				{
					if(list.get(list.size() - 1).equals("0"))
					{
						list.remove(list.size() - 1);
					}
				}
			}
			catch(Exception e)
			{
//				System.out.println(list.toString());
			}
			System.out.println(list.toString());
			if(list.contains("0"))
			{
				System.out.println(list.toString());
				if(list.size() > 0)
				{
					if(list.size() > 0)
					{
						int occurrences = Collections.frequency(list, "0") + 1;
//						System.out.println(list.toString());
						ArrayList<String> indexes = new ArrayList<String>();
						for(int i=0; i< list.size(); i++){
					        if(list.get(i).equalsIgnoreCase("0"))
					        {
					            String id = Integer.toString(i);
					            indexes.add(id);
					        }
					    }
						ArrayList<List<String>> array = new ArrayList<List<String>>();
						for (int i = 0; i < occurrences; i++)
						{
							if(i == 0)
							{
								array.add(list.subList(i, (Integer.parseInt(indexes.get(i)))));
							}
							else if(i == occurrences - 1)
							{
								array.add(list.subList((Integer.parseInt(indexes.get(i - 1)) + 1), list.size()));
							}
							else
							{
								array.add(list.subList((Integer.parseInt(indexes.get(i - 1)) + 1), (Integer.parseInt(indexes.get(i)))));
							}
						}
//						System.out.println(indexes.toString());
//						System.out.println(array.toString());
						for(int i = 0; i < array.size(); i++)
						{
//							List<Integer> listInt = array.get(i).stream().map(Integer::parseInt).collect(Collectors.toList());
							Solution2(array.get(i), Case);
//							System.out.println(array.get(i).toString());
						}
					}
					else
					{
						System.out.println(list.toString());
					}
				}
				else
				{
//					CurrentCaseMinCount = CurrentCaseMinCount + Integer.parseInt(list.get(0));
				}
			}
			else
			{
//				System.out.println(list.toString());
				if(!list.isEmpty())
				{
					List<Integer> listInt = list.stream().map(Integer::parseInt).collect(Collectors.toList());
					int Min = Collections.min(listInt);
					List<Integer> intSubtracted = IntStream.range(0, listInt.size())
							.mapToObj(i -> listInt.get(i) - Min)
							.collect(Collectors.toList());
//						System.out.println(intSubtracted.toString());
						List<String> strings = intSubtracted.stream().map(Object::toString)
				                .collect(Collectors.toList());
						CurrentCaseMinCount = CurrentCaseMinCount + Min;
						Solution2(strings, Case);
//						System.out.println("Case" + CurrentCaseMinCount);
				}
			}
		}
		System.out.println(CurrentCaseMinCount);
//		output.add("Case #" + Case + ": " + CurrentCaseMinCount);
	}
	
//	private static void subtractMinimum(List<String> list, List<Integer> listInt, int Case)
//	{
//		if(!list.isEmpty())
//		{
//			int Min = Collections.min(listInt);
//			List<Integer> intSubtracted = IntStream.range(0, listInt.size())
//					.mapToObj(i -> listInt.get(i) - 1)
//					.collect(Collectors.toList());
////				System.out.println(intSubtracted.toString());
//				List<String> strings = intSubtracted.stream().map(Object::toString)
//		                .collect(Collectors.toList());
//				CurrentCaseMinCount = CurrentCaseMinCount + 1;
//				Solution2(strings, Case);
////				System.out.println("Case" + CurrentCaseMinCount);
//		}
//	}
	
	public static void CreateOutputFile(List<String> list)
	{
		File file = new File("output3.txt");
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
//	7
//	11 12 11 14 11 12 11
//	10
//	206 277 282 512 581 588 624 781 854 954
//	8
//	10 10 10 10 10 10 10 10
//	10
//	10 10 10 10 10 10 10 10 10 10
//	6
//	1 6 7 8 8 9
//	6
//	10 10 10 10 10 10
//	7
//	11 12 11 14 11 12 11
//	10
//	0 9 8 0 4 0 5 0 4 0
//	10
//	242 243 242 245 242 243 242 249 242 243
//	8
//	2 5 2 5 8 4 2 8
}