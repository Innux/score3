package com.lut.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;

import com.lut.dao.CourseDao;
import com.lut.dao.ScoreDao;
import com.lut.dao.StudentDao;
import com.lut.utils.ExcelUtils;
import com.lut.utils.PageBean;
import com.lut.vo.Clazz;
import com.lut.vo.Major;
import com.lut.vo.Student;
import com.lut.vo.scoreNcourse.Course;
import com.lut.vo.scoreNcourse.Score;

@Transactional
public class ScoreService {

    private ScoreDao scoreDao;

    public void setScoreDao(ScoreDao scoreDao) {
	this.scoreDao = scoreDao;
    }

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
	this.studentDao = studentDao;
    }

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
	this.courseDao = courseDao;
    }

    public PageBean<Score> findByPage(Integer page) {
	PageBean<Score> pageBean = new PageBean<Score>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 10;
	pageBean.setLimit(limit);
	// 设置总记录数:
	int totalCount = 0;
	totalCount = scoreDao.findCount();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	// 每页显示的数据集合:
	// 从哪开始:
	int begin = (page - 1) * limit;
	List<Score> list = scoreDao.findByPage(begin, limit);
	pageBean.setList(list);
	return pageBean;
    }

    public Score findByScoreId(Integer s_id) {
	return scoreDao.findByScoreId(s_id);
    }

    public void delete(Score score) {
	scoreDao.delete(score);
    }

    public PageBean<Score> findByPage(Score searchModel, Integer page) {
	PageBean<Score> pageBean = new PageBean<Score>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 10;
	pageBean.setLimit(limit);
	int begin = (page - 1) * limit;
	int totalCount = 0;
	Map<String, List<?>> map = scoreDao.findByPage(searchModel, begin, limit);
	List<Long> countList = (List<Long>) map.get("countList");
	totalCount = countList.get(0).intValue();
	// totalCount = scoreDao.findCount();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);

	List<Score> scoreList = (List<Score>) map.get("scoreList");
	pageBean.setList(scoreList);
	return pageBean;
    }
    

    public PageBean<Score> stuFindByPage(Integer stuId,Score searchModel, Integer page) {
	PageBean<Score> pageBean = new PageBean<Score>();
	// 设置当前页数:
	pageBean.setPage(page);
	// 设置每页显示记录数:
	int limit = 10;
	pageBean.setLimit(limit);
	int begin = (page - 1) * limit;
	int totalCount = 0;
	
	Map<String, List<?>> map = scoreDao.stuFindByPage(stuId,searchModel, begin, limit);
	List<Long> countList = (List<Long>) map.get("countList");
	
	totalCount = countList.get(0).intValue();
	// totalCount = scoreDao.findCount();
	pageBean.setTotalCount(totalCount);
	// 设置总页数:
	int totalPage = 0;
	if (totalCount % limit == 0) {
	    totalPage = totalCount / limit;
	} else {
	    totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);

	List<Score> scoreList = (List<Score>) map.get("scoreList");
	pageBean.setList(scoreList);
	return pageBean;
    }

    public List<Object[]> findByStuId(int id) {
	List<Object[]> list = scoreDao.findByStuId(id);
	return list;
    }

    public List<Score> findAll() {
	// TODO Auto-generated method stub
	return scoreDao.findAll();
    }

    public void exportExcel(List<Score> scoreList, ServletOutputStream outputStream) {
	ExcelUtils.exportScoreExcel(scoreList, outputStream);
    }

    public void importExcel(File scoreExcel, String scoreExcelFileName) {
	try {
	    FileInputStream fileInputStream = new FileInputStream(scoreExcel);
	    boolean is03Excel = scoreExcelFileName.matches("^.+\\.(?i)(xls)$");
	    Workbook workbook = is03Excel ? new HSSFWorkbook(fileInputStream) : new XSSFWorkbook(fileInputStream);
	    Sheet sheet = workbook.getSheetAt(0);
	    if (sheet.getPhysicalNumberOfRows() > 2) {
		Score score = null;
		Student student = null;
		Course course = null;
		for (int k = 2; k < sheet.getPhysicalNumberOfRows(); k++) {
		    Row row = sheet.getRow(k);
		    score = new Score();
		    // 学年
		    Cell cell0 = row.getCell(0);
		    score.setS_year(cell0.getStringCellValue());
		    // 学期
		    Cell cell1 = row.getCell(1);
		    score.setS_half((cell1.getStringCellValue().equals("上学期") ? 1 : 2));
		    // 以下为学生信息
		    // 学生id
		    Cell cell2 = row.getCell(2);
		    
		    int id = (int) cell2.getNumericCellValue();
		    // 姓名
		    student = studentDao.findByStuId(id);
		    // 设置score的student
		    score.setStudent(student);

		    // 科目
		    Cell cell6 = row.getCell(6);
		    String name = cell6.getStringCellValue().trim();
		    course = courseDao.findByName(name);
		    // 设置score的course
		    score.setCourse(course);

		    // 成绩
		    Cell cell7 = row.getCell(7);
		    int sco = (int) cell7.getNumericCellValue();
		    score.setS_score(sco);

		    // 5、保存
		    scoreDao.save(score);
		}
		workbook.close();
		fileInputStream.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }


}
