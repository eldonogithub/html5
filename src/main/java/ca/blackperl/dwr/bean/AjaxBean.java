package ca.blackperl.dwr.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDataSource;

import ca.blackperl.dwr.enums.Status;

public class AjaxBean {

	public AjaxResults getWishList() {
		AjaxResults ajaxResults = new AjaxResults();
		
		try {
			DataSource ds = getDataSource("jdbcDemoDB");
	
			String string = "select * from wish_list";
			executeQuery(ajaxResults, ds, string );
		} catch (NamingException e) {
			ajaxResults.failue(e.getMessage());
		}
		catch (Exception e) {
			ajaxResults.failue(e.getMessage());
		}
	
		return ajaxResults;
		
	}

	public AjaxResults getTestData() {
		AjaxResults ajaxResults = new AjaxResults();
		
		try {
			DataSource ds = getDataSource("TestDB");

			String string = "select * from testdata";
			executeQuery(ajaxResults, ds, string);
		} catch (NamingException e) {
			ajaxResults.failue(e.getMessage());
		}
		catch (Exception e) {
			ajaxResults.failue(e.getMessage());
		}

		return ajaxResults;
		
	}

	private void executeQuery(AjaxResults ajaxResults, DataSource ds, String string) {
		// Allocate and use a connection from the pool
		try (Connection conn = ds.getConnection()) {
			DatabaseResults results = new DatabaseResults();
			PreparedStatement testst = conn.prepareStatement(string);

			ResultSet rs = testst.executeQuery();
			List<List<String>> datarows = new ArrayList<List<String>>();
			List<String> header = new ArrayList<String>();
			if (rs != null) {
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				for ( int col = 1; col <= columnCount; col++) {
					header.add(metaData.getColumnLabel(col));
				}
				while (rs.next()) {
					List<String> row = new ArrayList<String>();
					for (int col = 1; col <= columnCount; col++) {
						row.add(rs.getString(col));
					}
					datarows.add(row);
				}
			}
			
			results.setHeader(header);
			results.setRows(datarows);
			
			ajaxResults.success(results);
		}
		catch( SQLException e) {
			ajaxResults.failue(e.getMessage());
		}
	}
	
	private DataSource getDataSource(String dataSource) throws NamingException {
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		
		DataSource ds = (DataSource) envCtx.lookup("jdbc/" + dataSource);
		if ( ds instanceof ClientDataSource  ) {
			
		}
		return ds;
	}
}
