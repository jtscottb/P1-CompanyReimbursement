package com.revature;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class Table {

	public String generateHTMLTable(List<?> list) {
		StringBuffer table = new StringBuffer("<table>");
		StringBuffer columns = new StringBuffer();
		StringBuffer rows = new StringBuffer();
		StringBuffer data = new StringBuffer();
		Field[] fields = list.get(0).getClass().getFields();
		for(Field f : fields) {
			String header = f.toString().substring(f.toString().lastIndexOf(".")+1);
			columns.append("<th>").append(header).append("</th>\n");
		}
		rows.append("\n<tr>\n").append(columns).append("</tr>\n");
		try {
			for(Object o : list) {
				for(int i = 0; i < fields.length; i++) {
					Object value = fields[i].get(o);
					String val = Objects.isNull(value) ? "null" : value.toString();
					data.append("<td>").append(val).append("</td>\n");
				}
				rows.append("<tr>\n").append(data).append("</tr>\n");
			}
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		table.append(rows).append("</table>");
		return table.toString();
	}
	
	public String generateHTMLTable(Object o) {
		int start = o.toString().indexOf("[");
		int end = o.toString().lastIndexOf("]");
		String[] s = o.toString().substring(start+1, end).split(" ");
		
		StringBuffer table = new StringBuffer("<table>");
		StringBuffer columns = new StringBuffer();
		StringBuffer rows = new StringBuffer();
		StringBuffer data = new StringBuffer();
		for(int i = 0; i < s.length; i++) {
			String title = s[i].split("=")[0];
			columns.append("<th>").append(title).append("</th>\n");
		}
		rows.append("\n<tr>\n").append(columns).append("</tr>\n");
		for(int i = 0; i < s.length; i++) {
			data.append("<td>").append(s[i].split("=")[1]).append("</td>\n");
		}
		rows.append("<tr>\n").append(data).append("</tr>\n");
		table.append(rows).append("</table>");
		return table.toString();
	}
}
