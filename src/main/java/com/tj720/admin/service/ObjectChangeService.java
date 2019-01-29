package com.tj720.admin.service;

import com.tj720.admin.dto.ObjectChangeDto;

public interface ObjectChangeService {
	ObjectChangeDto getChangeDto(String orgTypeId,String orgId);

}
