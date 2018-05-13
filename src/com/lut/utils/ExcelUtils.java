package com.lut.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.lut.vo.scoreNcourse.Score;

public class ExcelUtils {

    /**
     * 导出用户的所有列表到excel
     * 
     * @param ScoreList
     *            用户列表
     * @param outputStream
     *            输出流       
     */
    public static void exportScoreExcel(List<Score> scoreList, OutputStream outputStream) {
	try {
	    // 1、创建工作簿
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    // 1.1、创建合并单元格对象
	    CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);
	    // 1.2、头标题样式
	    HSSFCellStyle titleStyle = createCellStyle(workbook, (short) 16);
	    // 1.3、列标题样式
	    HSSFCellStyle columnHeaderStyle = createCellStyle(workbook, (short) 13);

	    // 2、创建工作表
	    HSSFSheet sheet = workbook.createSheet("列表");
	    // 2.1、加载合并单元格对象
	    sheet.addMergedRegion(cellRangeAddress);
	    // 设置默认列宽
	    sheet.setDefaultColumnWidth(25);

	    // 3、创建行
	    // 3.1、创建头标题行；并且设置头标题
	    HSSFRow titleRow = sheet.createRow(0);
	    HSSFCell titleCell = titleRow.createCell(0);
	    // 加载单元格样式
	    titleCell.setCellStyle(titleStyle);
	    titleCell.setCellValue("列表");

	    // 3.2、创建列标题行；并且设置列标题
//	    学年</th>学期</th>姓名</th>专业</th>班级</th>科目</th>成绩</th>
	    HSSFRow columnHeaderRow = sheet.createRow(1);
	    String[] titles = { "学年", "学期", "ID","姓名", "专业", "班级","科目","成绩" };

	    for (int i = 0; i < titles.length; i++) {
		HSSFCell columnHeaderCell = columnHeaderRow.createCell(i);
		// 加载单元格样式
		columnHeaderCell.setCellStyle(columnHeaderStyle);
		columnHeaderCell.setCellValue(titles[i]);
	    }

	    // 4、操作单元格；将用户列表写入excel
	    if (scoreList != null) {
		for (int j = 0; j < scoreList.size(); j++) {
		    HSSFRow row = sheet.createRow(j + 2);
		    HSSFCell dataCell0 = row.createCell(0);
		    dataCell0.setCellValue(scoreList.get(j).getS_year());
		    HSSFCell dataCell1 = row.createCell(1);
		    dataCell1.setCellValue((scoreList.get(j).getS_half() == 1) ?"上学期":"下学期");
		    HSSFCell dataCell2 = row.createCell(2);
		    dataCell2.setCellValue(scoreList.get(j).getStudent().getId());		    
		    HSSFCell dataCell3 = row.createCell(3);
		    dataCell3.setCellValue(scoreList.get(j).getStudent().getName());		    
		    HSSFCell dataCell4 = row.createCell(4);
		    dataCell4.setCellValue(scoreList.get(j).getStudent().getMajor().getM_name());
		    HSSFCell dataCell5 = row.createCell(5);
		    dataCell5.setCellValue(scoreList.get(j).getStudent().getClazz().getClass_name());
		    HSSFCell dataCell6 = row.createCell(6);
		    dataCell6.setCellValue(scoreList.get(j).getCourse().getC_name());
		    HSSFCell dataCell7 = row.createCell(7);
		    dataCell7.setCellValue(scoreList.get(j).getS_score());
		}
	    }
	    // 5、输出
	    workbook.write(outputStream);
	    workbook.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 创建单元格样式
     * 
     * @param workbook
     *            工作簿
     * @param fontSize
     *            字体大小
     * @return
     */
    private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
	HSSFCellStyle style = workbook.createCellStyle();
//	style.setAlignment(HSSFCellStyle.AL);// 水平居中
//	style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
	// 创建字体
	HSSFFont font = workbook.createFont();
	// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗字体
	font.setFontHeightInPoints(fontSize);
	// 加载字体
	style.setFont(font);
	return style;
    }

}
