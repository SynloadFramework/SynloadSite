package com.synload.site.sql;

import java.sql.ResultSet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.synload.framework.modules.annotations.SQLTable;
import com.synload.framework.modules.annotations.sql.BigIntegerColumn;
import com.synload.framework.modules.annotations.sql.LongBlobColumn;
import com.synload.framework.modules.annotations.sql.StringColumn;
import com.synload.framework.sql.Model;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "class")
@SQLTable(name = "Page Model", version = 0.1, description = "pages of the synload.com site")
public class Page extends Model {
	
	@BigIntegerColumn(length = 20, Key = true, AutoIncrement = true)
    public long id;
	
	@BigIntegerColumn(length = 11)
    public long created_date;
	
	@StringColumn(length = 64)
    public String parent;
	
	@StringColumn(length = 128)
    public String parentTemplate;
	
	@StringColumn(length = 128)
    public String template;
	
	@StringColumn(length = 128)
    public String title;
	
	@LongBlobColumn()
    public String body;
	
	@BigIntegerColumn(length = 11)
    public long views;
	
	
	public Page(ResultSet rs) {
        super(rs);
    }

    public Page(Object... data) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParentTemplate() {
		return parentTemplate;
	}

	public void setParentTemplate(String parentTemplate) {
		this.parentTemplate = parentTemplate;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
    
    
}
