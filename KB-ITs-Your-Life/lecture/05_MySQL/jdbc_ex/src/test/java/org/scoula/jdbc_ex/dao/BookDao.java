package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.BookDetailVO;
import org.scoula.jdbc_ex.domain.BookVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDao {
    int create(BookVO book) throws SQLException;

    List<BookVO> getList() throws SQLException;

    Optional<BookVO> get(Integer id) throws SQLException;

    int update(BookVO book) throws SQLException;

    int delete(Integer id) throws SQLException;

    int createBookWithDetail(BookVO book, BookDetailVO detail) throws SQLException;
}
