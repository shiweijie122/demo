package cn.tedu.ttms.user.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.utils.DataOptUtil;
import cn.tedu.ttms.user.entity.ContactInfo;
import cn.tedu.ttms.user.entity.Menu;
import cn.tedu.ttms.user.entity.User;
import cn.tedu.ttms.user.entity.UserRole;
import cn.tedu.ttms.user.mapper.UserMapper;
import cn.tedu.ttms.user.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	public List<User> selectUser(User user, PageObject pageObj) throws Exception {
		return userMapper.selectUser(user, pageObj);
	}
	
	public List<User> selectUserList(User user, PageObject pageObj) throws Exception {
		return userMapper.selectUserList(user, pageObj);
	}
	
	
	public List<User> selectUserClass(User user, PageObject pageObj) throws Exception {
		return userMapper.selectUserClass(user, pageObj);
	}
	
	
	public List<User> selectUserType(User user, PageObject pageObj) throws Exception {
		return userMapper.selectUserType(user, pageObj);
	}
	

	public List<User> selectUserRole(User user, PageObject pageObj) throws Exception {
		return userMapper.selectUserRole(user, pageObj);
	}
	
	public int GetRecordCount(User user) throws Exception {
		return userMapper.GetRecordCount(user);
	}

	public int addUser(User user) throws Exception {
		return userMapper.addUser(user);
	}

	public int updateUserValid(User user) throws Exception {
		return userMapper.updateUserValid(user);
	}
	
	public int checkUserId(String userName) throws Exception {
		return userMapper.checkUserId(userName);
	}
	
	public int updateUser(User user) throws Exception {
		return userMapper.updateUser(user);
		
	}
	
	public int updateUser(User user, String contacts) throws Exception {
		//删除用户联系方式
		ContactInfo contactInfo=new ContactInfo();
		contactInfo.setUserName(user.getUserName());
		/*this.delContactInfo(contactInfo);*/
	userMapper.delContactInfo(contactInfo);
		//新增用户联系方式
		if(DataOptUtil.isNotNull(contacts)){
			String[] bufContact = contacts.split(",");
			for(String data:bufContact){
				if(DataOptUtil.isNotNull(data)){
					String[] detail = data.split(":");
					ContactInfo contact = new ContactInfo();
					contact.setUserName(user.getUserName());
					contact.setContactType(detail[0]);
					contact.setContactInfo(detail[1]);
					/*this.addContactInfo(contact);*/
					userMapper.addContactInfo(contact);
				}
			}
		}
		return userMapper.updateUser(user);
	}
	
	public int deleteUser(String userId) throws Exception {
		return userMapper.deleteUser(Arrays.asList(userId.split(",")));
	}
	
	public int delUser(String userName) throws Exception {
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setUserName(userName);
		/*delContactInfo(contactInfo);*/
		userMapper.delContactInfo(contactInfo);
		return userMapper.delUser(userName);
	}

	public List<ContactInfo> selectContactInfo(ContactInfo contactInfo) throws Exception {
		return userMapper.selectContactInfo(contactInfo);
	}

	/*@Override
	public int delContactInfo(ContactInfo contactInfo) throws Exception {
		return userMapper.delContactInfo(contactInfo);
	}*/

	/*@Override
	public int addContactInfo(ContactInfo contactList) throws Exception {
		return userMapper.addContactInfo(contactList);
	}*/
	
	public int addUserRole(List<UserRole> userRoleList, String userName) throws Exception {
		int ret = 0;
		delUserRole(userName);
		for(UserRole userRole:userRoleList){
			ret = userMapper.addUserRole(userRole);
		}
		
		return ret;
	}
	
	public int delUserRole(String userName) throws Exception{
		return userMapper.delUserRole(userName);
	}
	
	public List<UserRole> selectRoleByUser(String userName) throws Exception {
		return userMapper.selectRoleByUser(userName);
	}

	public List<Menu> selectMenuByUser(String userName) throws Exception {
		return userMapper.selectMenuByUser(userName);
	}

	public String selectUserOrgName(String id) throws Exception {
		return userMapper.selectUserOrgName(id);
	}

	public String selectUserGrpName(String id) throws Exception {
		return userMapper.selectUserGrpName(id);
	}

	public List<User> selectUserRoleName(String id)
			throws Exception {
		return userMapper.selectUserRoleName(id);
	}

	public int updateUserRole(User user) throws Exception {
		return userMapper.updateUserRole(user);
	
	}
	
	public int delUpdateUserRole(String userId) throws Exception {
		return userMapper.delUpdateUserRole(Arrays.asList(userId.split(",")));
	
	}

	public int updateUserRole2(User user) throws Exception {
		return userMapper.updateUserRole2(user);

	}

	public String selOrgId(String id) {
		return userMapper.selOrgId(id);
	}



}
