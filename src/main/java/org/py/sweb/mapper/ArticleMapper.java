package org.py.sweb.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.py.sweb.model.Article;
import tk.mybatis.mapper.common.Mapper;

public interface ArticleMapper extends Mapper<Article> {
    String TABLE = "article";

    @Update({"update ", TABLE, " set title=#{title}, small_title=#{smallTitle},",
        "author=#{author}, source=#{source}, resource_id=#{resourceId},",
        "publish_datetime=#{publishDatetime}, art_lock=#{artLock},",
        "keyword=#{keyword}, user_group=#{userGroup}, clicks=#{clicks},",
        "thumbnail=#{thumbnail}, album=#{album}, content=#{content}"})
    int update(Article entity);

    @Select({"select * from ", TABLE, " where id=#{id}"})
    Article selectById(long id);
}
