package in.chennait.service;

import org.springframework.stereotype.Service;

import in.chennait.request.CitizenData;
import in.chennait.response.PlanInfo;

@Service
public class RuleService {

	public PlanInfo executeRules(CitizenData request) {

		PlanInfo response = new PlanInfo();
		String planName = request.getPlanName();
		response.setName(request.getName());
		response.setSsn(request.getSsn());
		response.setPlanName(planName);
		Double income = request.getIncome();

		if ("SNAP".equals(planName)) {
			// check snap conditions
			if (income <= 200) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.0);
				response.setStartDate("25-Feb-2022");
				response.setEndDate("25-May-2022");
			} else {
				response.setPlanStatus("DENIED");
				response.setDenialReason("Hign income");
			}
			
		} else if ("CCAP".equals(planName)) {
			String status = request.getKidsEligible();
			if (income <= 200 && "YES".equals(status)) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.0);
				response.setStartDate("25-Feb-2022");
				response.setEndDate("25-May-2022");
			} else {
				response.setPlanStatus("DENIED");
				response.setDenialReason("Hign income or kids age above 16 years");
			}
			// check ccap conditions
		} else if ("Medicaid".equals(planName)) {
			// check medicaid conditions
			if (income <= 300) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.0);
				response.setStartDate("25-Feb-2022");
				response.setEndDate("25-May-2022");

			} else {
				response.setPlanStatus("DENIED");
				response.setDenialReason("Hign income");
			}
		} else if ("Medicare".equals(planName)) {
			// check Medicare condtions
			if (request.getAge() >= 65) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.0);
				response.setStartDate("25-Feb-2022");
				response.setEndDate("25-May-2022");
				
			} else {
				response.setPlanStatus("DENIED");
				response.setDenialReason("Minimum age required 65 yearsold");
			}
		} else if ("KW".equals(planName)) {

			// check KW conditions
			if (request.getEmpStatus().equals("YES")) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.0);
				response.setStartDate("25-Feb-2022");
				response.setEndDate("25-May-2022");

			} else {
				response.setPlanStatus("DENIED");
				response.setDenialReason("Only un employees only can apply");
			}
		}
		return response;
	}

}
