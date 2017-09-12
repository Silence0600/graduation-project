package edu.tjcu.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjcu.entities.ExamRoom;
import edu.tjcu.service.ExamRoomManageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.UploadFile;

public class ExamRoomManage extends ActionSupport {
	/**
	 * 考场管理
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExamRoomManageService examRoomManageService;

	public ExamRoomManageService getExamRoomManageService() {
		return examRoomManageService;
	}

	public void setExamRoomManageService(ExamRoomManageService examRoomManageService) {
		this.examRoomManageService = examRoomManageService;
	}

	private List<ExamRoom> examRooms;

	public List<ExamRoom> getExamRooms() {
		return examRooms;
	}

	public void setExamRooms(List<ExamRoom> examRooms) {
		this.examRooms = examRooms;
	}
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	public String queryAll() throws Exception {
		examRooms = examRoomManageService.queryAll();// 查出来所有的list
		session.put("key","kcgl");
		// 如果为null,怎么办?
		return "queryAllSuccess";
	}
	public String changeToAddPage() throws Exception {
		return "changeToAddPageSuc";
	}
	// 点击新增按钮则跳转新增页面
	public String change() throws Exception {
		return "changeSuccess";
	}
	// 新增页面添加考场信息的方法

	private Integer examRoomNum;
	private String examRoomName;
	private Integer accommodateNum;

	public Integer getExamRoomNum() {
		return examRoomNum;
	}

	public void setExamRoomNum(Integer examRoomNum) {
		this.examRoomNum = examRoomNum;
	}

	public String getExamRoomName() {
		return examRoomName;
	}

	public void setExamRoomName(String examRoomName) {
		this.examRoomName = examRoomName;
	}

	public Integer getAccommodateNum() {
		return accommodateNum;
	}

	public void setAccommodateNum(Integer accommodateNum) {
		this.accommodateNum = accommodateNum;
	}

	public String add() throws Exception {
		ExamRoom examRoom = new ExamRoom();
		examRoom.setExamRoomName(examRoomName);
		examRoom.setExamRoomNum(examRoomNum);
		examRoom.setAccommodateNum(accommodateNum);
		examRoomManageService.addExamRoom(examRoom);
		return "addSuccess";
	}

	private String examRoomJson;

	public String getExamRoomJson() {
		return examRoomJson;
	}

	public void setExamRoomJson(String examRoomJson) {
		this.examRoomJson = examRoomJson;
	}

	public String query() throws Exception {
		List<ExamRoom> examRooms = examRoomManageService.query(examRoomNum, examRoomName);

		if (examRooms != null) {
			JSONArray examRoomsJson = JSONArray.fromObject(examRooms);
			examRoomJson = examRoomsJson.toString();
		}
		return SUCCESS;
	}

	// 删除一条数据
	private Integer examRoomId;

	public Integer getExamRoomId() {
		return examRoomId;
	}

	public void setExamRoomId(Integer examRoomId) {
		this.examRoomId = examRoomId;
	}

	public String delete() throws Exception {
		examRoomManageService.delete(examRoomId);
		examRooms = examRoomManageService.queryAll();// 查出来所有的list
		// 如果为null,怎么办?
		return "deleteSuccess";
	}

	// 修改
	public String changeUpdate() throws Exception {
		return "changeUpdateSuccess";
	}

	// 修改一条数据
	public String update() throws Exception {
		examRoomManageService.update(examRoomId, examRoomNum, examRoomName, accommodateNum);
		return "updateSuccess";
	}


	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;

	public InputStream getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String insertExcel() throws Exception {
		String directory = "/file";
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		File target = UploadFile.Upload(uploadFile, uploadFileFileName, targetDirectory);
		// 将上传到服务器的文件转成文件输入流.
		excelFile = new FileInputStream(target);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		
		Workbook workbook = WorkbookFactory.create(target);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {
			ExamRoom er = new ExamRoom();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				String cellValue = null;
				switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
				case Cell.CELL_TYPE_STRING: //文本
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC: //数字、日期
                    if(DateUtil.isCellDateFormatted(cell)) {
                        cellValue = fmt.format(cell.getDateCellValue()); //日期型
                    }
                    else {
                        cellValue = String.valueOf(cell.getNumericCellValue()); //数字
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN: //布尔型
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK: //空白
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_ERROR: //错误
                    cellValue = "错误";
                    break;
                case Cell.CELL_TYPE_FORMULA: //公式
                    cellValue = "错误";
                    break;
                default:
                    cellValue = "错误";
                }

				switch (j) {// 通过列数来判断对应插如的字段
				case 0:					
					er.setExamRoomNum((int)Float.parseFloat(cellValue));
					break;
				case 1:
					er.setExamRoomName(cellValue);
					break;
				case 2:
					er.setAccommodateNum((int)Float.parseFloat(cellValue));
					break;
				}
			}
			examRoomManageService.addExamRoom(er);
		}
		return "insertExcelSuc";
	}
	public String exportExcel() throws Exception{
		List<ExamRoom> erList = examRoomManageService.queryAll();
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("考场信息");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("考场号");
		row.createCell(1).setCellValue("考场名");
		row.createCell(2).setCellValue("容纳人数");
		for (int i = 1; i <= erList.size(); i++) {
			ExamRoom er = erList.get(i - 1);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(er.getExamRoomNum());
			row.createCell(1).setCellValue(er.getExamRoomName());
			row.createCell(2).setCellValue(er.getAccommodateNum());
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		baos.close();
		return "excel";
	}
}
