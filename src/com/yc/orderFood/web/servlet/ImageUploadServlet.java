package com.yc.orderFood.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUploadException;
import com.yc.orderFood.util.UploadUtil;

@WebServlet(urlPatterns = { "/uploadImg.s" }, initParams = { @WebInitParam(name = "PATH", value = "/images"),
		@WebInitParam(name = "ALLOWED", value = "gif,jpg,bmp,png") })
public class ImageUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UploadUtil uu = new UploadUtil("/images", "jpg,gif,png,bmp", "", 20 * 1024 * 1024, 5 * 1024 * 1024);
		String ret = "";
		try {
			Map<String,String> params = uu.uploadFiles(getServletConfig(), req, resp);
			ret = params.get("picPath1");
		} catch (SQLException | SmartUploadException e) {
			e.printStackTrace();
		}
		resp.getWriter().print(ret);
	}

}
