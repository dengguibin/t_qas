package	com.deceen.data.teaching.skillMasterStudio.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.skillMasterStudio.model.QasDSkillmasterstudio;

@Component("qasDSkillmasterstudioMapper")
public interface QasDSkillmasterstudioMapper {

	QasDSkillmasterstudio select(Object id);
	
	int insert(QasDSkillmasterstudio bean);
	
	int update(QasDSkillmasterstudio bean);
	 /*需要时请开启,动态进行更新*/
	int updateWithDyna(QasDSkillmasterstudio bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSkillmasterstudio bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

