package com.tj720.mip.dto;

import com.tj720.mip.inter.service.tool.ICacheService;

public interface ILuceneDto {
	public SearchDto toSearchDto(ICacheService cacheService);
}
