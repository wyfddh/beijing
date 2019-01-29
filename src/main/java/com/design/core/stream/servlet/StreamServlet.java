package com.design.core.stream.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.design.core.stream.config.Configurations;
import com.design.core.stream.util.IoUtil;
import com.design.utils.DateUtils;
import com.design.utils.FileUtils;
import com.design.utils.StringUtil;

/**
 * File reserved servlet, mainly reading the request parameter and its file
 * part, stored it.
 */
public class StreamServlet extends HttpServlet {
	private static final long serialVersionUID = -8619685235661387895L;
	/** when the has increased to 10kb, then flush it to the hard-disk. */
	static final int BUFFER_LENGTH = 1024;
	static final String START_FIELD = "start";
	public static final String CONTENT_RANGE_HEADER = "content-range";
	private static Map<String,String> filemap = new HashMap<String,String>();

	@Override
	public void init() throws ServletException {
	}
	
	/**
	 * Lookup where's the position of this file?
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doOptions(req, resp);

		final String token = req.getParameter(TokenServlet.TOKEN_FIELD);
		final String size = req.getParameter(TokenServlet.FILE_SIZE_FIELD);
		final String fileName = req.getParameter(TokenServlet.FILE_NAME_FIELD);
		final PrintWriter writer = resp.getWriter();
//		String typecode = req.getParameter("typecode");
		/** TODO: validate your token. */
		String myfilename = "";
		JSONObject json = new JSONObject();
		long start = 0;
		boolean success = true;
		String message = "";
		try {
			File f = IoUtil.getTokenedFile(token);
			start = f.length();
			/** file size is 0 bytes. */
			if ((token.endsWith("_0") && "0".equals(size) && 0 == start)||start == Integer.parseInt(token.split("_")[1]))
				f.renameTo(IoUtil.getFile(fileName));
			String extend = FileUtils.getExtend(fileName);// 获取文件扩展名
			String noextfilename = "";// 不带扩展名
			
			noextfilename = DateUtils
					.getDataString(DateUtils.yyyymmddhhmmss)
					+ StringUtil.random(8);// 自定义文件名称
			myfilename = noextfilename + "." + extend;// 自定义文件名称
			String inputFile=Configurations.getFileRepository() + token;
			String outFile=Configurations.getFileRepository().replace("temp/", "");
//			if(StringUtil.isNotEmpty(typecode)){
//				outFile+=typecode+"/";
//			}
			if(!filemap.containsKey(token)){
				filemap.put(token, myfilename);
			}else{
				filemap.remove(token);
				filemap.put(token, myfilename);
			}
			FileUtils.copyFileToFolderAndChangeName(inputFile,outFile,myfilename);
		} catch (FileNotFoundException fne) {
			message = "Error: " + fne.getMessage();
			success = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (success)
					json.put(START_FIELD, start);
				json.put(TokenServlet.SUCCESS, success);
				json.put(TokenServlet.MESSAGE, message);
				json.put(TokenServlet.FILE_NAME, myfilename);
			} catch (JSONException e) {}
			writer.write(json.toString());
			IoUtil.close(writer);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doOptions(req, resp);
		
		final String token = req.getParameter(TokenServlet.TOKEN_FIELD);
		final String fileName = req.getParameter(TokenServlet.FILE_NAME_FIELD);
		String attchPath = req.getParameter("attchPath");
		String mainCode = req.getParameter("mainCode");
		String detailCode = req.getParameter("detailCode");
		String picCode = req.getParameter("picCode");
		Range range = IoUtil.parseRange(req);
		
		OutputStream out = null;
		InputStream content = null;
		final PrintWriter writer = resp.getWriter();
		
		/** TODO: validate your token. */
		
		JSONObject json = new JSONObject();
		long start = 0;
		boolean success = true;
		String myfilename = "";
		String message = "";
		File f = null;
		try {
			f = IoUtil.getTokenedFile(token);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (f.length() != range.getFrom()) {
				/** drop this uploaded data */
				System.out.println("111");
				throw new StreamException(StreamException.ERROR_FILE_RANGE_START);
			}
			
			out = new FileOutputStream(f, true);
			content = req.getInputStream();
			int read = 0;
			final byte[] bytes = new byte[BUFFER_LENGTH];
			while ((read = content.read(bytes)) != -1)
				out.write(bytes, 0, read);

			start = f.length();
		} catch (StreamException se) {
			success = StreamException.ERROR_FILE_RANGE_START == se.getCode();
			message = se.getCode()+"";
		} catch (FileNotFoundException fne) {
			message =StreamException.ERROR_FILE_NOT_EXIST+"";
			success = false;
		} catch (IOException io) {
			message = "IO Error: " + io.getMessage();
			success = false;
		} finally {
			IoUtil.close(out);
			IoUtil.close(content);

			/** rename the file */
			System.out.println("range.getSize()="+range.getSize()+"---------------start="+start);
			System.out.println("fileName="+fileName);
			System.out.println("TK: `" + token + "`, NE: `" + fileName + "`");
			if (f.length() == Integer.parseInt(token.split("_")[1])) {
				/** fix the `renameTo` bug */
//				File dst = IoUtil.getFile(fileName);
//				dst.delete();
//				f.renameTo(dst);
				System.out.println("TK: `" + token + "`, NE: `" + fileName + "`");
				/** if `STREAM_DELETE_FINISH`, then delete it. */
//				if (Configurations.isDeleteFinished()) {
//					dst.delete();
//				}
				
				String inputFile ="";
				String outFile ="";
				try {
					inputFile = Configurations.getFileRepository() + token;
					outFile=Configurations.getFileRepository().replace("temp/", "");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(StringUtil.isNotEmpty(mainCode)){
					outFile+=mainCode+"/";
				}
				if(StringUtil.isNotEmpty(detailCode)){
					outFile+=detailCode+"/";
				}
				if(StringUtil.isNotEmpty(picCode)){
					outFile+=picCode+"/";
				}
				if(filemap.containsKey(token)){
					myfilename=filemap.get(token);
				}
				FileUtils.copyFileToFolderAndChangeName(inputFile,outFile,myfilename);

				//add begin by liuhui 2017-08-02 如果是图片则生成缩略图
			}
			try {
				if (success)
					json.put(START_FIELD, start);
				json.put(TokenServlet.SUCCESS, success);
				json.put(TokenServlet.FILE_NAME, myfilename);
				json.put(TokenServlet.MESSAGE, message);
			} catch (JSONException e) {}
			
			writer.write(json.toString());
			IoUtil.close(writer);
		}
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Range,Content-Type");
		resp.setHeader("Access-Control-Allow-Origin", Configurations.getCrossOrigins());
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
