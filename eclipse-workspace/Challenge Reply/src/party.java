import java.io.*;
import java.util.*;

public class party {
	private static int NoOfTestCases;
	static Scanner scanner;
	static List<String> output = new ArrayList<>();

	public static void main(String[] args) {
		File file = new File("input.txt");
		ReadFile(file);
	}
	
	public static void ReadFile(File file)
	{
		try {
			scanner = new Scanner(file);
			int i = 0;
			int CurrentTestCaseSize = 0;
			int Case = 0;
			while(scanner.hasNextLine())
			{
				String nextLine = scanner.nextLine();
				if(i == 0)
				{
					NoOfTestCases = Integer.parseInt(nextLine);
//					System.out.println(NoOfTestCases);	
				}
				else
				{
					if(nextLine.contains(" "))
					{
						Case++;
						int j = 0;
						int Sum = 0;
						String currentTestCases[] = nextLine.split(" ");
						while(j < CurrentTestCaseSize)
						{
							if(!(Integer.parseInt(currentTestCases[j]) <= 0))
							{
								Sum = Sum + Integer.parseInt(currentTestCases[j]);
							}
							j++;
						}
						output.add("Case #" + Case + ": " + Sum);
						
					}
					else
					{
						CurrentTestCaseSize = Integer.parseInt(nextLine);
					}
				}
				i++;				
			}
			CreateOutputFile(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateOutputFile(List<String> list)
	{
		File file = new File("output.txt");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
