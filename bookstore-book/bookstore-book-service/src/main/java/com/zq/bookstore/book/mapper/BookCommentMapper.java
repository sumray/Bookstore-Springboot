package com.zq.bookstore.book.mapper;

import com.zq.bookstore.book.pojo.BookComment;
import com.zq.bookstore.book.pojo.BookCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookCommentMapper {
    int countByExample(BookCommentExample example);

    int deleteByExample(BookCommentExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(BookComment record);

    int insertSelective(BookComment record);

    List<BookComment> selectByExample(BookCommentExample example);

    BookComment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") BookComment record, @Param("example") BookCommentExample example);

    int updateByExample(@Param("record") BookComment record, @Param("example") BookCommentExample example);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKey(BookComment record);
}