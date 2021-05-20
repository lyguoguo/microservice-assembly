package com.gly.jxl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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
	 * @param routePath
	 * @param resCode
	 * @param resMsg
	 */
	public static void wOutPutFile(String filePath,String routePath,String resCode,String resMsg) {
		File output=new File (filePath);
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
			//第一列
			Cell cell1=readSheet.getCell(0,rsRows);
			if(cell1.getContents().equals("")) {
				Label labetest1=new Label(0,rsRows,routePath);
				Label labetest2=new Label(1,rsRows,resCode);
				if("200".equals(resCode)) {
					wcf.setBackground(Colour.BRIGHT_GREEN);
				}else {
					wcf.setBackground(Colour.RED);
				}
				Label labetest3=new Label(2, rsRows, resMsg, wcf);
				readSheet.addCell(labetest1);
				readSheet.addCell(labetest2);
				readSheet.addCell(labetest3);
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
	public static String cOutputFile(String filePath) {
		try {
		File output=new File(filePath);
		if(!output.exists()) {
				output.createNewFile();
				WritableWorkbook writeBook=Workbook.createWorkbook(output);
				WritableSheet sheet = writeBook.createSheet("输出结果", 0);
				WritableFont headfont=new WritableFont(WritableFont.createFont("宋体"),11,WritableFont.BOLD);
				WritableCellFormat headwcf=new WritableCellFormat(headfont);
				headwcf.setBackground(Colour.GRAY_25);
				sheet.setColumnView(0, 11);
				sheet.setColumnView(1, 20);
				sheet.setColumnView(2, 40);
				headwcf.setAlignment(Alignment.CENTRE);
				headwcf.setVerticalAlignment(VerticalAlignment.CENTRE);
				Label labe00=new Label(0,0,"请求路由",headwcf);
				Label labe10=new Label(1,0,"响应状态",headwcf);
				Label labe20=new Label(2,0,"响应结果",headwcf);
				sheet.addCell(labe00);
				sheet.addCell(labe10);
				sheet.addCell(labe20);
				writeBook.write();
				writeBook.close();
			}
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return filePath;
	}

	public static void generateFile(String filePath,String routePath,String resCode,String resMsg){
		cOutputFile(filePath);
		wOutPutFile(filePath, routePath, resCode,resMsg);
	}
	public static void main(String[] args) {
		String path = "D:\\route_res.xls";
		generateFile(path, "/test1", "200","成功啦，我返回success");
		generateFile(path, "/test2", "404","失败啦，我是不存在哒");
		generateFile(path, "/test3", "504","失败啦，我要的服务不在线哇");
	}

}

