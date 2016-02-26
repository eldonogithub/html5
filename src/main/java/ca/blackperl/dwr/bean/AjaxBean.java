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

import ca.blackperl.dwr.enums.Status;

public class AjaxBean {

	public String test() {
		return "test";
	}
	
	public AjaxResults queryDatabase() {
		AjaxResults ajaxResults = new AjaxResults();
		
		try {
			// Obtain our environment naming context
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			// Look up our data source
			DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

			// Allocate and use a connection from the pool
			try (Connection conn = ds.getConnection()) {
				DatabaseResults results = new DatabaseResults();
				PreparedStatement testst = conn.prepareStatement("select * from testdata");

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
				
				ajaxResults.setResults(results );
				ajaxResults.setStatus(Status.SUCCESS);
			}
			catch( SQLException e) {
				ajaxResults.setStatus(Status.FAILURE);
				ajaxResults.setMessage(e.getMessage());
			}
		} catch (NamingException e) {
			ajaxResults.setStatus(Status.FAILURE);
			ajaxResults.setMessage(e.getMessage());
		}
		catch (Exception e) {
			ajaxResults.setStatus(Status.FAILURE);
			ajaxResults.setMessage(e.getMessage());
		}

		return ajaxResults;
		
	}
	
}
