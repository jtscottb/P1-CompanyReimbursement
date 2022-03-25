package com.revature;

import java.util.List;
import java.util.Objects;

public class Table {

	public String generateHTMLTable(List<?> list) {
		StringBuffer table = new StringBuffer("<table class=\"table table-dark table-hover\">");
		StringBuffer columns = new StringBuffer();
		StringBuffer rows = new StringBuffer();
		StringBuffer data = new StringBuffer();
		
		Object o = list.get(0);
		int start = o.toString().indexOf("[");
		int stop = o.toString().lastIndexOf("]");
		String[] s = o.toString().substring(start+1, stop).split(",");
		for(int i = 0; i < s.length; i++) {
			String title = s[i].split("=", 2)[0].trim();
			columns.append("<th scope=\"col\">").append(title).append("</th>\n");
		}
		rows.append("\n<thead>\n<tr>\n").append(columns).append("</tr>\n</thead>\n<tbody>\n");
		
		for(Object obj : list) {
			int begin = obj.toString().indexOf("[");
			int end = obj.toString().lastIndexOf("]");
			s = obj.toString().substring(begin+1, end).split(",");
			for(int i = 0; i < s.length; i++) {
				String value = s[i].split("=", 2)[1].trim();
				String val = Objects.isNull(value) ? "null" : value;
				data.append("<td>").append(val).append("</td>\n");
			}
			rows.append("<tr>\n").append(data).append("</tr>\n");
			data = new StringBuffer("");
		}
		rows.append("</tbody>\n");
		table.append(rows).append("</table>");
		return table.toString();
	}
	
	public String generateHTMLTable(Object o) {
		int start = o.toString().indexOf("[");
		int end = o.toString().lastIndexOf("]");
		String[] s = o.toString().substring(start+1, end).split(",");
		
		StringBuffer table = new StringBuffer("<table class=\"table table-dark table-hover\">");
		StringBuffer columns = new StringBuffer();
		StringBuffer rows = new StringBuffer();
		StringBuffer data = new StringBuffer();
		for(int i = 0; i < s.length; i++) {
			String title = s[i].split("=")[0].trim();
			columns.append("<th scope=\"col\">").append(title).append("</th>\n");
		}
		rows.append("\n<thead>\n<tr>\n").append(columns).append("</tr>\n</thead>\n");
		for(int i = 0; i < s.length; i++) {
			data.append("<td>").append(s[i].split("=")[1].trim()).append("</td>\n");
		}
		rows.append("<tbody>\n<tr>\n").append(data).append("</tr>\n</tbody>\n");
		table.append(rows).append("</table>");
		return table.toString();
	}
}
