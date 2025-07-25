package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtility {
	
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet   sh;
public static String getStringData(int a,int b,String sheetName) throws IOException//a=row,b=cell
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\NewExcel.xlsx");//load file from disk
		wb= new XSSFWorkbook(f);//load work book
		sh=wb.getSheet(sheetName);//to get details from sheet
		XSSFRow r =sh.getRow(a);//to get value from row
		XSSFCell c = r.getCell(b);//to get value from cell corresponding to the row
		return c.getStringCellValue();//method to return cell value
	}
public static String getIntData(int a,int b,String sheetName) throws IOException
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\NewExcel.xlsx");//load file from disk
		wb= new XSSFWorkbook(f);//load work book
		sh=wb.getSheet(sheetName);//to get details from sheet
		XSSFRow r =sh.getRow(a);//to get value from row
		XSSFCell c = r.getCell(b);//to get value from cell corresponding to the row
		int n1=(int)c.getNumericCellValue();//typecasting-converting the int value to string
		return String.valueOf(n1);//type conversion,convert any data type to string
		
	}

public static String getFloatData(int a,int b,String sheetName) throws IOException
	{
		f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\NewExcel.xlsx");//load file from disk
		wb= new XSSFWorkbook(f);//load work book
		sh=wb.getSheet(sheetName);//to get details from sheet
		XSSFRow r =sh.getRow(a);//to get value from row
		XSSFCell c = r.getCell(b);//to get value from cell corresponding to the row
		float n1=(float)c.getNumericCellValue();//typecasting-converting float value to string
		return String.valueOf(n1);//type conversion
		
	}


}
