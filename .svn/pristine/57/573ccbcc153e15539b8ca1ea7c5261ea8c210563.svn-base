package com.tj720.admin.common.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcleToList {
	//读取excle表
		public static List<List<String>> readXlsx(String path,int sheet) throws Exception{
			InputStream is = new FileInputStream(path);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			List<List<String>> result = new ArrayList<List<String>>();
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheet);
				if(xssfSheet == null){
				}else{
					for(int rowNum = 1 ;rowNum<=xssfSheet.getLastRowNum() ; rowNum++){
						XSSFRow xssfRow = xssfSheet.getRow(rowNum);
						int minColIx = xssfRow.getFirstCellNum()+1;
						int maxColIx = xssfRow.getLastCellNum();
						List<String> rowList = new ArrayList<String>();
						for(int colIx = 1;colIx<maxColIx;colIx++){
							XSSFCell cell = xssfRow.getCell(colIx);
							if(cell==null){
								rowList.add("");
								continue;
							}
							rowList.add(cell.toString());
							
						}
						result.add(rowList);
					}
				}
			return result;
		}
		public static List<List<String>> readXlsx1(String path,int sheet) throws Exception{
			InputStream is = new FileInputStream(path);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			List<List<String>> result = new ArrayList<List<String>>();
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheet);
			if(xssfSheet == null){
			}else{
				for(int rowNum = 1 ;rowNum<=xssfSheet.getLastRowNum() ; rowNum++){
					XSSFRow xssfRow = xssfSheet.getRow(rowNum);
					int minColIx = xssfRow.getFirstCellNum()+1;
					int maxColIx = xssfRow.getLastCellNum();
					List<String> rowList = new ArrayList<String>();
					for(int colIx = minColIx;colIx<maxColIx;colIx++){
						XSSFCell cell = xssfRow.getCell(colIx);
						if(cell==null){
							rowList.add("");
							continue;
						}
						rowList.add(cell.toString());
						
					}
					result.add(rowList);
				}
			}
			return result;
		}

}
