package com.novalearn.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.novalearn.model.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Integer>
{
	public List<Chapter> findByCoursename(String Coursename);
	
}