package in.chennait.response;

import lombok.Data;

@Data
public class PlanInfo {

	private String name;
	private String ssn;
	private String planName;
	private String planStatus;
	private String startDate;
	private String endDate;
	private Double benefitAmt;
	private String denialReason;
}
