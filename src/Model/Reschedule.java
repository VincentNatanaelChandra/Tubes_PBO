/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public class Reschedule {
    private int reschedule_id;
    private String reschedule_reason;
    private RescheduleEnum reschedule_status;    

    public Reschedule(int reschedule_id, String reschedule_reason, RescheduleEnum reschedule_status) {
        this.reschedule_id = reschedule_id;
        this.reschedule_reason = reschedule_reason;
        this.reschedule_status = reschedule_status;
    }

    public int getReschedule_id() {
        return reschedule_id;
    }

    public void setReschedule_id(int reschedule_id) {
        this.reschedule_id = reschedule_id;
    }

    public String getReschedule_reason() {
        return reschedule_reason;
    }

    public void setReschedule_reason(String reschedule_reason) {
        this.reschedule_reason = reschedule_reason;
    }

    public RescheduleEnum getReschedule_status() {
        return reschedule_status;
    }

    public void setReschedule_status(RescheduleEnum reschedule_status) {
        this.reschedule_status = reschedule_status;
    }
    
 
    
}
