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
			DataSource ds = getDataSource("jdbcDemoDB"); //$NON-NLS-1$
	
			String string = "select * from wish_list"; //$NON-NLS-1$
			executeQuery(ajaxResults, ds, string );
		} catch (NamingException e) {
			ajaxResults.failue(Messages.getString("AjaxBean.datasource.unavailable"), e.getMessage()); //$NON-NLS-1$
		}
		catch (Exception e) {
			ajaxResults.failue(Messages.getString("AjaxBean.database.query.failed"), e.getMessage()); //$NON-NLS-1$
		}
	
		return ajaxResults;
		
	}

	public AjaxResults getTestData() {
		AjaxResults ajaxResults = new AjaxResults();
		
		try {
			DataSource ds = getDataSource("TestDB"); //$NON-NLS-1$

			String string = "select * from testdata"; //$NON-NLS-1$
			executeQuery(ajaxResults, ds, string);
		} catch (NamingException e) {
			ajaxResults.failue(Messages.getString("AjaxBean.datasource.unavailable"), e.getMessage()); //$NON-NLS-1$
		}
		catch (Exception e) {
			ajaxResults.failue(Messages.getString("AjaxBean.database.query.failed"), e.getMessage()); //$NON-NLS-1$
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
			ajaxResults.failue(Messages.getString("AjaxBean.database.query.failed"), e.getMessage()); //$NON-NLS-1$
		}
	}
	
	private DataSource getDataSource(String dataSource) throws NamingException {
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env"); //$NON-NLS-1$
		
		DataSource ds = (DataSource) envCtx.lookup("jdbc/" + dataSource); //$NON-NLS-1$
		if ( ds instanceof ClientDataSource  ) {
			
		}
		return ds;
	}
}
