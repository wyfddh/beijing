package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.model.MipCollectionAudio;
import com.tj720.admin.model.MipCollectionAudioExample;

public interface IAudioSearchService {
	public List<MipCollectionAudio> getUserList(MipCollectionAudioExample curation);
	public int allPage(MipCollectionAudioExample curation);
	public int updateAudio(MipCollectionAudio record);

}
