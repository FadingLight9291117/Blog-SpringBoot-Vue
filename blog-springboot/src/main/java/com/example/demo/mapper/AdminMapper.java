package com.example.demo.mapper;


import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

	@Update("UPDATE ADMIN SET password = #{newPassword} WHERE ADMIN_ACCOUNT = #{account} " )
	Integer updatePwd(String account, String newPassword);

	@Select("SELECT * FROM ADMIN WHERE ADMIN_ACCOUNT = #{account}")
	Admin getAdminByAccount(String account);

}
