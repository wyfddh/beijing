package com.tj720.admin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tj720.admin.dto.MipOpenCulturalreicInfoDto;
import com.tj720.admin.model.MipOpenCulturalrelicInfo;
import com.tj720.admin.model.MipOpenFossilInfo;
import com.tj720.admin.service.InteractionService;
import com.tj720.admin.service.MipOpenCulturalrelicInfoService;
import com.tj720.admin.service.MipOpenFossilInfoService;
import com.tj720.mip.inter.service.table.IMipCollectionLevelService;
import com.tj720.mip.inter.service.table.IPictureService;
import com.tj720.mip.inter.service.table.IUserService;
import com.tj720.mip.model.MipOrganization;
import com.tj720.mip.model.User;
import com.tj720.mip.service.table.CollectionCategoryService;
import com.tj720.mip.service.table.MipCollectionLevelService;
import com.tj720.mip.service.table.MipOrganizationService;
import com.tj720.mip.service.table.YearTypeService;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.HttpPostGet;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class InteractionServiceImpl implements InteractionService {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private MipOrganizationService mipOrganizationService;
    @Autowired
    private MipOpenCulturalrelicInfoService mipOpenCulturalrelicInfoService;
    @Autowired
    private MipOpenFossilInfoService mipOpenFossilInfoService;
    @Autowired
    private IPictureService iPictureService;
    @Autowired
    private YearTypeService yearTypeService;
    @Autowired
    private CollectionCategoryService collectionCategoryService;
    @Autowired
    private IMipCollectionLevelService iMipCollectionLevelService;

    @Override
    public String createUser(String id) throws Exception {
        User user = iUserService.get(id);
        if (Objects.isNull(user)) {
            return null;
        }
        MipOrganization mipOrganization = mipOrganizationService.get(user.getOrgId());
        if (Objects.isNull(mipOrganization)) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        map.put("dwid", mipOrganization.getDwid());
        map.put("munit_name", mipOrganization.getName());
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept-Charset", "UTF-8");
        //TODO:接口地址
        String json = HttpPostGet.post("http://fumingzheng.51vip.biz:30290/jilin2/icmsApi/jilinInitDataRestController/initBaseData", map, headers);
        return json;
    }

    @Override
    public String createCulturalRelic(String culturalRelicId, String type) throws Exception {
        MipOpenCulturalrelicInfo mipOpenCulturalrelicInfo = null;
        MipOpenFossilInfo mipOpenFossilInfo = null;
        String[] ids = null;
        if ("1".equals(type)) {
            mipOpenCulturalrelicInfo = mipOpenCulturalrelicInfoService.get(culturalRelicId);
            if (Objects.isNull(mipOpenCulturalrelicInfo)) {
                return null;
            }
            ids = mipOpenCulturalrelicInfo.getPictureIds().split(",");
        }
        if ("2".equals(type)) {
            mipOpenFossilInfo = mipOpenFossilInfoService.get(culturalRelicId);
            if (Objects.isNull(mipOpenFossilInfo)) {
                return null;
            }
            ids = mipOpenFossilInfo.getPictureIds().split(",");
        }
        List<String> pictureList = iPictureService.getUrlsByIds(ids);
        MipOpenCulturalreicInfoDto dto = new MipOpenCulturalreicInfoDto();
        if ("1".equals(type)) {
            BeanUtils.copyProperties(mipOpenCulturalrelicInfo, dto);
            dto.setGsCollectionsno(mipOpenCulturalrelicInfo.getGsCollectionsNo());
            dto.setGsCollectionsnoType(mipOpenCulturalrelicInfo.getGsCollectionsNoType());
        }
        if ("2".equals(type)) {
            BeanUtils.copyProperties(mipOpenFossilInfo, dto);
            dto.setGsCollectionsno(mipOpenFossilInfo.getGsCollectionsNo());
            dto.setGsCollectionsnoType(mipOpenFossilInfo.getGsCollectionsNoType());
        }
        dto.setPictureList(pictureList);
        dto.setYearType(yearTypeService.get(dto.getYearType()).getPathName());
        dto.setCollectionsCategory(collectionCategoryService.get(dto.getCollectionsCategory()).getName());
        dto.setCollectionLevel(iMipCollectionLevelService.getById(dto.getCollectionLevel()).getName());
        if (dto.getActualQuantity() == 0) {
            dto.setActualQuantity((float) 1);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("dwid",dto.getDwid());
        map.put("cul_data", objectMapper.writeValueAsString(dto));
        System.err.println(map.get("cul_data"));
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept-Charset", "UTF-8");
        //TODO:接口地址
        String json = HttpPostGet.post("http://fumingzheng.51vip.biz:30290/jilin2/icmsApi/jilinInitDataRestController/initCoreData", map, headers);
        return json;
    }

}
