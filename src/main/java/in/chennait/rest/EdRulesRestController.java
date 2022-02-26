package in.chennait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.chennait.request.CitizenData;
import in.chennait.response.PlanInfo;
import in.chennait.service.RuleService;

@RestController
public class EdRulesRestController {

	@Autowired
	private RuleService service;

	@PostMapping("/rules")
	public ResponseEntity<PlanInfo> executeRules(@RequestBody CitizenData request) {
		PlanInfo citizenData = service.executeRules(request);
		return new ResponseEntity<PlanInfo>(citizenData, HttpStatus.OK);
	}
}
