package skillbasedpaysystem;

import java.util.List;

public class Employee {
    private Integer employeeId;
    private List<Shift> shiftsWorked;
    private ContractType contractType;

    public Employee(Integer employeeId, List<Shift> shiftsWorked, ContractType contractType) {
        this.employeeId = employeeId;
        this.shiftsWorked = shiftsWorked;
        this.contractType = contractType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<Shift> getShiftsWorked() {
        return shiftsWorked;
    }

    public void setShiftsWorked(List<Shift> shiftsWorked) {
        this.shiftsWorked = shiftsWorked;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
