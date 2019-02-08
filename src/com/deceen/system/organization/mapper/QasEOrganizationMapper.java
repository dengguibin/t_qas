/**
*/
package	com.deceen.system.organization.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.system.organization.model.QasEOrganization;

@Component("qasEOrganizationMapper")
public interface QasEOrganizationMapper {

	QasEOrganization select(Object id);
	
	int insert(QasEOrganization bean);
	
	int update(QasEOrganization bean);
	
	int updateWithDyna(QasEOrganization bean);

	List<QasEOrganization> list(String status);
	
	List<QasEOrganization> listAll();
	
	List<QasEOrganization> queryByParentId(String id);
	
	List<QasEOrganization> selectTree(String orgname);
	
	int delete(Object id);
	
}

