package com.zq.bookstore.book.mapper;

import com.zq.bookstore.book.pojo.BookDescription;
import com.zq.bookstore.book.pojo.BookDescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookDescriptionMapper {
    int countByExample(BookDescriptionExample example);

    int deleteByExample(BookDescriptionExample example);

    int deleteByPrimaryKey(String bdid);

    int insert(BookDescription record);

    int insertSelective(BookDescription record);

    List<BookDescription> selectByExample(BookDescriptionExample example);

    BookDescription selectByPrimaryKey(String bdid);

    int updateByExampleSelective(@Param("record") BookDescription record, @Param("example") BookDescriptionExample example);

    int updateByExample(@Param("record") BookDescription record, @Param("example") BookDescriptionExample example);

    int updateByPrimaryKeySelective(BookDescription record);

    int updateByPrimaryKey(BookDescription record);
}