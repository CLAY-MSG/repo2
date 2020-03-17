package com.xgk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xgk.domain.Role;
import com.xgk.domain.User;
import com.xgk.service.RoleService;
import com.xgk.service.UserService;
import com.xgk.utils.Page;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	
	//登录页面
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
//	@RequestMapping("/index")
//	public String index(Model model) {
//		model.addAttribute("rolelist", roleService.getRoleList());
//		model.addAttribute("userlist", userService.getUserList());
//		return "index";
//	}
	
	
	
//	@RequestMapping("/doLogin")
//	public String doLogin(User user,Model model,HttpServletRequest request,HttpSession session) {
////		System.out.println(model);//Model会自动添加user
//		if("admin".equals(user.getUserCode()) && "123456".equals(user.getUserPassword())) {
////			request.setAttribute("uc1", user.getUserCode());//url跳转，无法接受
//			session.setAttribute("uc2",user.getUserCode());//url跳转，可以接受
//			return "redirect:/user/index";//是一个url,客户端跳转
////			return "index";//服务端跳转
//		}else {
////			request.setAttribute("info", "用户名或密码错误");
////			return "jsp/login";//其实是一个jsp页面
//			throw new RuntimeException("用户名或密码错误");//
//		}
//	}
	
//	@ExceptionHandler(value=(RuntimeException.class))
//	public String handlerException(RuntimeException e,HttpServletRequest req) {
//		req.setAttribute("e", e);//e.message异常内容
//		return "jsp/login";
//	}
	
	@RequestMapping("/doLogin")
	public String doLogin(User user, Model model, HttpServletRequest request, HttpSession session) {
		User u = userService.login(user);
		if(u!=null) {
			session.setAttribute("user",user);//如果url跳转可以接受
			return "redirect:/user/userlist";//是一个url,客户端跳转
		}else {
			throw new RuntimeException("用户名或密码错误");//
		}
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList",roleList);
		return "addUser";
	}
	
	//单文件上传
//	@RequestMapping("/doAddUser")
//	public String doAddUser(User user,HttpServletRequest request,MultipartFile pic) {
//		String picPath = null;
//		//判断文件是否为空
//		if(!pic.isEmpty()){
//			//定义目标路径
//			String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); 
//			//获取原文件后缀     
//			String prefix=FilenameUtils.getExtension(pic.getOriginalFilename());
//		        if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
//	            		|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){
//		        	//定义上传后的文件名
//	            		String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";  
//	                	File targetFile = new File(path, fileName);  
//	                	if(!targetFile.exists()){  
//	                		targetFile.mkdirs();  
//	                	}  
//	                	//上传文件
//	                	try {  
//	                		pic.transferTo(targetFile);  
//	                	} catch (Exception e) {  
//	                    		e.printStackTrace();  
//	                    		request.setAttribute("uploadFileError", " * 上传失败！");
//	                    		return "addUser";
//	                	} 
//	                	picPath = fileName;
//	            	}else{
//	            		request.setAttribute("uploadFileError", " * 上传图片格式不正确");
//	            		return "addUser";
//	            	}
//		}
//		//保存数据
//		user.setIdPic(picPath);
//        if(userService.addUser(user)==1){
//			return "redirect:/user/userlist";
//		}else{
//			return "addUser";
//		}
//		
//	}
	
	//多文件上传
		@RequestMapping(value="/doAddUser",method=RequestMethod.POST)
		public String doAddUser(User user,HttpServletRequest request,@RequestParam(value="attachs",required=false) MultipartFile[] attachs){
			String idPicPath = null;
			String workPicPath = null;
			String errorInfo = null;
			boolean flag = true;
			String path = "e:\\uploadfiles";//request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); 
			for(int i = 0;i < attachs.length ;i++){
				MultipartFile attach = attachs[i];
				if(!attach.isEmpty()){
					if(i == 0){
						errorInfo = "uploadFileError";
					}else if(i == 1){
						errorInfo = "uploadWpError";
		        	}
					String oldFileName = attach.getOriginalFilename();//原文件名
					String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
					if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
		            		|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式不正确
		            	String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";  
		                File targetFile = new File(path, fileName);  
		                if(!targetFile.exists()){  
		                    targetFile.mkdirs();  
		                }  
		                //上传文件
		                try {  
		                	attach.transferTo(targetFile);  
		                } catch (Exception e) {  
		                    e.printStackTrace();  
		                    request.setAttribute(errorInfo, " * 上传失败！");
		                    flag = false;
		                }  
		                if(i == 0){
		                	 idPicPath = fileName;
		                }else if(i == 1){
		                	 workPicPath = fileName;
		                }
		                
		            }else{
		            	request.setAttribute(errorInfo, " * 上传图片格式不正确");
		            	flag = false;
		            }
				}
			}
			if(flag){
				user.setIdPic(idPicPath);
				user.setWorkPic(workPicPath);
				if(userService.addUser(user)==1){
					return "redirect:/user/userlist";
				}
			}
			return "addUser";
		}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		if(userService.deleteUser(id)==1) {
			return "redirect:/user/userlist";
		}else {
			return "index";
		}
	}
	
	@RequestMapping("/showUser/{id}")
	public String showUser(Model model,@PathVariable Integer id) {
		model.addAttribute("user",userService.getUserById(id));
		return "showUser";
	}
	
	@ResponseBody
//	@RequestMapping(value="/showUserJson/{id}",produces= {"application/json;charset=UTF-8"})
	@RequestMapping("/showUserJson/{id}")
	public Object showUserJson(@PathVariable Integer id) {
		User user = userService.getUserById(id);
//		return JSONArray.toJSONString(user);
		return JSON.toJSONString(user,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@ResponseBody
	@RequestMapping(value="/checkUserCode/{userCode}")
	public Object checkUserCode(@PathVariable String userCode) {
		Map<String,String> resultMap = new HashMap<String,String>();
		User user = userService.checkUserCode(userCode);
		if(user==null) {
			resultMap.put("result", "notexist");
		}else {
			resultMap.put("result","exist");
		}
		return JSONArray.toJSONString(resultMap);
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(Model model,Integer id) {
		model.addAttribute("user",userService.getUserById(id));
		model.addAttribute("rolelist",roleService.getRoleList());
		return "updateUser";
	}
	
	@RequestMapping("/doUpdateUser")
	public String doUpdateUser(@Valid User user,BindingResult br) {
		if(br.hasErrors()) {
			return "updateUser";
		}
		if(userService.updateUser(user)==1) {
			return "redirect:/user/userlist";
		}else {
			return "updateUser";
		}
	}
	
	@RequestMapping("/userlist")
	public String index(Model model,User queryUser,Integer pageIndex,Integer pageSize,HttpSession session) {
		if(pageIndex==null) {//全部数据的情况
			pageIndex=1;
		}else {
			queryUser = (User) session.getAttribute("queryUser");
		}
		if(pageSize==null) {
			pageSize=5;
		}
		Page page = new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setTotalCount(userService.getUserByQuery(queryUser));
		model.addAttribute("page",page);
		model.addAttribute("rolelist", roleService.getRoleList());
		model.addAttribute("userlist", userService.getUserListBy1(queryUser,(pageIndex-1)*pageSize,pageSize));
		session.setAttribute("queryUser",queryUser);
		return "index";
	}
}
