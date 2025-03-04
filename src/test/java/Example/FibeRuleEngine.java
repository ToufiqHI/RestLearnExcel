package FibrRule;

import lombok.Data;

import java.util.List;

@Data
public class FibeRuleEngine
{
    private String age;
    private int  income;
    private boolean salaried;
    private int residentialCityTier;

    private boolean residentialPinCodeServiceable;
    private int officeCityTier;
    private boolean officePinCodeServiceable;
    private int totalDue;
    private int creditScore;
    private List<DpdCheck> dpdCheck;
    @Data
    public class DpdCheck
    {
        private String year;
        private String month;
        private int daysPastDue;

    }










}
