package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

@Component
public class SampleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<SampleEntity> getAll() {

		String sql = "SELECT * FROM SAMPLE_DATA";
        List<SampleEntity> result = new ArrayList<SampleEntity>();

		jdbcTemplate.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				SampleEntity res = new SampleEntity();
				res.setId(rs.getString("ID"));
				res.setName(rs.getString("NAME"));
				result.add(res);
			}
		});
		return result;
	}
	
    public void create(SampleEntity entity) {
        StringBuilder sql = new StringBuilder();

        sql.append("insert into SAMPLE_DATA values (?, ?)");

        List<Object> param = new ArrayList<Object>();
        param.add(entity.getId());
        param.add(entity.getName());

        jdbcTemplate.update(sql.toString(), param.toArray());
    }
}
