package org.py.sweb.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.py.sweb.model.Upfiles;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UpfileMapper extends Mapper<Upfiles> {
    final String TABLE = "upfiles";

    @Update({"update ", TABLE, " set title=${title}, author=${author}, ext_name=${extName}, descr=${descr}",
            "filetype=${filetype}, upload_datetime=${uploadDatetime},", "content=${content}"})
    int update(Upfiles entity);

    @Select({"select * from ", TABLE, " where id=${id}"})
    Upfiles selectById(long id);

    @Select({"select * from ", TABLE, " order by id ${sort.name()}"})
    List<Upfiles> selectEvery(Sort sort);

    @Delete({"delete from ", TABLE, " where id=${id}"})
    int deleteById(long id);
}
