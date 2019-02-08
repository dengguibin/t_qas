package	com.deceen.data.school.booksInLibrary.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.booksInLibrary.model.QasDBooksinlibrary;

@Component("qasDBooksinlibraryMapper")
public interface QasDBooksinlibraryMapper {

	QasDBooksinlibrary select(Object id);
	
	int insert(QasDBooksinlibrary bean);
	
	int update(QasDBooksinlibrary bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDBooksinlibrary bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

