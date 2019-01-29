package com.tj720.admin.dto;

import java.util.List;

import com.tj720.admin.model.CurationChapter;
import com.tj720.admin.model.CurationChapterCollection;


public class CurationChapterDto extends CurationChapter{

	private List<CurationChapterCollection> collections;

	public List<CurationChapterCollection> getCollections() {
		return collections;
	}
	public void setCollections(List<CurationChapterCollection> collections) {
		this.collections = collections;
	}
	
}
