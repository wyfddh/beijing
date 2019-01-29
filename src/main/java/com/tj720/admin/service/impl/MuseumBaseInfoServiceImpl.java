package com.tj720.admin.service.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.vo.SysDictVo;
import com.tj720.admin.dao.map.IMuseumBaseInfoMapper;
import com.tj720.admin.dto.MuseumBaseInfoDto;
import com.tj720.admin.dto.MuseumDataProgressDto;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.service.IMuseumBaseInfoService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.utils.MyString;
import com.tj720.mip.utils.Tools;



@Service("MuseumBaseInfoServiceImpl")	
public class MuseumBaseInfoServiceImpl implements IMuseumBaseInfoService {

	@Autowired
    private IMuseumBaseInfoMapper museumBaseInfoDao;
	
	@Override
	public int getCount(MuseumBaseInfoDto museumBaseInfoDto){
		return museumBaseInfoDao.getCount(museumBaseInfoDto);
	}
    //条件查询角色分页
    @Override
    public List<MuseumBaseInfoDto> selectMuseumList(MuseumBaseInfoDto museumBaseInfoDto){
        List<MuseumBaseInfoDto> list = museumBaseInfoDao.selectMuseumList(museumBaseInfoDto);
        return list;
    };
    //查条件下拉
    @Override
    public List<SysDictVo> getDictListByKey(String key){
    	List<SysDictVo> dictList = museumBaseInfoDao.getDictListByKey(key);
    	return dictList;
    };
    
    //查看博物馆完成度详情
    @Override
    public MuseumDataProgressDto getDetail(String museumId,String level){
    	MuseumDataProgressDto reMap = museumBaseInfoDao.getDetail(museumId,level);
    	return reMap;
    };
    
   //加载博物馆基础信息详情
    @Override
    public MuseumBaseInfoDto selectMuseumById(String id,String del){
        return museumBaseInfoDao.selectMuseumById(id,del);
    };
    
    //保存博物馆基本信息
    @Override
    public int saveBaseInfo(MuseumBaseInfoDto museumBaseInfo){
    	// 当前登录者
		String userId = Tools.getUser().getId();
        String id = museumBaseInfo.getId();
        int num = 0;
        try {
        	if(!MyString.isEmpty(id)){
                museumBaseInfo.setUpdateId(userId);
                museumBaseInfo.setUpdateTime(new Date());
                museumBaseInfo.setFlag("1");
                museumBaseInfoDao.update(museumBaseInfo);//保存
                
                //删除所有为3状态的记录
                museumBaseInfoDao.deleteBase(museumBaseInfo.getMuseumId(), "3");
                //插入一条状态为3的修改记录数据
                museumBaseInfo.setCreatorId(userId);
                museumBaseInfo.setUpdateId(userId);
                museumBaseInfo.setUpdateTime(new Date());
                museumBaseInfo.setCreateTime(new Date());
                museumBaseInfo.setId(IdUtils.nextId(museumBaseInfo));
                museumBaseInfo.setFlag("3");
                num = museumBaseInfoDao.insert(museumBaseInfo);
                
            }else{
                museumBaseInfo.setCreatorId(userId);
                museumBaseInfo.setUpdateId(userId);
                museumBaseInfo.setUpdateTime(new Date());
                museumBaseInfo.setCreateTime(new Date());
                museumBaseInfo.setId(IdUtils.nextId(museumBaseInfo));
                museumBaseInfo.setFlag("1");
                num=museumBaseInfoDao.insert(museumBaseInfo);//保存
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return num;
    };
    
    @Override
    public int insertProgress(MuseumDataProgressDto progressInfo){
    	return museumBaseInfoDao.insertProgress(progressInfo);
    }
    
    @Override
    public int updateProgress(MuseumDataProgressDto progressInfo){
    	progressInfo.setUpdateId(Tools.getUser().getId());
    	progressInfo.setUpdateTime(new Date());
    	return museumBaseInfoDao.updateProgress(progressInfo);
    }
    @Override
    public void deleteBase(String museumId,String flag){
    	museumBaseInfoDao.deleteBase(museumId,flag);
    };
    @Override
    public void insertBase(MuseumBaseInfoDto base){
    	String userId = Tools.getUser().getId();
    	base.setCreatorId(userId);
		base.setUpdateId(userId);
		base.setUpdateTime(new Date());
		base.setCreateTime(new Date());
		base.setId(IdUtils.nextId(base));
    	museumBaseInfoDao.insert(base);//保存
    };
    @Override
    public void updateFlag(MuseumBaseInfoDto museumBaseInfoDto){
    	String userId = Tools.getUser().getId();
    	museumBaseInfoDto.setUpdateId(userId);
    	museumBaseInfoDto.setUpdateTime(new Date());
    	museumBaseInfoDao.updateFlag(museumBaseInfoDto);//g 
    }
    
    public int deleteProgress(String museumId){
    	return museumBaseInfoDao.deleteProgress(museumId);
    };
    
    public List<Map<String,Object>> getAreaList(){
    	return museumBaseInfoDao.getAreaList();
    };
}
