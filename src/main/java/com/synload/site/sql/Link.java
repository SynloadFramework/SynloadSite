package com.synload.site.sql;

import java.sql.ResultSet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.synload.framework.sql.annotations.*;
import com.synload.framework.sql.Model;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "class")
@SQLTable(name = "Link Model", version = 0.1, description = "links on synload.com that redirect to outside sites")
public class Link extends Model {
	
	@BigIntegerColumn(length = 20, Key = true, AutoIncrement = true)
    public long id;
	
	@BigIntegerColumn(length = 11)
    public long created_date;
	
	@StringColumn(length = 128)
    public String label;
	
	@StringColumn(length = 512)
    public String url;
	
	@BigIntegerColumn(length = 11)
    public long clicks;
	
	public Link(ResultSet rs) {
        super(rs);
    }

    public Link(Object... data) {
        super(data);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreated_date() {
		return created_date;
	}

	public void setCreated_date(long created_date) {
		this.created_date = created_date;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getClicks() {
		return clicks;
	}

	public void setClicks(long clicks) {
		this.clicks = clicks;
	}
    
}
