package com.tj720.mip.controller.desk;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.design.core.common.hibernate.qbc.CriteriaQuery;
import com.design.core.common.model.json.SortDirection;
import com.design.core.system.service.SystemService;
import com.design.entity.CgformBussEntity;
import com.design.entity.CgformBussListEntity;
import com.design.entity.CgformDefineEntity;
import com.github.pagehelper.StringUtil;
import com.tj720.admin.dto.InsideInfoDto;
import com.tj720.admin.dto.MuseumVisitorDto;
import com.tj720.admin.dto.MuseumVisitorMonth;
import com.tj720.admin.dto.ReceiveNoticeDto;
import com.tj720.admin.model.GovLegal;
import com.tj720.admin.model.GovNotice;
import com.tj720.admin.service.GovLegalService;
import com.tj720.admin.service.GovNoticeService;
import com.tj720.admin.service.IInsideInfoService;
import com.tj720.admin.service.IMuseumVisitorService;
import com.tj720.admin.service.ReceiveNoticeService;
import com.tj720.mip.controller.BaseController;
import com.tj720.mip.dto.LoginInfoDto;
import com.tj720.mip.dto.TodayDynamic;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.framework.auth.AuthPassport;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.DateStyle;
import com.tj720.mip.utils.DateUtil;
import com.tj720.mip.utils.Page;
import com.tj720.mip.utils.Tools;

@Controller
@RequestMapping("/desk")
public class WorkDeskController extends BaseController {

	@Autowired
	private Config config;
	@Autowired
	private IUserService userService;
	@Autowired
	private IInsideInfoService insideInfoService;
	@Autowired
	private GovNoticeService govNoticeService;
	@Autowired
	private ReceiveNoticeService receiveNoticeService;
	@Autowired
	private MipOrganizationService organizationService;
	@Autowired 
	private GovLegalService govLegalService;
	
	@Autowired 
	private IMuseumVisitorService visitorService;
	@Autowired
	private SystemService systemService;
	
	/**
	 * 工作台.do
	 * @return
	 */
	@RequestMapping("/workDeskInfo.do")
	@AuthPassport
	public String registerInfo(){
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		MipOrganization mipOrganization = organizationService.get(orgId);
		String orgTypeId = mipOrganization.getOrgTypeId();
		if("1".equals(orgTypeId) || "2".equals(orgTypeId)){
			return "redirect:/desk/bureauDeskInfo.do";
		}else{
			return "redirect:/desk/museumDeskInfo.do";
		}
	}
	
	/**
	 * 博物馆工作台展示页
	 * @return
	 */
	@RequestMapping("/museumDeskInfo.do")
	@ResponseBody
	public ModelAndView museumDeskInfo() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/desk/museumDesk.jsp");
		
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		
		//通知公告板块，显示最新接收的最多四条数据
		List<ReceiveNoticeDto> receiveList = receiveNoticeService.getNoticeForMuseumDesk(orgId);
		modelAndView.addObject("receiveList", receiveList);
		
		//法律法规板块，显示最新接收的最多八条数据
		List<GovLegal> govLegalList = govLegalService.getGovListForDesk(null);
		modelAndView.addObject("govLegalList", govLegalList);
		
		//查询年度下拉：当前年份和过去已经录入数据的年份
		Calendar nowTime = Calendar.getInstance();  
		int nowYear = nowTime.get(Calendar.YEAR);
		int nowMonth = nowTime.get(Calendar.MONTH)+1;
		int nowDay = nowTime.get(Calendar.DAY_OF_MONTH);
		
		List<Map<String, Integer>> yearList = visitorService.getYearList(orgId);
		Boolean hasNowYear = false;
		for(Map<String,Integer> yearMap:yearList){
			if(yearMap.get("year") == nowYear){
				hasNowYear = true;
				break;
			}
		}
		if(!hasNowYear){
			Map<String,Integer> yMap = new HashMap<String, Integer>(); 
			yMap.put("year", nowYear);
			yearList.add(0, yMap);
		}
		modelAndView.addObject("yearList", yearList);
		modelAndView.addObject("nowYear", nowYear);
		
