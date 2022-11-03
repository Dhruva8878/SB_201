package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Tag;
import com.masai.repository.TagDao;

@Service
public class TagServiceImpl implements TagService{

	@Autowired
	private TagDao tagDao;

	@Override
	public Tag createTag(Tag tag) {
		return tagDao.save(tag);
	}

}
