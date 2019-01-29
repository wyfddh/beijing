package com.tj720.mip.controller.back;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tj720.mip.springbeans.Config;

@Controller
@RequestMapping("/back/upload")
public class UploadFileController extends HttpServlet{
	@Autowired
	private Config config;
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadFile.do")
	@ResponseBody
    public String fileUpload(@RequestParam("file") CommonsMultipartFile partFile, HttpServletRequest request, String rootPath) throws IOException {
		 if(partFile!=null&&partFile.getOriginalFilename()!=null&&partFile.getOriginalFilename().length()>0){ 
			   rootPath = request.getContextPath();//测试用 
		       Calendar cal = Calendar.getInstance();  
		       int month = cal.get(Calendar.MONTH) + 1;  
		       int year = cal.get(Calendar.YEAR);  
		       String filePath=rootPath+year+month+"/";  
		       File dir=new File(filePath);  
		        if(!dir.isDirectory())  
		            dir.mkdir();  
		         
		       String fileOriginalName=partFile.getOriginalFilename();  
		       String newFileName=UUID.randomUUID()+fileOriginalName.substring(fileOriginalName.lastIndexOf("."));  
		       File file=new File(filePath+newFileName);  
		       //文件写入磁盘  
		       partFile.transferTo(file);  
		       //返回存储的相对路径+文件名称  
		       return ""+year+month+"/"+newFileName;
		   }  
		   else  
		       return null;  
		  }  
		/*try {
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			String filePath = rootPath + year + month + "/";
			File dir = new File(filePath);
			if (!dir.isDirectory())
				dir.mkdir();
			
			long  startTime=System.currentTimeMillis();
			System.out.println("fileName："+file.getOriginalFilename());
        
			//从配置文件获取上传根路径
        
			//组合上传文件存放路径
			String path= uploadPath + targetName;
         
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        
        //返回数据库要存入的文件的名字
        return targetName; 
        
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
    }*/
	
	
	
	
	
	
	
	
	
	
	
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(savePath);
        if(!file.exists()&&!file.isDirectory()){
            System.out.println("目录或文件不存在！");
            file.mkdir();
        }
        //消息提示
        String message = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            //解决上传文件名的中文乱码
            fileUpload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!fileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = fileUpload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    String value1 = new String(name.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name+"  "+value);
                    System.out.println(name+"  "+value1);
                }else{
                    //如果fileitem中封装的是上传文件，得到上传的文件名称，
                    String fileName = item.getName();
                    System.out.println(fileName);
                    if(fileName==null||fileName.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
                    //获取item中的上传文件的输入流
                    InputStream is = item.getInputStream();
                    
                    //得到文件保存的名称
                    fileName = mkFileName(fileName);
                    //得到文件保存的路径
                    String savePathStr = mkFilePath(savePath, fileName);
                    System.out.println("保存路径为:"+savePathStr);
                    
                    
                    //创建一个文件输出流
                    FileOutputStream fos = new FileOutputStream(savePath+File.separator+fileName);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((length = is.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        fos.write(buffer, 0, length);
                    }
                    //关闭输入流
                    is.close();
                    //关闭输出流
                    fos.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message = "文件上传成功";
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            message = "文件上传失败";
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }*/
	
    //生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
    public String mkFileName(String fileName){
        return UUID.randomUUID().toString()+"_"+fileName;
    }
    public String mkFilePath(String savePath,String fileName){
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = fileName.hashCode();
        int dir1 = hashcode&0xf;
        int dir2 = (hashcode&0xf0)>>4;
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
}
    


