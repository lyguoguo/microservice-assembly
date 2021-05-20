package com.gly.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CWOutputFile {
	/**
	 * 写结果文件
	 * @param filePath
	 * @param caseNo
	 * @param testPoint
	 * @param preResult
	 * @param fresult
	 */
	public void wOutPutFile(String filePath,String caseNo,String testPoint,String testData,String preResult,String fresult) {
		File output=new File (filePath);
		String result="";
		try {
			//输入流
			InputStream inputStream=new FileInputStream(filePath);
			//创建workbook
			Workbook readwb=Workbook.getWorkbook(inputStream);
			//根据文件创建一个操作对象
			WritableWorkbook wbook = Workbook.createWorkbook(output, readwb);
			//得到sheet
			WritableSheet readSheet = wbook.getSheet(0);
			//获取总行数
			int rsRows=readSheet.getRows();
			//字体样式设置
			WritableFont font=new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);
			WritableCellFormat wcf=new WritableCellFormat(font);
			/
			//第一列
			Cell cell1=readSheet.getCell(0,rsRows);
			if(cell1.getContents().equals("")) {
				Label labetest1=new Label(0,rsRows,caseNo);
				Label labetest2=new Label(1,rsRows,testPoint);
				Label labetest3=new Label(2,rsRows,testData);
				Label labetest4=new Label(3,rsRows,preResult);
				Label labetest5=new Label(4,rsRows,fresult);
				if(preResult.equals(fresult)) {
					result="通过";
					wcf.setBackground(Colour.BRIGHT_GREEN);
				}else {
					result="不通过";
					wcf.setBackground(Colour.RED);
				}
				Label labetest6=new Label(5, rsRows, result, wcf);
				readSheet.addCell(labetest1);
				readSheet.addCell(labetest2);
				readSheet.addCell(labetest3);
				readSheet.addCell(labetest4);
				readSheet.addCell(labetest5);
				readSheet.addCell(labetest6);
			}
			wbook.write();
			wbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String cOutputFile(String tradeType) {
		String filePath="";
		try {
		String temp_str="";
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		temp_str=sdf.format(date);
		 filePath="d:\\\\"+tradeType+"_output_"+temp_str+".xls";
		File output=new File(filePath);
		if(!output.isFile()) {
				output.createNewFile();
				WritableWorkbook writeBook=Workbook.createWorkbook(output);
				WritableSheet sheet = writeBook.createSheet("输出结果", 0);
				WritableFont headfont=new WritableFont(WritableFont.createFont("宋体"),11,WritableFont.BOLD);
				WritableCellFormat headwcf=new WritableCellFormat(headfont);
				headwcf.setBackground(Colour.GRAY_25);
				sheet.setColumnView(0, 11);
				sheet.setColumnView(1, 20);
				sheet.setColumnView(2, 40);
				sheet.setColumnView(3, 10);
				sheet.setColumnView(4, 10);
				sheet.setColumnView(5, 10);
				headwcf.setAlignment(Alignment.CENTRE);
				headwcf.setVerticalAlignment(VerticalAlignment.CENTRE);
				Label labe00=new Label(0,0,"用例编号",headwcf);
				Label labe10=new Label(1,0,"用例标题",headwcf);
				Label labe20=new Label(2,0,"测试数据",headwcf);
				Label labe30=new Label(3,0,"预期结果",headwcf);
				Label labe40=new Label(4,0,"实际结果",headwcf);
				Label labe50=new Label(5,0,"执行结果",headwcf);
				sheet.addCell(labe00);
				sheet.addCell(labe10);
				sheet.addCell(labe20);
				sheet.addCell(labe30);
				sheet.addCell(labe40);
				sheet.addCell(labe50);
				writeBook.write();
				writeBook.close();
			}
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return filePath;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CWOutputFile cwOutputFile=new CWOutputFile();
		String cOutputFile = cwOutputFile.cOutputFile("aa");
		cwOutputFile.wOutPutFile(cOutputFile, "1", "1", "测试数据", "预期结果", "实际结果");
	}

}

