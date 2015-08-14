package de.fcernota.spring.sample.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import de.fcernota.spring.sample.model.SampleModel;
import de.fcernota.spring.sample.util.Views;

@RestController
@RequestMapping("/")
public class SampleRest {
	@JsonView(Views.Summary.class)
	@RequestMapping(produces = "application/json")
	public Resources<Resource<SampleModel>> getSampleModels() {
		SampleModel sm1 = new SampleModel();
		sm1.setExample("Hello World");
		sm1.setId(1);
		sm1.setName("Jeff");

		SampleModel sm2 = new SampleModel();
		sm2.setExample("Hello World 2");
		sm2.setId(2);
		sm2.setName("Bob");

		Resource<SampleModel> smr1 = new Resource<>(sm1);
		Resource<SampleModel> smr2 = new Resource<>(sm2);

		List<Resource<SampleModel>> sampleModelList = new ArrayList<>();
		sampleModelList.add(smr1);
		sampleModelList.add(smr2);

		Resources<Resource<SampleModel>> sampleModelListResources = new Resources<>(
				sampleModelList);

		return sampleModelListResources;
	}

	@JsonView(Views.Detail.class)
	@RequestMapping(value = "/samplemodel", produces = "application/json")
	public Resource<SampleModel> getSampleModel() {
		SampleModel sm1 = new SampleModel();
		sm1.setExample("Hello World");
		sm1.setId(1);
		sm1.setName("Jeff");

		Resource<SampleModel> r = new Resource<>(sm1);
		return r;
	}
}