		//月份下拉
		List<Map<String, Integer>> monthList = new ArrayList<Map<String,Integer>>();
		for(int i=1;i<13;i++){
			Map<String, Integer> mMap = new HashMap<String, Integer>();
			mMap.put("month", i);
			monthList.add(mMap);
		}
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("nowMonth", nowMonth);
		modelAndView.addObject("orgId", orgId);
		
		//查询业务管理表单code
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("collection", config.getBusinessCollection());//藏品
		codeMap.put("exhibition", config.getBusinessExhibition());//展览
		codeMap.put("study", config.getBusinessStudy());//研究
		codeMap.put("education", config.getBusinessEducation());//教育
		codeMap.put("wenchuang", config.getBusinessWenchuang());//文创
		modelAndView.addObject("codeMap", codeMap);
		return modelAndView;
	}
	
	/**
	 * 按照月份查询每天的参观人数
	 */
	@RequestMapping("/dayVisitorList.do")
	@ResponseBody
	public JSONObject dayVisitor(Integer year,Integer month,String orgId) {
		
		MuseumVisitorDto visitorInfo = new MuseumVisitorDto();
		visitorInfo.setYear(year);
		visitorInfo.setMonth(month);
		visitorInfo.setMuseumId(orgId);
		
		//按照月份查询每天的参观人数
		List<MuseumVisitorDto> visitorDayList = visitorService.selectVisitorDayList(visitorInfo);
		
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", "");
        jsonObject.put("data", visitorDayList);
		return jsonObject;
	}
	
	/**
	 * 按照年份查询每月的参观人数
	 */
	@RequestMapping("/monthVisitorList.do")
	@ResponseBody
	public JSONObject monthVisitor(Integer year ,String orgId) {
		
		MuseumVisitorDto visitorInfo = new MuseumVisitorDto();
		visitorInfo.setYear(year);
		visitorInfo.setMuseumId(orgId);
		
		//按照年份查询每月的参观人数
		List<MuseumVisitorMonth> visitorMonthList = visitorService.selectVisitorMonthList(visitorInfo);
		
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", "");
        jsonObject.put("data", visitorMonthList);
		return jsonObject;
	}
	
	/**
	 * 博物馆保存参观人数
	 * @return
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String save(MuseumVisitorDto daysDto,MuseumVisitorMonth monthDto){
		// 获取用户信息
		int num = visitorService.save(daysDto,monthDto);
		return String.valueOf(num);
	}
	
	/**
	 * 接收的消息列表
	 * @param size
	 * @param currentPage
	 * @param infoTitle
	 * @param readFlag
	 * @param dateRange
	 * @return
	 */
	@RequestMapping("/getMessageList.do")
	@ResponseBody
	public JsonResult getMessageList(String infoTitle,String dateRange,String limit) {
		LoginInfoDto user = Tools.getUser();
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("limit", 20);
		map.put("receiverId", user.getId());
		if(StringUtil.isNotEmpty(infoTitle)) {
			map.put("infoTitle", infoTitle.trim());
		}
		String submitTimeStart = "";
		String submitTimeEnd = "";
		
		if(StringUtil.isNotEmpty(dateRange)) {
			String[] submitTimes = {};
			submitTimes = dateRange.split("~");
			if(null != submitTimes && submitTimes.length > 0) {
				submitTimeStart = null != submitTimes[0] ? submitTimes[0].trim() : "";
				submitTimeEnd = null != submitTimes[1] ? submitTimes[1].trim() : "";
			}
		}
		
		map.put("submitTimeStart", submitTimeStart);
		map.put("submitTimeEnd", submitTimeEnd);
		
		List<InsideInfoDto> infoList = new ArrayList<InsideInfoDto>();
		try {
			infoList = insideInfoService.selectListForDesk(map);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(0,"系统异常");
		}
		return new JsonResult(1,infoList);
	}
	
	/**
	 * 接收的消息列表
	 * @param size
	 * @param currentPage
	 * @param infoTitle
	 * @param readFlag
	 * @param dateRange
	 * @return
	 */
	@RequestMapping("/getGovList.do")
	@ResponseBody
	public JsonResult getGovList(String title) {
		//法律法规板块，显示最新接收的最多八条数据
		Map<String,String> map= new HashMap<String, String>();
		map.put("title", title);
		List<GovLegal> govLegalList = govLegalService.getGovListForDesk(map);
		return new JsonResult(1,govLegalList);
	}
	/**
	 * 新增，编辑消息页面
	 * @return
	 */
	@RequestMapping("/messageInfo.do")
	public String goAdd() {
		return "/WEB-INF/back/desk/insideInfoAddDesk.jsp";
	}
	
	/**
	 * 保存消息
	 * @param infoTitle
	 * @param infoContent
	 * @param receiveOrgs 所选择的组织
	 * @return
	 */
	@RequestMapping("/saveMessage.do")
	@ResponseBody
	public String save(String infoTitle,String infoContent,String receiveOrgs) throws Exception{
		String result = "0";
		try {
			insideInfoService.saveForDesk(infoTitle,infoContent,receiveOrgs);
			result = "1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/goMessageList.do")
	public String goMessageList(){
		return "/WEB-INF/back/desk/messageList.jsp";
	}
	/**
	 * 发送的消息列表
	 * @param infoId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/messageList.do")
	@ResponseBody
	public JSONObject messageList(@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "1",name = "currentPage") int currentPage) throws Exception {
		LoginInfoDto user = Tools.getUser();
		//分页
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		Integer count = insideInfoService.getMessageCount(user.getId());
		page.setAllRow(count);
		
		List<InsideInfoDto> infoList = insideInfoService.selectMessageList(user.getId(),page.getStart(),page.getSize());
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg",""); 
        jsonObject.put("count", page.getAllRow());
        jsonObject.put("data", infoList);
		return jsonObject;
	}
	/**
	 * x消息详情
	 * @param infoId
	 * @return
	 */
	@RequestMapping("/goDetail.do")
	public ModelAndView goDetail(String infoId,String receiverId,String type) {
		LoginInfoDto user = Tools.getUser();
		InsideInfoDto insideInfoDto = new InsideInfoDto();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("infoId", infoId);
		map.put("receiverId", receiverId);
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/desk/insideInfoViewDesk.jsp");
		try {
			insideInfoDto = insideInfoService.queryInsideInfoDetailById(map);
			
			if("read".equals(type)){
				insideInfoDto.setReceiverId(user.getId());
				insideInfoService.updateReadFlag(insideInfoDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("insideInfoDetail",insideInfoDto);
		modelAndView.addObject("type",type);
		return modelAndView; 
	}
	/**
	 * x消息详情
	 * @param infoId
	 * @return
	 */
	@RequestMapping("/goListDetail.do")
	public ModelAndView goListDetail(String infoId,String type) {
		LoginInfoDto user = Tools.getUser();
		List<InsideInfoDto> insideInfoDtoList = new ArrayList<>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("infoId", infoId);
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/desk/insideInfoListViewDesk.jsp");
		String isReadNames = "";
		String isNotReadNames = "";
		InsideInfoDto insideInfoDto = new InsideInfoDto();
		try {
			insideInfoDtoList = insideInfoService.queryInsideInfoListDetailById(map);
			int i = 0;
			for (InsideInfoDto cinsideInfo : insideInfoDtoList) {
				if(i == 0) {
					insideInfoDto = cinsideInfo;
				}
				if(cinsideInfo.getReadFlag() == 1) {
					isReadNames += cinsideInfo.getReceiverName() + "、";
				}else {
					isNotReadNames += cinsideInfo.getReceiverName() + "、";
				}
				i++;
			}
			if(isReadNames.length() > 1) {
				isReadNames = isReadNames.substring(0, isReadNames.length() - 1);
			}
			if(isNotReadNames.length() > 1) {
				isNotReadNames = isNotReadNames.substring(0, isNotReadNames.length() - 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("insideInfoDetail",insideInfoDto);
		modelAndView.addObject("isReadNames",isReadNames);
		modelAndView.addObject("isNotReadNames",isNotReadNames);
		modelAndView.addObject("type",type);
		return modelAndView; 
	}
	
	/**
	 * 博物馆工作台展示页
	 * @return
	 */
	@RequestMapping("/bureauDeskInfo.do")
	@ResponseBody
	public ModelAndView bureauDeskInfo() {
		ModelAndView modelAndView = new ModelAndView("/WEB-INF/back/desk/bureauDesk.jsp");
		
		// 获取用户信息
		LoginInfoDto userDto = Tools.getUser();
		User user = userService.get(userDto.getId());
		String orgId = user.getOrgId();
		
		//通知公告板块，显示最新发布的四条
		List<GovNotice> selectListByOrgId = govNoticeService.selectListByOrgId(orgId);
		DecimalFormat format=new DecimalFormat("#");
		for (GovNotice govNotice : selectListByOrgId) {
			double look1 = govNotice.getIsLookNum() * 1.0 / (govNotice.getTotalLookNum() == 0? 1 : govNotice.getTotalLookNum());
			double look2 = (govNotice.getTotalLookNum() - govNotice.getIsLookNum()) * 1.0 / (govNotice.getTotalLookNum() == 0? 1 : govNotice.getTotalLookNum());
			double write1 = govNotice.getIsWriteNum() * 1.0 / (govNotice.getTotalWriteNum() == 0? 1 : govNotice.getTotalWriteNum());
			double write2 = (govNotice.getTotalWriteNum() - govNotice.getIsWriteNum()) * 1.0 / (govNotice.getTotalWriteNum() == 0? 1 : govNotice.getTotalWriteNum());
			govNotice.setIsLookPercent(format.format(look1*100) + "%");
			govNotice.setNotLookPercent(format.format(look2*100) + "%");
			govNotice.setIsWritePercent(format.format(write1*100) + "%");
			govNotice.setNotWritePercent(format.format(write2*100) + "%");
		}
		modelAndView.addObject("publishList", selectListByOrgId);
		
		//查询年度下拉：当前年份和过去已经录入数据的年份
		Calendar nowTime = Calendar.getInstance();  
		int nowYear = nowTime.get(Calendar.YEAR);
		int nowMonth = nowTime.get(Calendar.MONTH)+1;
		int nowDay = nowTime.get(Calendar.DAY_OF_MONTH);
		
		List<Map<String, Integer>> yearList = visitorService.getYearList(orgId);
		Boolean hasNowYear = false;
		for(Map<String,Integer> yearMap:yearList){
			if(yearMap.get("year") == nowYear){
				hasNowYear = true;
				break;
			}
		}
		if(!hasNowYear){
			Map<String,Integer> yMap = new HashMap<String, Integer>(); 
			yMap.put("year", nowYear);
			yearList.add(0, yMap);
		}
		modelAndView.addObject("yearList", yearList);
		modelAndView.addObject("nowYear", nowYear);
		
		//月份下拉
		List<Map<String, Integer>> monthList = new ArrayList<Map<String,Integer>>();
		for(int i=1;i<13;i++){
			Map<String, Integer> mMap = new HashMap<String, Integer>();
			mMap.put("month", i);
			monthList.add(mMap);
		}
		modelAndView.addObject("monthList", monthList);
		modelAndView.addObject("nowMonth", nowMonth);
		
		modelAndView.addObject("orgId", orgId);
		
		return modelAndView;
	}
	
	/**
	 * 获取今日动态
	 * @param date
	 * @param type		1-藏品  2-教育  3-展览  4-研究  5-文创
	 * @return
	 */
	@RequestMapping("/getTodayDynamicData.do")
	@ResponseBody
	public JsonResult getTodayDynamicData(String date, String type) {
		Date stringToDate = DateUtil.StringToDate(date);
		
		List<TodayDynamic> result = new ArrayList<>();
		String sql = "";
		//查询藏品的name，date，orgName
		if(StringUtils.isBlank(type)) {
			sql += getBusinessData(config.getBusinessCollection());
			sql += getBusinessData(config.getBusinessCollection2());
			sql += getBusinessData(config.getBusinessCollection3());
			sql += getBusinessData(config.getBusinessCollection4());
			sql += getBusinessData(config.getBusinessCollection5());
			sql += getBusinessData(config.getBusinessCollection6());
			sql += getBusinessData(config.getBusinessCollection7());
			sql += getBusinessData(config.getBusinessCollection8());
			sql += getBusinessData(config.getBusinessCollection9());
			sql += getBusinessData(config.getBusinessCollection10());
			sql += getBusinessData(config.getBusinessCollection11());
			sql += getBusinessData(config.getBusinessEducation());
			sql += getBusinessData(config.getBusinessEducation2());
			sql += getBusinessData(config.getBusinessExhibition());
//			sql += getBusinessData(config.getBusinessStudy());
//			sql += getBusinessData(config.getBusinessWenchuang());
		}else {
			if("1".equals(type)) {
				sql += getBusinessData(config.getBusinessCollection());
				sql += getBusinessData(config.getBusinessCollection2());
				sql += getBusinessData(config.getBusinessCollection3());
				sql += getBusinessData(config.getBusinessCollection4());
				sql += getBusinessData(config.getBusinessCollection5());
				sql += getBusinessData(config.getBusinessCollection6());
				sql += getBusinessData(config.getBusinessCollection7());
				sql += getBusinessData(config.getBusinessCollection8());
				sql += getBusinessData(config.getBusinessCollection9());
				sql += getBusinessData(config.getBusinessCollection10());
				sql += getBusinessData(config.getBusinessCollection11());
			}else if("2".equals(type)) {
				sql += getBusinessData(config.getBusinessEducation());
				sql += getBusinessData(config.getBusinessEducation2());
			}else if("3".equals(type)) {
				sql += getBusinessData(config.getBusinessExhibition());
			}else if("4".equals(type)) {
//				sql += getBusinessData(config.getBusinessStudy());
			}else if("5".equals(type)) {
//				sql += getBusinessData(config.getBusinessWenchuang());
			}
		}
		
		if(StringUtils.isBlank(sql)) {
		}else {
			sql = sql.substring(0, sql.lastIndexOf(" union all ")-1);
			sql = " select a.*, b.name as orgName from (" + sql + ") a  left join mip_organization b on(b.id=a.orgId) where 1=1 ";
			if(StringUtils.isNotBlank(date) && stringToDate != null) {
				Date dates = DateUtil.addDay(stringToDate, 1);
				String date2 = DateUtil.DateToString(dates, DateStyle.YYYY_MM_DD);
				sql += " and a.date BETWEEN '"+date+"' and '"+date2+"' ";
			}
			sql += " order by date desc";
			System.out.println(sql);
			sql += " limit 0, 8 ";
			List<Map<String, Object>> findForJdbc = systemService.findForJdbc(sql);
			for (Map<String, Object> map : findForJdbc) {
				TodayDynamic today = new TodayDynamic();
				if(map.get("bussCode") != null) {
					if(map.get("bussCode").toString().equals(config.getBusinessCollection()) 
							|| map.get("bussCode").toString().equals(config.getBusinessCollection2())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection3())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection4())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection5())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection6())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection7())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection8())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection9())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection10())
							|| map.get("bussCode").toString().equals(config.getBusinessCollection11())) {
						today.setAction("藏品");
					}
					if(map.get("bussCode").toString().equals(config.getBusinessEducation())
							|| map.get("bussCode").toString().equals(config.getBusinessEducation2())) {
						today.setAction("社教");
					}
					if(map.get("bussCode").toString().equals(config.getBusinessExhibition())) {
						today.setAction("展览");
					}
					if(map.get("bussCode").toString().equals(config.getBusinessStudy())) {
						today.setAction("研究");
					}
					if(map.get("bussCode").toString().equals(config.getBusinessWenchuang())) {
						today.setAction("文创");
					}
				}
				if(map.get("name") != null) {
					today.setShowName(map.get("name").toString());
				}
				if(StringUtils.isBlank(today.getShowName())) {
					if(map.get("name1") != null) {
						today.setShowName(map.get("name1").toString());
					}
				}
				if(StringUtils.isBlank(today.getShowName())) {
					if(map.get("name2") != null) {
						today.setShowName(map.get("name2").toString());
					}
				}
				if(StringUtils.isBlank(today.getShowName())) {
					if(map.get("name3") != null) {
						today.setShowName(map.get("name3").toString());
					}
				}
				if(map.get("date") != null) {
					String currentDate = map.get("date").toString();
					Date stringToDate2 = DateUtil.StringToDate(currentDate.length()>19?currentDate.substring(0, 18):currentDate);
					int intervalDays = DateUtil.getIntervalHours1(stringToDate2, new Date());
					today.setDate(DateUtil.StringToDate(currentDate));
					if(intervalDays < 24) {
						today.setIntervalDate(intervalDays + "小时前");
					}else {
						int intervalDays2 = intervalDays/24;
						if(intervalDays2 < 365) {
							today.setIntervalDate(intervalDays2 + "天前");
						}else {
							today.setIntervalDate((intervalDays2/365) + "年前");
						}
					}
				}
				if(map.get("orgName") != null) {
					today.setOrgName(map.get("orgName").toString());
				}
				if(map.get("bussCode") != null) {
					today.setCode(map.get("bussCode").toString());
				}
				if(map.get("id") != null) {
					today.setId(map.get("id").toString());
				}
				result.add(today);
			}
		}
		return new JsonResult(1, result);
	}
	
	/**
	 * 根据busscode，拼接sql
	 * @param sql
	 * @param bussCode
	 */
	private String getBusinessData(String bussCode) {
		String mainTableName = "cgform_rdata_master";
		try {
			CgformBussEntity cgformBuss = systemService.findUniqueByProperty(CgformBussEntity.class, "bussCode", bussCode);
			if(cgformBuss==null){
			}else {
				JSONObject jo=new JSONObject();
				String fields="",tempFields="";
				CgformDefineEntity tSConfigform = systemService.getEntity(CgformDefineEntity.class,cgformBuss.getDefineId());
				List<CgformBussListEntity> mainList = getFieldByBussList(cgformBuss.getId(),new String[]{"isShowList"});
				List<Map<String, Object>> rr1 = systemService.findForJdbc("SELECT field_name,temp_field   FROM cgform_field_temp"
						+ "  where buss_id='"+cgformBuss.getId()+"' ");
				if(mainList!=null&&mainList.size()>0){
					tempFields+="id as id,";
					tempFields+="create_date as date,";
					tempFields+="org_id as orgId,";
					if(mainList.get(1) != null) {
						for (Map<String, Object> map : rr1) {
							String fieldName = mainList.get(1).getFieldName();
							if(fieldName.equals(map.get("field_name"))) {
								tempFields+=map.get("temp_field")+" as name,";
							}
						}
					}
					tempFields += "'"+bussCode+"'" + " as bussCode,";
					tempFields=tempFields.substring(0, tempFields.length()-1);
				}
				StringBuffer ssq = new StringBuffer();
				ssq.append(" SELECT  "+(!"".equals(tempFields)?tempFields:fields));
				ssq.append(" FROM "+mainTableName+" ");
				ssq.append(" where 1=1 ");
				if("2".equals(tSConfigform.getSaveType())){
					ssq.append(" and  buss_id='"+cgformBuss.getId()+"' ");
				}
				return ssq.toString() + " union all ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public List<CgformBussListEntity> getFieldByBussList(String bussId,String[] flag) {
		CriteriaQuery cq = new CriteriaQuery(CgformBussListEntity.class);
		cq.eq("bussId", bussId);
		if(flag!=null&&flag.length>0){
			for(int i=0;i<flag.length;i++){
				if("isShowList".equals(flag[i])){
					cq.eq("isShowList", "Y");
				}
			}
		}
		cq.addOrder("sort", SortDirection.asc);
		cq.add();
		return systemService.getListByCriteriaQuery(cq, false);
	}
	
	/**
	 * 获取展览查询的sql
	 * @return
	 */
	@RequestMapping("/getExhibitionSql.do")
	@ResponseBody
	public JsonResult getExhibitionSql() {
		String businessData = getBusinessData(config.getBusinessExhibition());
		String sql = "";
		if(!StringUtils.isBlank(businessData)) {
			businessData = businessData.substring(0, businessData.lastIndexOf(" union all ")-1);
			for (int i = 7; i > 0; i--) {
				sql += " select date_format(DATE_SUB(curdate(), INTERVAL "+i+" MONTH),'%Y年%m月') as month, count(a.id) as num " + 
						"from ( ";
				sql += businessData;
				sql += ") a where date_format(a.date, '%Y %m') = date_format(DATE_SUB(curdate(), INTERVAL "+i+" MONTH),'%Y %m')";
				
				if(i != 1) {
					sql += " union all ";
				}
			}
		}
		return new JsonResult(1, sql);
	}
	
}
