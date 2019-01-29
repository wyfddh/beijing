package com.tj720.mip.inter.service.tool;

import java.util.List;

import com.tj720.mip.dto.ILuceneDto;

public interface ILuceneService<T extends ILuceneDto>{
	public List<T> getAll();
}
