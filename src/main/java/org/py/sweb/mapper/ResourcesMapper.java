package org.py.sweb.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.py.sweb.model.Resources;
import tk.mybatis.mapper.common.Mapper;

public interface ResourcesMapper extends Mapper<Resources> {
    final String TABLE = "resources";

    @Update({"update ", TABLE, " set res_name=#{resName}, source=#{source},",
                "belong_id=#{belongId}, content=#{content}"})
    int update(Resources entity);

    @Select({"select * from ", TABLE, " where id=#{id}"})
    Resources selectById(long id);
}
