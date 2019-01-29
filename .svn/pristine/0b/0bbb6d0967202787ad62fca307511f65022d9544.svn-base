package com.design.main.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.design.core.common.model.json.AjaxJson;
import com.design.utils.ParameterUtil;
import com.design.utils.ResourceUtil;
import com.design.utils.oConvertUtils;
import com.google.gson.Gson;
import com.zxlhdata.framework.auth.model.LicenseInfo;
import com.zxlhdata.framework.auth.util.LicenseUtil;


/**
 * 授权码
 * @author 辉
 *
 */
@Controller
@RequestMapping("/authController")
public class AuthController {
	private String prefix= ResourceUtil.getConfigByName("viewResolver.prefix");
	private String suffix= ResourceUtil.getConfigByName("viewResolver.suffix");
	private Logger log = Logger.getLogger(AuthController.class);

	/**
	 * 授权信息页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "authInfo")
	public ModelAndView authInfo(Model model) throws Exception {
		try {
			boolean isLocalAuth =  LicenseUtil.isLocalAuth(ParameterUtil.ATC_K,
					new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1);
			model.addAttribute("isLocalAuth", isLocalAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LicenseInfo licenseInfo = null;
		try {
			licenseInfo = LicenseUtil.getRegisterInfo(ParameterUtil.ATC_K,98);
		} catch (Exception e) {
			licenseInfo = new LicenseInfo();
			licenseInfo.setRESCODE("0019");
			licenseInfo.setMEMO("未授权");
		}		
		
		//log.info("注册信息 licenseInfo:"+gson.toJson(licenseInfo));
		if(licenseInfo==null){
			licenseInfo = new LicenseInfo();
			licenseInfo.setRESCODE("0019");
			licenseInfo.setMEMO("未授权");
		}
		model.addAttribute("licenseInfo", licenseInfo);
	    String registerCode = LicenseUtil.getRegisterCode(ParameterUtil.ATC_K);
	   // String registerModuleCode = LicenseUtil.getRegisterModuleCode(ParameterUtil.ATC_K);
	    
		model.addAttribute("registerCode", registerCode);
	  //model.addAttribute("registerModuleCode", registerModuleCode);
		
		return new ModelAndView(prefix+"auth/authInfo"+suffix);
	}


	/**
	 * 注册页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "register")
	public ModelAndView register(Model model,HttpServletRequest request) {
		try {
			boolean isLocalAuth =  LicenseUtil.isLocalAuth(ParameterUtil.ATC_K,
					new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1);
			model.addAttribute("isLocalAuth", isLocalAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag= oConvertUtils.getString(request.getParameter("flag"));
		String registerCode = LicenseUtil.getRegisterCode(ParameterUtil.ATC_K);
		//String registerModuleCode = LicenseUtil.getRegisterModuleCode(ParameterUtil.ATC_K);
		model.addAttribute("registerCode", registerCode);
		model.addAttribute("flag", flag);
		//model.addAttribute("registerModuleCode", registerModuleCode);
		
		return new ModelAndView(prefix+"auth/authRegister"+suffix);
	}

	
	/**
	 * 注册验证
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(params = "authorization")
	public ModelAndView authorization(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam("licenseFile") MultipartFile licenseFile/*,
			@RequestParam("moduleLicenseFile") MultipartFile moduleLicenseFile*/) {

		AjaxJson j = new AjaxJson();
		try {
			boolean isLocalAuth =  LicenseUtil.isLocalAuth(ParameterUtil.ATC_K,
					new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1);
			req.setAttribute("isLocalAuth", isLocalAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String registerCode = LicenseUtil.getRegisterCode(ParameterUtil.ATC_K);
		req.setAttribute("registerCode", registerCode);

		loadLicense(licenseFile, /*moduleLicenseFile,*/ j);
		return new ModelAndView(prefix+"auth/authRegister"+suffix).addObject("result", j);
	}


	private void loadLicense(MultipartFile licenseFile,/* MultipartFile moduleLicenseFile,*/ AjaxJson j) {
		// 授权码
		String licenseCode = null;
		String moduleCode = null;

		if (licenseFile != null) {
			System.out.println(licenseFile.getName());
			InputStream is = null;
			BufferedReader reader = null;
			StringBuilder sb = null;
			try {
				is = licenseFile.getInputStream();
				reader = new BufferedReader(new InputStreamReader(licenseFile.getInputStream()));
				sb = new StringBuilder();

				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				// System.out.println("sb："+sb.toString());
				licenseCode = sb.toString();
				moduleCode = licenseCode;
				
				//如果用的平台的授权
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * if(!(licenseCode!=null && !"".equals(licenseCode))){ licenseCode =
		 * req.getParameter("licenseCode"); }
		 * System.out.println("licenseCode:"+licenseCode);
		 */
		try {
			if (licenseCode != null && !"".equals(licenseCode)) {
				log.info("注册 licenseCode:" + licenseCode);
				int randomCode = new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1;

				LicenseInfo licenseInfo = LicenseUtil.getRegisterInfo(licenseCode,moduleCode,ParameterUtil.ATC_K, randomCode);
				Gson gson = new Gson();
				log.info("注册信息 licenseInfo:" + gson.toJson(licenseInfo));
				if (licenseInfo != null) {

					String rescode = licenseInfo.getRESCODE();
					if ("0017".equals(rescode)) { // 0017：软件已授权

						// 将授权码存储到磁盘 ----------------------start---------------
						String licenseFileName = ResourceUtil.getSysPath() + "WEB-INF/classes/" + ParameterUtil.SYS_LIC_NAME;
						
						FileOutputStream fos = null;
						PrintWriter pw = null;
						FileOutputStream moduleFos = null;
						PrintWriter modulePW = null;
						
						try {
							System.out.println("the file is " + licenseFileName);
							File file = new File(licenseFileName);
							// 如果文件不存在，则创建新的文件
							if (!file.exists()) {
								file.createNewFile();
							}

							// 创建文件成功后，写入内容到文件里
							StringBuffer buffer = new StringBuffer();
							buffer.append(licenseCode);

							fos = new FileOutputStream(file);
							pw = new PrintWriter(fos);
							pw.write(buffer.toString().toCharArray());
							pw.flush();

						} catch (Exception e) {
							e.printStackTrace();
							j.setSuccess(false);
							j.setMsg("注册失败");
						} finally {
							// 不要忘记关闭
							if (pw != null) {
								pw.close();
							}
							if (fos != null) {
								fos.close();
							}
							
							// 不要忘记关闭
							if (modulePW != null) {
								modulePW.close();
							}
							if (moduleFos != null) {
								moduleFos.close();
							}
						}
						// 将授权码存储到磁盘 ----------------------end---------------
						
						LicenseUtil.loadLicenseInfo(licenseFileName, "",ParameterUtil.ATC_K,randomCode);

						j.setSuccess(true);
						j.setMsg("注册成功");
				/*	} else if (rescode.equals("0018")) {// 软件已经授权，但过期！
						j.setSuccess(false);
						j.setMsg("授权已过期");
					} else if (rescode.equals("0019")) {// 软件未授权！
						j.setSuccess(false);
						j.setMsg("软件未授权");

					} else if (rescode.equals("0002")) {// 参数错误
						j.setSuccess(false);
						j.setMsg("授权参数错误");*/

					} else {
						// 程序出现异常，异常处理程序。。。
						j.setSuccess(false);
						j.setMsg(licenseInfo.getMEMO());
						//j.setMsg("授权异常");
					}
				}
			} else {
				j.setSuccess(false);
				j.setMsg("注册失败，授权码为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("注册失败");
		}
	}
	

	/**
	 * 登录之前授权信息成功页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "seeAuthInfo")
	public ModelAndView seeAuthInfo(Model model) throws Exception {
		try {
			boolean isLocalAuth =  LicenseUtil.isLocalAuth(ParameterUtil.ATC_K,
					new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1);
			model.addAttribute("isLocalAuth", isLocalAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LicenseInfo licenseInfo = null;
		try {
			licenseInfo = LicenseUtil.getRegisterInfo(ParameterUtil.ATC_K,98);
		} catch (Exception e) {
			licenseInfo = new LicenseInfo();
			licenseInfo.setRESCODE("0019");
			licenseInfo.setMEMO("未授权");
		}		
		
		//log.info("注册信息 licenseInfo:"+gson.toJson(licenseInfo));
		if(licenseInfo==null){
			licenseInfo = new LicenseInfo();
			licenseInfo.setRESCODE("0019");
			licenseInfo.setMEMO("未授权");
		}
		model.addAttribute("licenseInfo", licenseInfo);
	    String registerCode = LicenseUtil.getRegisterCode(ParameterUtil.ATC_K);
		model.addAttribute("registerCode", registerCode);
		
		return new ModelAndView(prefix+"auth/authInfoCheck"+suffix);
	}
	
	/**
	 * 登录之前跳转到授权验证界面
	 * 
	 * @return
	 */
	@RequestMapping(params = "registerBLogin")
	public ModelAndView registerBLogin(Model model,HttpServletRequest req, HttpServletResponse resp) {
		try {
			boolean isLocalAuth =  LicenseUtil.isLocalAuth(ParameterUtil.ATC_K,
					new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1);
			req.setAttribute("isLocalAuth", isLocalAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String registerCode = LicenseUtil.getRegisterCode(ParameterUtil.ATC_K);
		//String registerModuleCode = LicenseUtil.getRegisterModuleCode(ParameterUtil.ATC_K);
		model.addAttribute("registerCode", registerCode);
		//model.addAttribute("registerModuleCode", registerModuleCode);
		try{
			//查询是否授权(是否过期)
			String licenseCode = LicenseUtil.getLicenseCode(new java.util.Random(System.currentTimeMillis()).nextInt(100) +1);
			//String moduleCode = LicenseUtil.getModuleCode(new java.util.Random(System.currentTimeMillis()).nextInt(100) +1);
			log.info("授权码 licenseCode:"+licenseCode);
		
			if(licenseCode!=null && !"".equals(licenseCode)){
			
				int randomCode = new java.util.Random(System.currentTimeMillis()).nextInt(100) +1;
				
				LicenseInfo licenseInfo = LicenseUtil.getRI(ParameterUtil.ATC_K,randomCode);
				Gson gson = new Gson();
				log.info("注册信息 licenseInfo:"+gson.toJson(licenseInfo));
				if(licenseInfo!=null ){
					String rescode = licenseInfo.getRESCODE();
					if("0017".equals(rescode)){ //0017：软件已授权
	
					}else if(rescode.equals("0018")){//软件已经授权，但过期！
						
					}else if(rescode.equals("0019")){//软件未授权！
						
					}else if(rescode.equals("0020")){//未经许可的开始使用日期
						
					}else if(rescode.equals("0002")){//参数错误
						
					}else if(rescode.equals("0001")){//程序异常
						
					}else{
						//程序出现异常，异常处理程序。。。
					}
	
					req.setAttribute("rescode", rescode+"");
					req.setAttribute("oldLicenseInfo", licenseInfo);
				}
			
			}
		}catch (Exception e){
			e.printStackTrace();
			req.setAttribute("rescode", "0001");
		}
		
		//return new ModelAndView("system/auth/authRegister");
		return new ModelAndView(prefix+"auth/registCheck"+suffix);
	}
	
	
	/**
	 * 登录之前的注册验证方法
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(params = "authorizationBLogin")
	public ModelAndView authorizationBLogin(HttpServletRequest req, HttpServletResponse resp, 
			@RequestParam("licenseFile") MultipartFile licenseFile/*, 
			@RequestParam("moduleLicenseFile") MultipartFile moduleLicenseFile*/){
		
		AjaxJson j = new AjaxJson();
		try {
			boolean isLocalAuth =  LicenseUtil.isLocalAuth(ParameterUtil.ATC_K,
					new java.util.Random(System.currentTimeMillis()).nextInt(100) + 1);
			req.setAttribute("isLocalAuth", isLocalAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		loadLicense(licenseFile, /*moduleLicenseFile,*/ j);
		
		String registerCode = LicenseUtil.getRegisterCode(ParameterUtil.ATC_K);
		//String registerModuleCode = LicenseUtil.getRegisterModuleCode(ParameterUtil.ATC_K);
		
		req.setAttribute("registerCode", registerCode);
		//req.setAttribute("registerModuleCode", registerModuleCode);
		
		return new ModelAndView(prefix+"auth/registCheck"+suffix).addObject("result", j);
	}
	
	/**
	 * 授权打印页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "authPdf")
	public ModelAndView authPdf(Model model) {
		
		
		return new ModelAndView(prefix+"auth/authPdf"+suffix);
	}


//	/**
//	 * 授权打印页面跳转
//	 * 
//	 * @return
//	 * @throws IOException 
//	 * @throws DocumentException 
//	 */
//	@RequestMapping(params = "topdf")
//	public ModelAndView topdf(Model model,HttpServletRequest request, HttpServletResponse response) 
//			throws IOException, DocumentException {
//		StringBuffer url = request.getRequestURL();
//		System.out.println(url.toString());
//		
//		//中文需转义     
//        String pdfName = "pdfName";     
//             
//        response.setHeader("Content-disposition", "attachment;filename="+pdfName);     
//        response.setContentType("application/pdf");     
//        OutputStream os = response.getOutputStream();     
//        ITextRenderer renderer = new ITextRenderer();     
//        //指定模板地址                 
//        renderer.setDocument(url.toString()+"?authPdf");     
//             
//        ITextFontResolver fontResolver = renderer.getFontResolver();     
//        fontResolver.addFont("C:/Windows/Fonts/ARIALUNI.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);   
//        
//        renderer.layout();     
//        renderer.createPDF(os);     
//        os.close();   
//		
//		return null;
//	}

}
