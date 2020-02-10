package com.todo1.store.data.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AbstractDAO {

	public static final Logger log = LoggerFactory.getLogger(AbstractDAO.class);

	@Autowired
	protected JdbcTemplate template;

}
