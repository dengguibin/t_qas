package	com.deceen.data.school.rooms.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.rooms.model.QasDRooms;

@Component("qasDRoomsMapper")
public interface QasDRoomsMapper {

	QasDRooms select(Object id);
	
	int insert(QasDRooms bean);
	
	int update(QasDRooms bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDRooms bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDRooms bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

