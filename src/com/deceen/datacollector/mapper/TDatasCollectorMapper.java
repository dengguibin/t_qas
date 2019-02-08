/**
*/
package	com.deceen.datacollector.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.datacollector.model.TDatasCollector;

@Component("tDatasCollectorMapper")
@SuppressWarnings({ "rawtypes" })
public interface TDatasCollectorMapper {

	TDatasCollector select(Object id);
	
	int insert(TDatasCollector bean);
	
	int update(TDatasCollector bean);
	/* 需要时请开启,动态进行更新*/
	int updateWithDyna(TDatasCollector bean);
	
	List  list(TDatasCollector bean);
	
	int delete(Object id);
	
}

