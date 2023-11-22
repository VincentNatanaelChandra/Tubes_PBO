/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Devid L Manurung
 */
public class Refund {
    private int refund_id;
    private String refund_reason;
    private RefundEnum refund_status;

    public Refund(int refund_id, String refund_reason, RefundEnum refund_status) {
        this.refund_id = refund_id;
        this.refund_reason = refund_reason;
        this.refund_status = refund_status;
    }

    public int getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(int refund_id) {
        this.refund_id = refund_id;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public RefundEnum getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(RefundEnum refund_status) {
        this.refund_status = refund_status;
    }

    
}
