package skillbasedpaysystem;

public class Shift {
    private Integer shiftId;
    private Skill skill;
    private double totalDuration;
    private double breakDuration;



    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public double getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(double breakDuration) {
        this.breakDuration = breakDuration;
    }

    public Shift(Integer shiftId, Skill skill, Long totalDuration, Long breakDuration) {
        this.shiftId = shiftId;
        this.skill = skill;
        this.totalDuration = totalDuration;
        this.breakDuration = breakDuration;
    }
}
