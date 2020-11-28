package com.javsrc.web.controller.administrator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.LogFactory;

import com.javsrc.entity.Product;
import com.javsrc.service.ProductService;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/administrator/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*String pname = request.getParameter("pName");
			String pcateID = request.getParameter("pCateID");
			String pprice = request.getParameter("pPrice");
			String psalePrice = request.getParameter("pSalePrice");
			String pinventory = request.getParameter("pInventory");
			String psaleTime = request.getParameter("pSaleTime");
			String pdesc = request.getParameter("pDesc");
			Date pcreateTime = new Date();*/
			Product product = new Product();
			Map<String,Object> map = new HashMap<String, Object>();
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			//提交组件的列表
			List<FileItem> list=upload.parseRequest(request);
			
			for(FileItem fi:list) {
				String fieldName=fi.getFieldName();
				
				if(fi.isFormField()) {
					String stringValues = fi.getString("utf-8");
					map.put(fieldName, stringValues);
				}else {
					String fileName=fi.getName();
					String imageName = fileName.substring(fileName.lastIndexOf("\\")+1);
					InputStream is=fi.getInputStream();
					String productPath=getServletContext().getRealPath("/img");
					if(imageName!="") {
						FileOutputStream os=new FileOutputStream(new File(productPath,imageName));
						IOUtils.copy(is, os);
						os.close();
					}else {
						FileOutputStream os=new FileOutputStream(new File(productPath,fileName));
						IOUtils.copy(is, os);
						os.close();
					}
					is.close();
					fi.delete();
					String path=productPath+"/"+imageName;
					map.put("thumbnail", path);
				}
			}
			
			BeanUtils.populate(product,map);
			product.setSales_volume(0);
			product.setCreate_time(new Date());
			ProductService service=new ProductService();
			service.save(product);
			request.getRequestDispatcher("/administrator/product/add.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException("保存商品失败！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
