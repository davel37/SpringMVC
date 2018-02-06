package com.laffey.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {

		return "requestMappingAndParamHome";

	}

	// test 1: Testing the @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test1");

		return "requestMappingAndParamResults";

	}
	// Test 2: Testing @RequestMapping "method" attribute

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingParamTest2(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test2");

		return "requestMappingAndParamResults";

	}

	// Test 3: Testing Request Mapping Fall back feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String requestMappingParamTest3() {

		return "fallback";
	}

	// Test 4: Testing @RequestParam "default value" attribute
	@RequestMapping(value = "/test4")
	public String requestMappingParamTest4(
			@RequestParam(value = "orgName", defaultValue = "Annoymus Organization") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test4");
		return "requestMappingAndParamResults";
	}

	// Test 5: Testing @RequestParam without 'name' or 'value' attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingParamTest5(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test5");

		return "requestMappingAndParamResults";
	}

	// Test 6: Subtest 1: Testing the @RequesMapping
	@RequestMapping(value = "/test6", params = "orgName")
	public String requestMappingParamTest6Subtest1(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test6-subest1");

		return "requestMappingAndParamResults2";

	}

	// Test 6: Subtest 2: Testing the @RequesMapping
	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgName", empcount);
		model.addAttribute("testSerial", "test6-subtest2");

		return "requestMappingAndParamResults2";

	}

	// Test 6: Subtest 3: Testing the @RequesMapping with multiple @RequestParams
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "orgName", "empcount" })
	public String requestMappingParamTest6Subtest3(@RequestParam String orgName, @RequestParam String empcount,
			Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("empCount", empcount);
		model.addAttribute("testSerial", "test6-subtest3");

		return "requestMappingAndParamResults2";

	}
	// Test 6: Subtest 4: Testing with multiple request params and @RequestParam with single param
		@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgName", "empcount" })
		public String requestMappingParamTest6Subtest4(@RequestParam String orgName, 	Model model) {
			model.addAttribute("orgName", orgName);
		
			model.addAttribute("testSerial", "test6-subtest4");

			return "requestMappingAndParamResults2";

		}
		// Test 7 and 8: Testing the @RequestParam with multiple request URI's
			@RequestMapping(value = {"/test7","/test8"}, method = RequestMethod.GET)
			public String requestMappingParamTest6Subtest7and8(@RequestParam String orgName, Model model, HttpServletRequest request) {
				model.addAttribute("orgName", orgName);
				
				LOGGER.info(request.getRequestURL().toString());
				if(request.getRequestURL().toString().contains("test7")) {
					model.addAttribute("testSerial", "test7");
				}
					else {
					model.addAttribute("testSerial", "test8");
					}

				return "requestMappingAndParamResults2";
}
}