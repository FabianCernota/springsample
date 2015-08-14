package de.fcernota.spring.sample.model;
	
import com.fasterxml.jackson.annotation.JsonView;

import de.fcernota.spring.sample.util.Views;

public class SampleModel {
	@JsonView(Views.Summary.class)
	int id;
	@JsonView(Views.Summary.class)
	String name;
	@JsonView(Views.Detail.class)
	String example;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}

}
