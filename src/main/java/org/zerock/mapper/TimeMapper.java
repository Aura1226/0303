package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
@Component
public interface TimeMapper {
	@Select(value = "select now()")
	String getTime();
	
	String getTime2();
	
}
