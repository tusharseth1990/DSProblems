package skillbasedpaysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkillBasedPayCalculator {

    private static double skillBasedPayCalc(List<Employee> employees, List<SkillPay> skillPayList){

        double total = 0;
        employees.forEach(employee -> {
            List<Shift> shifts =  employee.getShiftsWorked();
           // Get shift total duration

            shifts.forEach(shift ->  {
                // get Skill pay first
                double skillPayValue = 0L;
               // skillPayList.stream().find(skillPay -> skillPay.getSkill())
                skillPayValue +=  shift.getTotalDuration()  * skillPayList.get(0).getPay() ;
            });

        });
        return  total;
    }

    public static void main(String[] args) {

    List<Shift> shiftWorked = new ArrayList<>();
    Shift shift1 = new Shift(1, Skill.SECURITY,5L , 0L );
    Shift shift2 = new Shift(2, Skill.BAKERY,5L , 0L );
    shiftWorked.add(shift1);
    shiftWorked.add(shift2);
    Employee employee = new Employee(1,shiftWorked,ContractType.PERMANENT);

    SkillPay skillPay1 = new SkillPay(1,Skill.SECURITY);
    SkillPay skillPay2 = new SkillPay(2,Skill.BAKERY);
    List<SkillPay> skillPayList = new ArrayList<>();
    skillPayList.add(skillPay1);
    skillPayList.add(skillPay2);
    SkillBasedPayCalculator.skillBasedPayCalc(List.of(employee), skillPayList);
    }
}
