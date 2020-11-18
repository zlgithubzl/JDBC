package Util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
    /**
     * 查询到的结果的映射
     * @param rs
     * @return
     * @throws SQLException
     */
    Object mapRow(ResultSet rs) throws SQLException;
}
