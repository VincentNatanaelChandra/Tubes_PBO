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
    private RescheduleEnum reshedule_status;    

    public Reschedule(int reschedule_id, RescheduleEnum reshedule_status) {
        this.reschedule_id = reschedule_id;
        this.reshedule_status = reshedule_status;
    }

    public int getReschedule_id() {
        return reschedule_id;
    }

    public void setReschedule_id(int reschedule_id) {
        this.reschedule_id = reschedule_id;
    }

    public RescheduleEnum getReshedule_status() {
        return reshedule_status;
    }

    public void setReshedule_status(RescheduleEnum reshedule_status) {
        this.reshedule_status = reshedule_status;
    }
}
