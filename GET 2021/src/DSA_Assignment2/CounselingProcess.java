package DSA_Assignment2;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CounselingProcess {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of programs:- ");
		int numberOfPrograms = scanner.nextInt();
		LinkedHashMap<String, Integer> newHashMap = new LinkedHashMap<>();
		ArrayList<String> newArrayList = new ArrayList<>();
		
		for(int i=0; i< numberOfPrograms; i++) {
			System.out.println("Enter the program with capacity of students..");
			String programName = scanner.next();
			int capacity = scanner.nextInt();
			//newHashMap.put(programName, capacity);
			for(int j = 0; j< capacity; j++)
				newArrayList.add(programName);
		}
		
		LinkedHashMap<String, Object[]> outputHashMap = new LinkedHashMap<String, Object[]>();
		
		String inputFilePath = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/ExcelFiles/inputSheet.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(new File(inputFilePath));
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // method to get input sheet1
		
		int numberOfRows = sheet.getLastRowNum(); //fetching the number of rows
		int numberOfColumns = sheet.getRow(1).getLastCellNum();
		
		String[][] studentArray = new String[numberOfRows][6];
		
		for(int i = 1; i<= numberOfRows; i++) {
			XSSFRow particularRow = sheet.getRow(i);
			for(int j = 1; j<= numberOfColumns-1; j++) {
				XSSFCell cell = particularRow.getCell(j);
				String fetchValue = cell.getStringCellValue();
				//System.out.print(fetchName+" ");
				studentArray[i-1][j-1] = fetchValue;
			}
			//System.out.println();
		}
        int columnInArray =6;
        
		for(int i =0; i< studentArray.length; i++) {
			int flag = 0;
			for(int j=1;j< columnInArray ; j++) {
				if(newArrayList.contains(studentArray[i][j])) {
					outputHashMap.put(String.valueOf(i),new Object[]{studentArray[i][0], studentArray[i][j]});
					newArrayList.remove(studentArray[i][j]);
					flag = 1;
				}
			}
			if(flag == 0)
				outputHashMap.put(String.valueOf(i), new Object[]{studentArray[i][0], "Program not allocated"});
		}
		
	   
		XSSFSheet sheet2 = workbook.getSheet("Sheet2");
		int row1 = 0;
		//XSSFRow particularRow1 = sheet2.createRow(row1++);
		Set<String> keyset = outputHashMap.keySet();
		for(String key : keyset) {
			Row row = sheet2.createRow(row1++);
			Object[] objectArray = outputHashMap.get(key);
			int cellNumber =0;
			for(Object object : objectArray) {
				System.out.println((String)object);
				Cell cell = row.createCell(cellNumber++);
				cell.setCellValue((String)object);
			}
		}
		FileOutputStream newFileOutputStream = new FileOutputStream(new File(inputFilePath));
		workbook.write(newFileOutputStream);
		newFileOutputStream.close();
		
	}
}
