package org.jeecgframework.web.zkyen.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonMethod {

	
	/**
	 * Gson 转化数据 并抛给页面
	 * 
	 * */
	public static void gson2Jsp(HttpServletResponse response,Object obj) {
		
		//转换数据类型
        GsonBuilder gbuilder = new GsonBuilder();
        // 去除对html格式的转化
     	Gson gson = gbuilder.disableHtmlEscaping().create();
		String jsonStr = gson.toJson(obj); 
		//处理乱码问题
		response.setContentType("application/json; charset=utf-8");
		try {
			response.getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static String convertNum2String(int i) {
		String obj = "";
		switch (i) {
		case 1:
			obj = "友情链接";
			break;
		case 2:
			obj = "政府机构";
			break;
		case 3:
			obj = "合作伙伴";
			break;
		case 4:
			obj = "社会团体";
			break;
		default:
			break;
		}
		return obj;
	}
	
	/**
	 * List不为空判断
	 * */
	public static boolean isNotNullList(List list){
		if(list!=null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 字符串不为空判断
	 * */
	public static boolean isNotNullString(Object obj){
		if(obj!=null && !"".equals(obj)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 日期格式转化,传入日期date，pattern 传入格式化形式
	 * */
	public static String dateFormat(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 根据菜单名字，调出对应页面
	 * */
	public static String getJspByMenu(int menu){
		String jsp = "";
		if(menu==0){
			jsp = "/about/index.jsp";
		}else if(menu==1){
			jsp = "/news/index.jsp";
		}else if(menu==2){
			jsp = "/tecResearch/index.jsp";
		}else if(menu==3){
			jsp = "/proServices/index.jsp";
		}else if(menu==4){
			jsp = "/socialRes/index.jsp";
		}else if(menu==5){
			jsp = "/joinus/index.jsp";
		}
		return jsp;
	}
	
	public static void main(String args[]) {
		
		String url = "";
		
		System.out.println(dateFormat(new Date(), "yyyy.MM.dd"));
	
	}
	
	/**
	 * 根据参数取出对应Html后缀文件
	 * */
	public static String getHtmlByMenu(String absUrl,int menu1,int menu2,int menu3){
		String suffixHtml = "";
		if(menu1==-1){
			return absUrl+"/index.jsp";
		}
		if(menu1==1){
			if(menu2==0){
				switch (menu3) {
				case -1:
					suffixHtml = "group_profile.html";
					break;
				case 0:
					suffixHtml = "introduction.html";
					break;
				case 1:
					suffixHtml = "development.html";
					break;
				case 2:
					suffixHtml = "culture.html";
					break;
				case 3:
					suffixHtml = "structure.html";
					break;
				case 4:
					suffixHtml = "position.html";
					break;
				case 5:
					suffixHtml = "technology.html";
					break;
				case 6:
					suffixHtml = "management.html";
					break;
				default:
					break;
				}
			}else if(menu2==1){
				switch (menu3) {
				case -1:
					suffixHtml = "child_company.html";
					break;
				case 0:
					suffixHtml = "child_first.html";
					break;
				case 1:
					suffixHtml = "child_second.html";
					break;
				case 2:
					suffixHtml = "child_three.html";
					break;
				default:
					break;
				}
			}
		}else if(menu1==2){
			if(menu2==0){
				suffixHtml = "news.html";
			}else if(menu2==1){
				suffixHtml = "industry.html";
			}else if(menu2==2){
				switch (menu3) {
				case -1:
					suffixHtml = "publications.html";
					break;
				case 0:
					suffixHtml = "composite_post.html";
					break;
				case 1:
					suffixHtml = "kerosene.html";
					break;
				case 2:
					suffixHtml = "cogasin.html";
					break;
				default:
					break;
				}
			}
		}else if(menu1==3){
			if(menu2==0){
				switch (menu3) {
				case -1:
					suffixHtml = "technical_study.html";
					break;
				case 0:
					suffixHtml = "water.html";
					break;
				case 1:
					suffixHtml = "oil_processing.html";
					break;
				case 2:
					suffixHtml = "analysis.html";
					break;
				case 3:
					suffixHtml = "integration.html";
					break;
				case 4:
					suffixHtml = "delicacy.html";
					break;
				case 5:
					suffixHtml = "extension.html";
					break;
				case 6:
					suffixHtml = "gas.html";
					break;
				default:
					break;
				}
			}else if(menu2==1){
				suffixHtml = "article.html";
			}else if(menu2==2){
				suffixHtml = "opzkyenclass.html";
			}
		}else if(menu1==4){
			if(menu2==0){
				switch (menu3) {
				case -1:
					suffixHtml = "catalyzer.html";
					break;
				case 0:
					suffixHtml = "product.html";
					break;
				case 1:
					suffixHtml = "superiority.html";
					break;
				default:
					break;
				}
			}else if(menu2==1){
				suffixHtml = "project_service.html";
			}else if(menu2==2){
				suffixHtml = "technical_service.html";
			}else if(menu2==3){
				switch (menu3) {
				case -1:
					suffixHtml = "build.html";
					break;
				case 0:
					suffixHtml = "luan_project.html";
					break;
				case 1:
					suffixHtml = "yitai_project.html";
					break;
				case 2:
					suffixHtml = "shenhua_project.html";
					break;
				case 3:
					suffixHtml = "delicacy_project.html";
					break;
				case 4:
					suffixHtml = "luan_integration.html";
					break;
				case 5:
					suffixHtml = "shenhua_ningmei.html";
					break;
				default:
					break;
				}
			}
		}else if(menu1==5){
			if(menu2==0){
				suffixHtml = "sustained_development.html";
			}else if(menu2==1){
				suffixHtml = "society.html";
			}else if(menu2==2){
				if(menu3==-1){
					suffixHtml = "employee_build.html";
				}else if(menu3==0){
					suffixHtml = "employee_learn.html";
				}
			}
		}else if(menu1==6){
			if(menu2==0){
				suffixHtml = "alent_recruitment.html";
			}else if(menu2==1){
				suffixHtml = "jobs.html";
			}else if(menu2==2){
				suffixHtml = "cooperation.html";
			}else if(menu2==3){
				suffixHtml = "contact_us.html";
			}
		}
		return absUrl+"/"+suffixHtml;
	}
	
	
	/**
	 * null转空
	 * 
	 * */
	public static String getStrByObj(Object obj){
		String str="";
		if(obj==null || "".equals(obj)){
		}else{
			str = (String) obj;
		}
		return str;
	}
	
	/**
	 *获取文件大小和类型 
	 * */
	@SuppressWarnings("resource")
	public static Map<String,Object> getFile(String url){
		Map<String,Object> map = new HashMap<String,Object>();
		String msg = "";
		FileChannel fc= null;  
	    try {  
	        URL urlTmp = new URL(url);
			//根据响应获取文件大小 
			HttpURLConnection urlcon=(HttpURLConnection)urlTmp.openConnection(); 
			urlcon.getContentLength();
			//获取相应的文件长度
			int fsize = urlcon.getContentLength();
			map.put("fileSize", fsize);
			map.put("fileType",urlcon.getContentType());
//	        if (f.exists() && f.isFile()){  
//	            FileInputStream fis= new FileInputStream(f);  
//	            fc= fis.getChannel();  
////	            logger.info(fc.size()); 
//	            map.put("fileSize", fsize/1024/1024);
//	            
//	            String fileType = url.substring(url.lastIndexOf("."));
//	            map.put("fileType",fileType.toUpperCase());
//	            
//	        }else{  
//	        	msg = "file doesn't exist or is not a file";
////	            logger.info("file doesn't exist or is not a file");  
//	        }  
	    } catch (FileNotFoundException e) {  
//	        logger.error(e);  
	        msg = e.toString();
	    } catch (IOException e) {  
//	        logger.error(e);
	        msg = e.toString();
	    } finally {  
	        if (null!=fc){  
	            try{  
	                fc.close();  
	            }catch(IOException e){  
//	                logger.error(e); 
	                msg = e.toString();
	            }  
	        }   
	    }  
		if(!"".equals(msg)){//有错误则返回null
			return null;
		}
		return map;
	}
	
	
}
