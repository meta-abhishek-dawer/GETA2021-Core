package DSA_Assignment2;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CounselingProcess {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of programs:- ");
		int numberOfPrograms = scanner.nextInt();
		HashMap<String, Integer> newHashMap = new HashMap<>();
		
		for(int i=0; i< numberOfPrograms; i++) {
			System.out.println("Enter the program with capacity of students..");
			String programName = scanner.next();
			int capacity = scanner.nextInt();
			newHashMap.put(programName, capacity);
		}
		
		HashMap<String, String> outputHashMap = new HashMap<>();
		
		//SString inputFilePath = ".\\ExcelFiles\\inputSheet.xlsx";
		String inputFilePath = "C:\\Users\\abhishek.dawer_metac\\git\\GETA2021-Core\\GET 2021\\ExcelFiles\\inputSheet.xlsx";
		FileInputStream inputStream = new FileInputStream(inputFilePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // method to get input sheet1
		
		int numberOfRows = sheet.getLastRowNum(); //fetching the number of rows
		int numberOfColumns = sheet.getRow(1).getLastCellNum();
		
		for(int i = 1; i<= numberOfRows; i++) {
			XSSFRow particularRow = sheet.getRow(i);
			for(int j = 1; j<= numberOfColumns-1; j++) {
				XSSFCell cell = particularRow.getCell(j);
				String fetchName = cell.getStringCellValue();
				//String setProgram;
				int length= j+1;
				System.out.print(fetchName+" ");
			}
			System.out.println();
		}

	}

}
