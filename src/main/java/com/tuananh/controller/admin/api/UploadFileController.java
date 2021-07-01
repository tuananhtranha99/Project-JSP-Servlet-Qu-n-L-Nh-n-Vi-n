package com.tuananh.controller.admin.api;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuananh.dao.IEmployeeDAO;


@WebServlet(value = "/api-upload-file/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxRequestSize = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50)
/**
 *  fileSizeThreshold: nếu kích thước 1 file vượt quá dung lượng đã cấu hình thì sẽ được lưu trực tiếp lên ổ đĩa mà không thông qua bộ đệm
 *  maxRequestSize: dung lượng tối đa của 1 request (1 request có thể có nhiều file, tổng dung lượng các file không được vượt quá giá trị này)
 *  maxFileSize: dung lượng tối đa của 1 File
 *
 */
public class UploadFileController extends HttpServlet{
	private static final long serialVersionUID = -7167694688161642839L;
	
	public static final String SAVE_DIRECTORY = "webapp";
	
	@Inject
	private IEmployeeDAO employeeDAO;
	
	private static String fileNameRs; 
	
	public String getExtendedFileName(Long id) {
		String fileName = fileNameRs;
		if(fileName != null && !fileName.isEmpty()) {
			fileName = fileName.substring(fileName.lastIndexOf("."));
			fileName = id + fileName;
		}
		return fileName;
	}

    private String getFileName(Part part) {
        String fileNameRs = null;
        //thuộc tính header của đối tượng part tương ứng với key content-disposition
        // thì sẽ chưa một một chuỗi có định dạng tương tự
        // form-data; name="file"; filename="C:\a\file1.zip"
        //từ chuỗi này mình lấy ra tên file và phần mở rộng của file.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s: items) {
            if(s.trim().startsWith("filename")) {
                //filename="C:\file1.zip"
                fileNameRs = s.substring(s.indexOf("=") + 2, s.length() - 1);
                fileNameRs = fileNameRs.replace("\\", "/");
                int i = fileNameRs.lastIndexOf("/");
                fileNameRs = fileNameRs.substring(i + 1);
            }
        }
        this.fileNameRs = fileNameRs;
        return fileNameRs ;
    }
    
    private File getFolderUpload() {
        //kiểm soát thư mục muốn file trên server
        String appPath = "D:\\eclipse-java-2020-06-R-win32-x86_64\\eclipse\\Quan_Ly_Nhan_Vien\\src\\main\\";
        //thư muốn upload vào thì phaior tạo ra một biến static final

        //1 file sẽ nằm trong 1 thư mục giải quyết trùng tên file
        //chú ý kết quả trả về phải đúng đường dẫn

        //=> 1 request tạo ra 1 thư muc
        appPath += SAVE_DIRECTORY + File.separator ;
        //xảy ra 2 trường hợp 1 là thư mục SAVE đã tồn tại, SAVE chưa tồn
        File folderUpload = new File(appPath);
        if(!folderUpload.exists()) {
            //tạo các thư mục
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String id = req.getParameter("id");
            //lây ra được các file người dùng truyền lên
            Collection<Part> partCollection = req.getParts();
            if(partCollection != null) {
                //duyệt từng file và thực hiện lưu các file đấy
                for (Part part : partCollection) {
                    //thực hiện các bước lưu file
                    //tên file phải đưuọc giữ nguyên, ghi dữ liệu của file

                    //tên file của người dùng truyền lên sẽ nằm trong đối tượng Part
                    //tên file nó nằm trong một chuỗi phức tạp => tạo ra hàm tách tên file từ chuỗi phức tạp đấy.
                    String fileName = getFileName(part);
                    
                    
                    
                    if(fileName != null && !fileName.isEmpty()) {
                    	 
                    	fileName = fileName.substring(fileName.lastIndexOf("."));
                    	if(id == null || id.isEmpty()) {
                    		fileName = "" + (employeeDAO.getLastId()+1) + fileName;
                    	} else {
                    		fileName = id + fileName;
                    	}
                    	
                        //lưu file thì lưu ở đâu (chỉ ra đường dẫn tuyệt đối
                        // địa điểm mà muốn lưu file)
                        //phải có hàm kiểm soát thư mục lưu trữ file getFolderUpload()
                        //.getAbsolutePath() lấy đường dẫn tuyệt đối của thư mục muốn upload vào
                        //D:\\file-upload
                        String filePath = getFolderUpload().getAbsolutePath() + File.separator + fileName;
                        System.out.println("Write File: " + filePath);
                        //thực hiện ghi file
                        part.write(filePath);
                    }
                }
            } 
//            resp.sendRedirect("/Quan_Ly_Nhan_Vien/admin-employee-edit?id=" + req.getParameter("id") + "&message=update_success");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	

	

}
