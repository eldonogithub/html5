package ca.blackperl.struts.actions;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ca.blackperl.dwr.bean.AjaxBean;
import ca.blackperl.dwr.bean.AjaxMetaData;
import ca.blackperl.dwr.bean.AjaxResults;
import ca.blackperl.dwr.bean.DatabaseResults;
import ca.blackperl.dwr.bean.MetaData;
import ca.blackperl.dwr.enums.Status;
import ca.blackperl.struts.forms.ViewTableForm;

public class ViewTableAction extends Action {
	private static final Logger log = LogManager.getLogger(ViewTableAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ViewTableForm viewTableForm = (ViewTableForm) form;
		log.debug(viewTableForm);

		log.debug("Fetching toursdb info");

		DatabaseResults datarows = new DatabaseResults();
		try {
			DataSource ds = AjaxBean.getDataSource("toursDb");
			try (Connection connection = ds.getConnection()) {
				try (PreparedStatement prepareStatement = connection.prepareStatement("select * from " + viewTableForm.getTableName())) {

					try (ResultSet tables = prepareStatement.executeQuery()) {

						ResultSetMetaData rsmeta = tables.getMetaData();
						int columnCount = rsmeta.getColumnCount();
						List<String> header = new ArrayList<String>();
						log.debug("Total columns: " + columnCount);
						for (int i = 1; i <= columnCount; i++) {
							log.debug("column[" + i + "] " + rsmeta.getColumnName(i));
							header.add(rsmeta.getColumnName(i));
						}

						List<List<String>> rows = new ArrayList<List<String>>();
						while (tables.next()) {
							List<String> row = new ArrayList<String>();

							for (int i = 1; i <= columnCount; i++) {
								row.add(tables.getString(i));
							}
							rows.add(row);
							log.debug(row);
						}
						datarows.setRows(rows);
						datarows.setHeader(header);
					}
				}
			}
		} catch (Throwable e) {
			log.error(e, e);
		}
		viewTableForm.setResults(datarows);
		return mapping.getInputForward();
	}
}
