package com.tj720.admin.service;

import javax.servlet.http.HttpSession;

import com.tj720.admin.dto.MuseumCostDto;
import com.tj720.admin.dto.MuseumDigitizationDto;
import com.tj720.admin.dto.MuseumPublicServiceDto;

public interface IMuseumDigitizationService {

    public MuseumDigitizationDto selectForm(String museumId,String flag);

    public int save(MuseumDigitizationDto digitizationDto);
    
    public void deleteBase(String museumId,String flag);
    
    public void updateFlag(MuseumDigitizationDto digitizationDto);
    
    public void insertDigitization(MuseumDigitizationDto digitizationDto);
}
