package skillbasedpaysystem;

public class SkillPay {

     private double pay;
     private Skill skill;

    public SkillPay(double pay, Skill skill) {
        this.pay = pay;
        this.skill = skill;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
